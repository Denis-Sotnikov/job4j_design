package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, User> mapaForUserPrevious = previous.stream()
                .collect(Collectors.toMap(k -> k.id, k -> k));
        Map<Integer, User> mapaForUserCurrent = current.stream()
                .collect(Collectors.toMap(k -> k.id, v -> v));

        for (User s : current) {
            if (!mapaForUserPrevious.containsKey(s.id)) {
                info.added++;
            }
        }

        for (User s : previous) {
            if (mapaForUserCurrent.containsKey(s.id)) {
                System.out.println(s.id + " " + s.name);
                if (!s.name.equals(mapaForUserCurrent.get(s.id).name)) {
                    info.changed++;
                }
            } else {
                info.deleted++;
            }
        }
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

    public static void main(String[] args) {
//        List<User> first = new ArrayList<>();
//        first.add(new User(1,"Sergey"));
//        first.add(new User(2,"Vadim"));
//        first.add(new User(3,"Denis"));
//        first.add(new User(4,"Vika"));
//        first.add(new User(5,"Olga"));
//        first.add(new User(6,"Sasha"));
//        first.add(new User(7,"Nastya"));
//        first.add(new User(8,"Stasya"));
//        List<User> second = new ArrayList<>();
//        second.add(new User(1,"Sergey"));
//        second.add(new User(2,"Nika"));
//        second.add(new User(3,"Denis"));
//        second.add(new User(4,"Vika"));
//        second.add(new User(5,"Francheska"));
//        second.add(new User(6,"Sasha"));
//        second.add(new User(7,"Nastya"));
//        second.add(new User(10,"Polina"));
//        Info info = new Analize().diff(first, second);
//        System.out.println(info);
    }
}