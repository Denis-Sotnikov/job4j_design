package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private List<String> answers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        try (BufferedWriter out = new BufferedWriter(
                new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            load(botAnswers);
            boolean flag = true;
            boolean answer = true;
            while (flag) {
                String value = scanner.nextLine();
                out.write(value + System.lineSeparator());
                if (value.equals(OUT)) {
                    return;
                }
                if (value.equals(STOP)) {
                    answer = false;
                }
                if (value.equals(CONTINUE)) {
                    answer = true;
                }
                if (answer) {
                    String point = answers.get((int) (Math.random() * 10));
                    System.out.println(point);
                    out.write(point + System.lineSeparator());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load(String pathAnswers) {
        try (
                BufferedReader in = new BufferedReader(
                        new FileReader(pathAnswers, Charset.forName("WINDOWS-1251")))) {
            in.lines().forEach(s -> answers.add(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("dialogWithBot.txt", "answers1251.txt");
        cc.run();
    }
}
