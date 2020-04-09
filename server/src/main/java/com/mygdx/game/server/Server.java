package com.mygdx.game.server;

import java.io.IOException;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("hi from server");
        Scanner sc = new Scanner(System.in);
        while(true) {
            String input = sc.next();
            System.out.println("You typed: " + input);
            switch (input) {
                case "start": {
                    System.out.println("Server is starting...");
                    break;
                }
                case "exit": {
                    System.out.println("Server is shutting down...");
                    System.exit(0);
                }
            }
        }
    }
}
