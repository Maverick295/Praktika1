package ru;

import java.util.Scanner;

/**
 * Класс GameEngine отвечает за управление игровым процессом.
 * Он содержит методы для запуска игры, обработки раундов и взаимодействия с пользователем.
 */
public class GameEngine {

    private static final int ROUNDS_COUNT = 3;

    private final Scanner scanner;

    /**
     * Конструктор GameEngine инициализирует сканер для считывания пользовательского ввода.
     */
    public GameEngine() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Запускает игру с переданными описанием и раундами.
     *
     * @param gameDescription Описание игры, которое выводится в начале.
     * @param roundsData      Массив с вопросами и правильными ответами.
     */
    public void run(String gameDescription, String[][] roundsData) {
        String playerName = greetPlayer();
        System.out.println(gameDescription + "\n");

        for (String[] round : roundsData) {
            if (!playRound(playerName, round)) {
                return;
            }
        }
        congratulatePlayer(playerName);
    }

    /**
     * Приветствует игрока и запрашивает его имя.
     *
     * @return Введенное имя игрока.
     */
    private String greetPlayer() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    /**
     * Запускает один раунд игры.
     *
     * @param playerName Имя игрока.
     * @param round      Массив с вопросом и правильным ответом.
     * @return true, если игрок ответил правильно, иначе false.
     */
    private boolean playRound(String playerName, String[] round) {
        System.out.println("Question: " + round[0]);
        System.out.print("Your answer: ");
        String answer = scanner.nextLine();

        if (answer.equals(round[1])) {
            System.out.println("Correct!\n");
            return true;
        } else {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + round[1] + "'.");
            System.out.println("Let's try again, " + playerName + "!");
            return false;
        }
    }

    /**
     * Поздравляет игрока с победой.
     *
     * @param playerName Имя игрока.
     */
    private void congratulatePlayer(String playerName) {
        System.out.println("Congratulations, " + playerName + "!");
    }
}
