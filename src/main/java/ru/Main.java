package ru;

import ru.games.BrainGame;
import ru.games.GeometryProgressionGame;

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
    int choice = getUserChoice();
    startGame(choice);
  }

  /**
   * Запрашивает у пользователя выбор игры.
   *
   * @return Число, соответствующее выбранной игре.
   */
  private static int getUserChoice() {
    System.out.println("Choose game: \n 1. Brain game \n 2. Geometry progression game");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  /**
   * Запускает выбранную пользователем игру.
   *
   * @param choice Выбор пользователя (номер игры).
   */
  private static void startGame(int choice) {
    switch (choice) {
      case 1 -> BrainGame.start();
      case 2 -> GeometryProgressionGame.start();
      default -> System.out.println("Invalid choice");
    }
  }
}