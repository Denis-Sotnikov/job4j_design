package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("result.txt"))) {
            List<String> linesis = new ArrayList<String>();
            in.lines().forEach(linesis::add);
            for (String line : linesis) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}