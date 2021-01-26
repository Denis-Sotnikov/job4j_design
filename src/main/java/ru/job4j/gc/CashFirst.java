package ru.job4j.gc;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class CashFirst<V extends Reference> implements CashByReference {
    private Map<String, V> mapForCash =  new HashMap<>();

    @Override
    public void add(String key, Reference val) {
        mapForCash.put(key, (V) val);
    }

    @Override
    public boolean remove(String key) {
        return mapForCash.remove(key) != null;
    }

    @Override
    public V get(String key) {
        return  mapForCash.get(key);
    }

    public static void main(String[] args) {
//        CashFirst<Reference> a = new CashFirst<>();
//        SoftReference softReference = new SoftReference("SoftReference");
//        WeakReference weakReference = new WeakReference("WeakReference");
//        a.add("first", softReference);
//        a.add("second", weakReference);
//        for (Map.Entry<String, Reference> v : a.mapForCash.entrySet()) {
//            System.out.println(v.getValue().get());
//        }
//        System.out.println(a.get("first").get());
//        System.out.println(a.remove("first"));
    }
}
