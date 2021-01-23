package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cash<List> {
    private String path =  "c:/disk/";
    private Map<String, SoftReference<ArrayList<String>>> cacheMap = new ConcurrentHashMap<>();

    public ArrayList<String> get(String key) throws IOException {
        SoftReference<ArrayList<String>> softReference = cacheMap.get(key);
        if (softReference != null) {
            return softReference.get();
        } else {
            return write(key);
        }
    }

    public ArrayList<String> put(String key, SoftReference<ArrayList<String>> value) {
        SoftReference<ArrayList<String>> softReference = cacheMap.put(key, value);
        if (softReference != null) {
            return softReference.get();
        } else {
            return null;
        }

    }

    public ArrayList<String> remove(String key) {
        SoftReference<ArrayList<String>> softReference = cacheMap.remove(key);
        if (softReference != null) {
             return softReference.get();
        } else {
            return null;
        }
    }

    public ArrayList<String> write(String key) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path + key)))) {
            while (reader.ready()) {
                list.add(reader.readLine());
            }
        }
        SoftReference<ArrayList<String>> buf = new SoftReference<ArrayList<String>>(list);
        cacheMap.put(key, buf);
        return list;
    }

    public static void main(String[] args) throws IOException {
        Cash<ArrayList<String>> cash = new Cash<>();
        cash.get("doc.txt");
//        ArrayList<String> list = new ArrayList<>();
//        SoftReference<ArrayList<String>> buf = new SoftReference<ArrayList<String>>(list);
//        BufferedReader reader = new BufferedReader(new FileReader(new File(name)));
//        while (reader.ready()) {
//            list.add(reader.readLine());
//        }
//        cash.cacheMap.put(name, buf);
//        cash.cacheMap.get(name);
    }
}
