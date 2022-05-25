package ru.geekbrains.java_2.homework.lesson6.hw;

import java.io.*;
import java.net.Socket;

public class ServerOption extends Thread {
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public ServerOption(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }

    @Override
    public void run() {
        String message;
        try {
            message = in.readLine();
            try {
                out.write(message + "\n");
                out.flush();
            } catch (IOException ignored) {
            }
            try {
                while (true) {
                    message = in.readLine();
                    if (message.equals("/stop")) {
                        this.shutdown();
                        break;
                    }
                    System.out.println("Echoing: " + message);
                    for (ServerOption so : Server.serverList) {
                        so.send(message);
                    }
                }
            } catch (NullPointerException ignored) {
            }
        } catch (IOException e) {
            this.shutdown();
        }
    }

    private void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {}
    }

    private void shutdown() {
        try {
            if(!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
                for (ServerOption so : Server.serverList) {
                    if(so.equals(this)) so.interrupt();
                    Server.serverList.remove(this);
                }
            }
        } catch (IOException ignored) {}
    }

}
