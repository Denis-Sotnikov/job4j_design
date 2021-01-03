package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashMap<K, V> implements Iterable {
    private ArrayForMap<V> array = new ArrayForMap<V>(16);
    private K key;
    private V val;

    boolean insert(K key, V value){
        array.increasingArrayForMap();
        int index = key.hashCode() % array.size();
        if (array.getForMap(index) == null) {
            ArrayForMap.Node node = new ArrayForMap.Node(key.hashCode(), value, null);
            array.addAtIndexForMap(index, node);
            return true;
        }
        return false;
    }
    V get(K key){
        int index = key.hashCode() % array.size();
        if (array.getForMap(index) != null) {
            if(key.hashCode() == array.getForMap(index).getHashCode())
            return array.getForMapValue(index);
        }
        return null;
    }

    boolean delete(K key) {
        int index = key.hashCode() % array.size();
        if (array.getForMap(index) != null) {
            array.remove(index);
            return true;
        }
        return false;
    }

    public int size() {
        return array.size();
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int cursor = 0;
            @Override
            public boolean hasNext() {
                while(cursor < array.size() && array.getForMap(cursor) == null) {
                    ++cursor;
                }
                if (cursor <= 15) {
                    return array.getForMap(cursor) != null ? true : false;
                } else {
                    return false;
                }
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array.getForMap(cursor++).getValue();
            }
        };
    }


    public static void main(String[] args) {
        MyHashMap<String, Integer> myMap = new MyHashMap<>();
        System.out.println("size = " + myMap.size());
        myMap.insert("Hello", 1);
        myMap.insert("lo", 2);
        //myMap.delete("lo");
        myMap.insert("o", 3);
        System.out.println("Hello = " + myMap.get("Hello"));
        System.out.println("o = " + myMap.get("o"));
        System.out.println("size = " + myMap.size());
        Iterator it = myMap.iterator();
        while (it.hasNext()) {
            System.out.println("it.next() = " + it.next());
        }
    }
}

