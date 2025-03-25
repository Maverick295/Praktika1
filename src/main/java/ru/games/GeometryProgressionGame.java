package ru.games;

import ru.GameEngine;
import ru.utils.GameUtil;

import java.util.Random;
import java.util.Scanner;

/**
 * Класс реализующий игру "Геометрическая последовательность".
 * **/
public class GeometryProgressionGame {

  private static final int ROUNDS_COUNT = 3;

  private static final Random RANDOM = new Random();

  /**
   * Запускает игру.
   */
  public static void start() {
    String[][] roundsData = generateRounds();
    new GameEngine().run("What number is missing in the progression?", roundsData);
  }

  /**
   * Генерирует вопросы и правильные ответы для игры.
   *
   * @return Двумерный массив с вопросами и ответами.
   */
  public static String[][] generateRounds() {
    return GameUtil.generateRounds(ROUNDS_COUNT, () -> {
      int length = getRandomLength();
      int start = getRandomStart();
      int ratio = getRandomRatio();
      int hiddenIndex = getRandomHiddenIndex(length);

      int[] progression = generateProgression(length, start, ratio);
      int correctAnswer = progression[hiddenIndex];
      progression[hiddenIndex] = -1;

      return new String[]{formatProgression(progression), String.valueOf(correctAnswer)};
    });
  }

  /**
   * Генерирует случайную длину прогрессии в диапазоне от 5 до 10.
   *
   * @return Длина прогрессии.
   */
  private static int getRandomLength() {
    return RANDOM.nextInt(6) + 5;
  }

  /**
   * Генерирует случайное начальное значение прогрессии в диапазоне от 1 до 5.
   *
   * @return Начальный член прогрессии.
   */
  private static int getRandomStart() {
    return RANDOM.nextInt(5) + 1;
  }

  /**
   * Генерирует случайное значение знаменателя геометрической прогрессии в диапазоне от 2 до 6.
   *
   * @return Знаменатель прогрессии.
   */
  private static int getRandomRatio() {
    return RANDOM.nextInt(5) + 2;
  }

  /**
   * Генерирует случайный индекс элемента, который будет скрыт в прогрессии.
   *
   * @param length Длина прогрессии.
   * @return Индекс скрытого элемента (начиная с 0).
   */
  private static int getRandomHiddenIndex(int length) {
    return RANDOM.nextInt(length);
  }

  /**
   * Генерирует геометрическую прогрессию.
   */
  private static int[] generateProgression(int length, int start, int ratio) {
    int[] progression = new int[length];
    for (int i = 0; i < length; i++) {
      progression[i] = start * (int) Math.pow(ratio, i);
    }
    return progression;
  }

  /**
   * Форматирует прогрессию в строку с пропуском.
   */
  private static String formatProgression(int[] progression) {
    StringBuilder result = new StringBuilder();
    for (int num : progression) {
      result.append(num == -1 ? ".. " : num + " ");
    }
    return result.toString().trim();
  }
}
