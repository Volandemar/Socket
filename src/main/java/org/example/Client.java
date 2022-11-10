package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.Provider;

public class Client {
    protected static int port = 8080;
    protected static String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        clientServer(port, HOST);
    }

    public static void clientServer(int port, String HOST) throws IOException {
        try (Socket clientSocket = new Socket(HOST, port)) {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Подключение произведено");
            String name = in.readLine();
            System.out.println(name);
            System.out.println("Конец");
        }

    }
}
