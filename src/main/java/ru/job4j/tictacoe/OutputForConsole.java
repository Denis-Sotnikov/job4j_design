package ru.job4j.tictacoe;

import ru.job4j.tictacoe.interfaice.Output;

public class OutputForConsole implements Output<Boolean> {

    @Override
    public void print(Boolean[][] array) {
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
