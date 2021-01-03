package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 1; i < 11; i++) {
                for (int j = 1; j <= 10; j++) {
                    System.out.print(i*j + " ");
                    var val = i*j;
                    String letter = String.valueOf(val);
                    letter = letter + " ";
                    out.write(letter.getBytes());
                }
                System.out.println();
                out.write('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }

