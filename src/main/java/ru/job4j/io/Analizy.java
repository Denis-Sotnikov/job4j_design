package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
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

    public static void main(String[] args) throws ParseException, IOException {
        Analizy analizy = new Analizy();
File file = new File("c:\\sdasd.txt");
//        Files.createFile(Paths.get("c:\\sdasd.txt"));
//        Files.createDirectory(Paths.get("c:\\sdasd.txt"));
//        BufferedWriter w = new BufferedWriter(new FileWriter(file));
//        w.write("Hello");
//        BufferedWriter x =  Files.newBufferedWriter(Paths.get("c:\\sdasd.txt"));
//        //x.write();
//        w.close();
//        //BasicFileAttributes v = Files.readAttributes(file, "*");
//        BasicFileAttributeView basicView =
//                Files.getFileAttributeView(file.toPath(), BasicFileAttributeView.class);
//        BasicFileAttributes basicAttribs = basicView.readAttributes();
//        System.out.println(basicAttribs.creationTime());
//        System.out.println(basicAttribs.lastModifiedTime());
//
//        Files.setAttribute(
//                file.toPath(), "lastAccessTime", FileTime.fromMillis(new Date().getTime()));
//
//        Files.setAttribute(
//                file.toPath(), "lastAccessTime", FileTime.fromMillis(new Date().getTime()));
//
//        Files.setAttribute(
//                file.toPath(), "creationTime", new Date().getTime());
//        System.out.println(basicAttribs.lastModifiedTime());
//        System.out.println(basicAttribs.creationTime());
        analizy.unavailable(new File("server.log"), new File("resultAnalizy.log"));
    }
}