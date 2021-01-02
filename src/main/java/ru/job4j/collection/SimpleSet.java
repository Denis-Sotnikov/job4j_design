package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable {
    private SimpleArray<T> array = new SimpleArray<>();

    public boolean add(T element) {
        if (check(element)) {
            array.add(element);
            return true;
        }
        return false;
    }

    public boolean check(T element) {
        Iterator<T> it = array.iterator();
        while (it.hasNext()) {
            if (Objects.equals(it.next(), element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator iterator() {
        return array.iterator();
    }

    public static void main(String[] args) {
        SimpleSet<Integer> array = new SimpleSet<>();
        array.add(null);
        array.add(null);
        array.add(5);
        array.add(15);
        array.add(20);
        array.add(10);
        Iterator<Integer> flag = array.iterator();
        System.out.println(flag.hasNext());
        System.out.println(flag.next());
        System.out.println(flag.hasNext());
        System.out.println(flag.next());
//        System.out.println(flag.hasNext());
//        System.out.println(flag.next());
//        System.out.println(flag.hasNext());
//        System.out.println(flag.next());
//        System.out.println(flag.hasNext());
//        System.out.println(flag.next());
    }
}
