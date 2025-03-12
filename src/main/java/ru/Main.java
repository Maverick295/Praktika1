package ru;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Choose game: \n 1. Brain game \n 2. Geometry progression game");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                BrainGameLCM lcm = new BrainGameLCM();
                lcm.run(sc);
                break;
            case 2:
                GeometryProgressionGame game = new GeometryProgressionGame();
                game.run(sc);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}