package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        List<String> linesis = new ArrayList<String>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            in.lines().forEach(linesis::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String s : linesis) {
            if (!s.startsWith("#") && s.contains("=")) {
                String[] points = s.split("=");
                if (points.length <= 2) {
                    values.put(points[0], points[1]);
                }
            }
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("app.properties.txt");
        config.load();
    }
}