package ru.job4j.io.searchbycriteria;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ResultWriter {

    protected static void writeToFile(
            String val, List<Path> list) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(new File(val)))) {
            list.stream().forEach(x -> {
                try {
                    writer.write(x.toString());
                    writer.write(System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
