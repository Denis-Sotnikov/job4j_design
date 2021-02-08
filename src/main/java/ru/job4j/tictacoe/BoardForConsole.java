package ru.job4j.tictacoe;

import ru.job4j.tictacoe.interfaice.Board;

public class BoardForConsole implements Board {
    Boolean[][] array = new Boolean[3][3];
    @Override
    public Boolean[][] getConditionBoard() {
        return this.array;
    }

    @Override
    public boolean setValue(int val1, int val2, Object val3) {
            if (array[val1][val2] == null) {
                array[val1][val2] = (Boolean) val3;
                return true;
            }
        return false;
    }

    @Override
    public void draw() {
        System.out.println("-------");
        for (int i = 0; i < array.length; i++) {
            System.out.print("|");
            if (array[i][0] == null) {
                System.out.print(" " + "|");
            } else if (!array[i][0]) {
                System.out.print("o" + "|");
            } else if (array[i][0]) {
                System.out.print("x" + "|");
            }

            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j] == null) {
                    System.out.print(" " + "|");
                } else if (!array[i][j]) {
                    System.out.print("o" + "|");
                } else if (array[i][j]) {
                    System.out.print("x" + "|");
                }
            }
            System.out.println();
            if (i != array.length - 1) {
                System.out.println("-------");
            }
        }
        System.out.println("-------");
    }
}
