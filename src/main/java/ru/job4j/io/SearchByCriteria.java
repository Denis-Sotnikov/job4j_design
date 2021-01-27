package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SearchByCriteria {
        public static void main(String[] args) throws Exception {
            List<Path> list = new ArrayList<>();
            Path start = Paths.get(args[SearchByCriteria.searchIndex("-d", args)]);
            switch (caseChoice(args)) {
                case 1:
                    list = search(start, args[SearchByCriteria.searchIndex("-n", args)]);
                    break;
                case 2:
                    list = searchByCompleteMatchName(
                            start, args[SearchByCriteria.searchIndex("-n", args)]);
                    break;
                case 3:
                    list = searchByRegular(
                            start, args[SearchByCriteria.searchIndex("-n", args)]);
                    break;
                default:
                    System.out.println("Error");
            }
            writeToFile("-o", args, list);
        }

        public static List<Path> search(Path root, String ext) throws IOException {
            SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
            Files.walkFileTree(root, searcher);
            return searcher.getPaths();
        }

        public static List<Path> searchByCompleteMatchName(
                Path root, String name) throws IOException {
            SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().equals(name));
            Files.walkFileTree(root, searcher);
            return searcher.getPaths();
        }

        public static List<Path> searchByRegular(Path root, String regular) throws IOException {
            SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().matches(regular));
            Files.walkFileTree(root, searcher);
            return searcher.getPaths();
        }

        private static int caseChoice(String[] array) throws Exception {
            try {
                if (searchIndex("-m", array) != 0) {
                    return 1;
                }
            } catch (Exception e) {
                //e.printStackTrace(); Печатаем в log
            }
            try {
                if (searchIndex("-f", array) != 0) {
                    return 2;
                }
            } catch (Exception e) {
                //e.printStackTrace(); Печатаем в log
            }
            try {
                if (searchIndex("-r", array) != 0) {
                    return 3;
                }
            } catch (Exception e) {
                //e.printStackTrace(); Печатаем в log
            }
            throw new Exception();
        }

        private static int searchIndex(String val, String[] array) throws Exception {
        Integer y = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(val)) {
                y = i + 1;
            }
        }
        if (y == null) {
            throw new Exception();
        }
        return y;
    }

        private static void writeToFile(
                String val, String[] array, List<Path> list) throws Exception {
            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter(new File(array[searchIndex(val, array)])))) {
                list.stream().forEach(x -> {
                    try {
                        writer.write(x.toString());
                        writer.write('\n');
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
}
