package ru;

import java.util.Random;
import java.util.Scanner;

/**
 * Класс реализующий игру "Геометрическая последовательность".
 * **/
public final class GeometryProgressionGame {

  /**
   * Запускает игру.
   *
   * @param scanner - считывает знания с консоли
   **/
  public void run(Scanner scanner) {
    final Random random = new Random();

    System.out.println("Welcome to the Brain Games!");
    System.out.print("May I have your name? ");
    scanner.nextLine();
    String name = scanner.nextLine();
    System.out.println("Hello, " + name + "!");
    System.out.println("What number is missing in the progression?\n");

    for (int i = 0; i < 3; i++) {
      int length = random.nextInt(6) + 5;
      int start = random.nextInt(5) + 1;
      int ratio = random.nextInt(5) + 2;
      int hiddenIndex = random.nextInt(length);

      int[] progression = new int[length];

      for (int j = 0; j < length; j++) {
        progression[j] = start * (int) Math.pow(ratio, j);
      }

      final int correctAnswer = progression[hiddenIndex];
      progression[hiddenIndex] = -1;

      System.out.print("Question: ");
      for (int num : progression) {
        if (num == -1) {
          System.out.print(".. ");
        } else {
          System.out.print(num + " ");
        }
      }
      System.out.println();

      System.out.print("Your answer: ");
      int answer = scanner.nextInt();

      if (answer == correctAnswer) {
        System.out.println("Correct!\n");
      } else {
        System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + name + "!");
        scanner.close();
        return;
      }
    }

    System.out.println("Congratulations, "  + name + "!");
    scanner.close();
  }
}
