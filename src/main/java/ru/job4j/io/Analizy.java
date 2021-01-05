package ru.job4j.io;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Analizy {
    private List<String> listStatus = new LinkedList<>();
    private List<String> listUnavailable = new LinkedList<>();

    public void unavailable(String source, String target) throws ParseException {
        anavailable(source, target);
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            for (int i = 0; i < listUnavailable.size(); i++) {
                if (i % 2 != 0) {
                    out.write(listUnavailable.get(i));
                    out.write("\n");
                    System.out.print(listUnavailable.get(i));
                    System.out.println();
                } else {
                    out.write(listUnavailable.get(i) + " : ");
                    System.out.print(listUnavailable.get(i) + " : ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void anavailable(String source, String target) throws ParseException {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            List<String> linesis = new ArrayList<String>();
            in.lines().forEach(linesis::add);
            for (String line : linesis) {
                if (line.contains(":")) {
                    listStatus.add(line);
                    String[] array = line.split(" ");
                    String value = array[0];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String w : this.listStatus) {
            String[] array = w.split(" ");
            if (Integer.parseInt(array[0]) == 400 || Integer.parseInt(array[0]) == 500) {
                if (listUnavailable.size() % 2 == 0) {
                    listUnavailable.add(array[1]);
                }
            } else {
                if (Integer.parseInt(array[0]) == 200 || Integer.parseInt(array[0]) == 300) {
                    if (listUnavailable.size() % 2 != 0) {
                        listUnavailable.add(array[1]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", "resultAnalizy.log");
//        analizy.anavailable("server.log", "resultAnalizy");
        for (String w : analizy.listStatus) {
            System.out.println(w);
        }

        for (String w : analizy.listUnavailable) {
            System.out.println(w);
        }
//        Date t = new Date();
//        DateFormat df = new SimpleDateFormat("HH:mm:ss");
//        t = df.parse("15:08:10");
//        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
//        System.out.println("hare = " + time.format(t));
//        System.out.println(df.format(t));

    }
}