package ru.games;

import ru.GameEngine;

import java.util.Random;
import java.util.Scanner;

/**
 * Класс BrainGame реализует логику игры, где игрок должен найти НОК (наименьшее общее кратное).
 */
public class BrainGame {

  private static final int ROUNDS_COUNT = 3;

  private static final Random RANDOM = new Random();

  /**
   * Запускает игру.
   */
  public static void start() {
    String[][] roundsData = generateRounds();
    new GameEngine().run("Find the smallest common multiple of given numbers.", roundsData);
  }

  /**
   * Генерирует вопросы и правильные ответы для игры.
   *
   * @return Двумерный массив с вопросами и ответами.
   */
  private static String[][] generateRounds() {
    String[][] roundsData = new String[ROUNDS_COUNT][2];
    for (int i = 0; i < ROUNDS_COUNT; i++) {
      roundsData[i] = generateRound();
    }
    return roundsData;
  }

  /**
   * Генерирует один раунд игры (три случайных числа и их НОК).
   *
   * @return Массив из вопроса и правильного ответа.
   */
  private static String[] generateRound() {
    int num1 = getRandomNumber();
    int num2 = getRandomNumber();
    int num3 = getRandomNumber();
    int correctAnswer = lcm(num1, lcm(num2, num3));

    return new String[]{num1 + " " + num2 + " " + num3, String.valueOf(correctAnswer)};
  }

  /**
   * Возвращает случайное число от 1 до 20.
   */
  private static int getRandomNumber() {
    return RANDOM.nextInt(20) + 1;
  }

  /**
   * Вычисляет наибольший общий делитель (НОД).
   */
  private static int gcd(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }

  /**
   * Вычисляет наименьшее общее кратное (НОК).
   */
  private static int lcm(int a, int b) {
    return a * (b / gcd(a, b));
  }
}

