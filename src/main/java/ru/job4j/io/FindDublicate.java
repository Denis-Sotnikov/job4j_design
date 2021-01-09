package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FindDublicate {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get("C:\\projects\\job4j_design");
        List<Path> dublicates = new ArrayList<>();
        SearchDublicates searchDublicates = new SearchDublicates();
        Files.walkFileTree(start, searchDublicates);
        dublicates = searchDublicates.getPaths();
        for (int i = 0; i < dublicates.size(); i++) {
            System.out.println(dublicates.get(i).toFile().getName());
        }
    }
}
