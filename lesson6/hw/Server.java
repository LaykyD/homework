package ru.geekbrains.java_2.homework.lesson6.hw;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    private static final int PORT = 8189;
    public static LinkedList<ServerOption> serverList = new LinkedList<>();


    public void start() throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started");
        System.out.println("Waiting for connection....");
        try {
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");
                serverList.add(new ServerOption(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Server().start();
    }
}

