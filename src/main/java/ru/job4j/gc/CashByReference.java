package ru.job4j.gc;

import java.io.IOException;
import java.lang.ref.Reference;

public interface CashByReference {

    public void add(String key, String val);

    public boolean remove(String key);

    public String get(String key) throws IOException;
}
