package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    protected String reader(String key, String path) throws IOException {
        StringBuilder val = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path + key)))) {
            while (reader.ready()) {
                val = val.append(reader.readLine());
            }
            return val.toString();
        }
    }
}
