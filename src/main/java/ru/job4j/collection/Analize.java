package ru.job4j.collection;

import java.io.*;
import java.io.Console;
import java.nio.CharBuffer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, User> mapaForUser = new HashMap<>();
        Info info = new Info();
        for (User q : current) {
            mapaForUser.put(q.id, q);
        }
        for (User q : previous) {
            if (mapaForUser.containsKey(q.id)) {
                if (!mapaForUser.get(q.id).name.equals(q.name)) {
                    info.changed++;
                }
            } else {
                info.deleted++;
            }
        }
        info.added = current.size() - (previous.size() - info.deleted);
        return info;
    }

    public static class User {
        private Integer id;
        private String name;

        public User() {
        }

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        private int added;
        private int changed;
        private int deleted;

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }

        @Override
        public String toString() {
            return "Info{"
                    + "added="
                    + added
                    + ", changed="
                    + changed
                    + ", deleted="
                    + deleted
                    + '}';
        }
    }

    public static void main(String[] args) throws IOException {
        List<User> first = new ArrayList<>();
        first.add(new User(1, "Sergey"));
        first.add(new User(2, "Vadim"));
        first.add(new User(3, "Denis"));
        first.add(new User(4, "Vika"));
        first.add(new User(5, "Olga"));
        first.add(new User(6, "Sasha"));
        first.add(new User(7, "Nastya"));
        first.add(new User(8, "Stasya"));
        List<User> second = new ArrayList<>();
        second.add(new User(1, "Sergey"));
        second.add(new User(2, "Nika"));
        second.add(new User(3, "Denis"));
        second.add(new User(4, "Vika"));
        second.add(new User(5, "Francheska"));
        second.add(new User(6, "Sasha"));
        second.add(new User(7, "Nastya"));
        second.add(new User(10, "Polina"));
        Info info = new Analize().diff(first, second);
        System.out.println(info);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        reader.readLine();
        System.console().readLine();
        Console c = System.console();
//        Reader reader1 = console.reader();
//        reader1.read(CharBuffer.wrap("про"));
        //System.out.println(reader1.read());
       String a = c.readLine("User name:");
        new DataInputStream(new FileInputStream(new File("")));
       //
    }
}