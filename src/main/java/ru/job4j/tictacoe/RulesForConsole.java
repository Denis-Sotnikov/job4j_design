package ru.job4j.tictacoe;

import ru.job4j.tictacoe.interfaice.Rules;

public class RulesForConsole<T> implements Rules<Boolean> {
    @Override
    public boolean getResult(Boolean[][] val1, Boolean val2) {
        return isWin(val1, val2);
    }

    public static boolean monoHorizontal(Boolean[][] board, int row, boolean val) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == null) {
                result = false;
            } else {
                if (board[row][i] != val) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static boolean monoVertical(Boolean[][] board, int column, boolean val) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == null) {
                return false;
            } else {
                if (board[i][column] != val) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static boolean isWin(Boolean[][] board, boolean val) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == null) {
                continue;
            } else {
                if (board[i][i] == val) {
                    if (monoHorizontal(board, i, val) || monoVertical(board, i, val)) {
                        result = true;
                        break;
                    }
                }
            }

        }
        return result;
    }
}
