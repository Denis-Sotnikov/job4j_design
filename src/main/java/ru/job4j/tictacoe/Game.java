package ru.job4j.tictacoe;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {
        ReadPosition readPosition = new ReadPosition();
        PlayerForConsole one = new PlayerForConsole(true, readPosition);
        PlayerForConsole two = new PlayerForConsole(false, readPosition);
        BoardForConsole board = new BoardForConsole();
        RulesForConsole rules = new RulesForConsole();
        ConsoleMarkX markX = new ConsoleMarkX();
        ConsoleMarkO markO = new ConsoleMarkO();

        boolean flag = false;
        while (!flag) {
            System.out.println("ходит первый игрок");
            one.move(board, one.getIn());
            flag = rules.getResult(board.getConditionBoard(), one.getSide());
            board.draw();
            if (flag) {
                System.out.println("Игрок 1 выиграл");
                return;
            }
            System.out.println("ходит второй игрок");
            two.move(board, two.getIn());
            board.draw();
            flag = rules.getResult(board.getConditionBoard(), two.getSide());
            if (flag) {
                System.out.println("Игрок 2 выиграл");
                return;
            }
        }
    }
}
