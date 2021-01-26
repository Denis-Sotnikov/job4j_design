package ru.job4j.gc;

import java.lang.ref.Reference;

public interface CashByReference<V extends Reference> {

    public void add(String key, V val);

    public boolean remove(String key);

    public V get(String key);
}
