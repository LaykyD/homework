package ru.geekbrains.java_2.homework.lesson6.hw;

import java.io.*;
import java.net.Socket;

public class ClientOption {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private BufferedReader inputUser;
    private String HOST;
    private int PORT;
    private String nick;

    public ClientOption(String HOST, int PORT) {
        this.HOST = HOST;
        this.PORT = PORT;
        try {
            this.socket = new Socket(HOST, PORT);
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
        try {
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.pressNick();
            new ReadMsg().start();
            new WriteMsg().start();
        } catch (IOException e) {
            ClientOption.this.shutdown();
        }
    }

    private void pressNick() {
        System.out.print("Press your nick: ");
        try {
            nick = inputUser.readLine();
            out.write("Hi " + nick + ", enter your message >>>>> " + "\n");
            out.flush();
        } catch (IOException ignored) {}
    }

    private void shutdown() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {}
    }

    private class ReadMsg extends Thread {
        @Override
        public void run() {
            String str;
            try {
                while (true) {
                    str = in.readLine();
                    if (str.equals("/stop")) {
                        ClientOption.this.shutdown();
                        break;
                    }
                    System.out.println(str);
                }
            } catch (IOException e) {
                ClientOption.this.shutdown();
            }
        }
    }

    public class WriteMsg extends Thread {
        @Override
        public void run() {
            while (true) {
                String userWord;
                try {
                    userWord = inputUser.readLine();
                    if (userWord.equals("/stop")) {
                        out.write("/stop" + "\n");
                        ClientOption.this.shutdown();
                        break;
                    } else {
                        out.write(nick + ": " + userWord + "\n");
                    }
                    out.flush();
                } catch (IOException e) {
                    ClientOption.this.shutdown();
                }
            }
        }
    }

}


