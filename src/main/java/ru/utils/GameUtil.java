package ru.utils;

public class GameUtil {

    /**
     * Генерирует раунды игры.
     *
     * @param roundsCount Количество раундов.
     * @param roundGenerator Метод для генерации одного раунда.
     * @return Массив всех раундов.
     */
    public static String[][] generateRounds(int roundsCount, RoundGenerator roundGenerator) {
        String[][] roundsData = new String[roundsCount][2];
        for (int i = 0; i < roundsCount; i++) {
            roundsData[i] = roundGenerator.generateRound();
        }
        return roundsData;
    }

    /**
     * Интерфейс для генерации раунда игры.
     */
    public interface RoundGenerator {
        String[] generateRound();
    }
}
