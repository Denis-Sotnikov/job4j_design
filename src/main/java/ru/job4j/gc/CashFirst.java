package ru.job4j.gc;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class CashFirst implements CashByReference {
    private String path;
    private Reader reader = new Reader();
    private Map<String, SoftReference<String>> cache = new HashMap<>();

    public CashFirst() {
    }

    public CashFirst(String path) {
        this.path = path;
    }

    public void add(String key, String val) {
        cache.put(key, new SoftReference<>(val));
    }

    public boolean remove(String key) {
        return cache.remove(key) != null;
    }

    @Override
    public String get(String key) throws IOException {
        String s = cache.getOrDefault(key, new SoftReference<String>("")).get();
        if (s.length() == 0) {
            System.out.println("here");
            s = reader.reader(key, path);
            cache.put(key, new SoftReference<>(s));
        }
        return s;
    }

    public static void main(String[] args) throws IOException {
        CashFirst a = new CashFirst("c:/disk/");
        System.out.println(a.get("clear.txt"));
        System.out.println(a.get("clear.txt"));
    }
}
