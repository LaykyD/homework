package ru.geekbrains.java_2.homework.lesson6.hw;

public class Client {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8189;

    public static void main(String[] args) {
        new ClientOption(HOST, PORT);
    }
}
