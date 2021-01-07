package ru.job4j.io;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Analizy {
    private List<String> listStatus = new LinkedList<>();
    private List<String> listUnavailable = new LinkedList<>();

    public void unavailable(File source, File target) throws ParseException {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            out.write(anavailable(source, target));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String anavailable(File source, File target) throws ParseException {
        StringBuilder builder = new StringBuilder();
        Boolean availableServer = true;
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            while (in.ready()) {
                String value = in.readLine();
                if (availableServer) {
                    if (value.contains("400") || value.contains("500")) {
                        availableServer = false;
                        String[] array = value.split(" ");
                        builder.append(array[1]);
                        builder.append(" : ");
                    }
                } else {
                    if (value.contains("200") || value.contains("300")) {
                        availableServer = true;
                        String[] array = value.split(" ");
                        builder.append(array[1]);
                        builder.append("\n");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
return builder.toString();
    }

    public static void main(String[] args) throws ParseException {
        Analizy analizy = new Analizy();
        analizy.unavailable(new File("server.log"), new File("resultAnalizy.log"));
    }
}