package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> arrayForReturn = new ArrayList<String>();
//        List<String> forReturn = new ArrayList<String>();
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            List<String> array = new ArrayList<String>();
//            forReturn = in.lines()
//                    .filter(s->s.split(" ")[s.split(" ").length-2].equals("404"))
//                    .collect(Collectors.toList());
            in.lines().forEach(array::add);
            for (String line : array) {
                String[] box = line.split(" ");
                if (box[box.length - 2].equals("404")) {
                    arrayForReturn.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayForReturn;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}