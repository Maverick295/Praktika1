package ru;

import java.util.Random;
import java.util.Scanner;

/**
 * Класс реализующий игру "НОК".
 * **/
public final class BrainGame {

  /**
   * Запускает игру.
   *
   * @param scanner - считывает значения с консоли
   **/
  public void run(Scanner scanner) {
    final Random random = new Random();

    System.out.println("Welcome to the Brain Games!");
    System.out.print("May I have your name? ");
    scanner.nextLine();
    String name = scanner.nextLine();
    System.out.println("Hello, " + name + "!");
    System.out.println("Find the smallest common multiple of given numbers.\n");

    for (int i = 0; i < 3; i++) {
      int num1 = random.nextInt(20) + 1;
      int num2 = random.nextInt(20) + 1;
      int num3 = random.nextInt(20) + 1;

      System.out.println("Question: " + num1 + " " + num2 + " " + num3);
      System.out.print("Your answer: ");
      int answer = scanner.nextInt();

      int correctAnswer = lcm(num1, lcm(num2, num3));

      if (answer == correctAnswer) {
        System.out.println("Correct!\n");
      } else {
        System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + name + "!");
        scanner.close();
        return;
      }
    }

    System.out.println("Congratulations, " + name + "!");
    scanner.close();
  }

  /**
   * Находит наибольший общий делитель.
   *
   * @param a - значение 1
   * @param b - значение 2
   **/
  public static int gcd(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }

  /**
   * Находит наименьшее общее кратное.
   *
   * @param a - значение 1
   * @param b - значение 2
   * @return наименьшее общее кратное
   */
  public static int lcm(int a, int b) {
    return a * (b / gcd(a, b));
  }
}

