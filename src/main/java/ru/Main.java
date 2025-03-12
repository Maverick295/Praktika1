package ru;

import java.util.Scanner;

/**
 * Main класс.
 **/
public class Main {

  /**
   * Точка входа в программу.
   *
   * @param args - массив строк, которые передаются в приложение при его запуске (не используется)
   **/
  public static void main(String[] args) {
    System.out.println("Choose game: \n 1. Brain game \n 2. Geometry progression game");
    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();
    switch (choice) {
      case 1:
        BrainGame lcm = new BrainGame();
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