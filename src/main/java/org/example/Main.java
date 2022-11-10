package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    protected static int port = 8080;

    public static void main(String[] args) throws IOException {
            server(port);
    }

    public static void server(int port) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Запуск сервера");
            try (Socket clientSocket = serverSocket.accept()) {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println(in.readLine());
                out.println("Добро пожаловать на сервер. Ваш порт: " + clientSocket.getPort());

            }
        }
    }
}