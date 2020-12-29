package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable {
    private SimpleArray<T> array = new SimpleArray<>();

    public boolean add(T element) {
        Iterator<T> it = array.iterator();
        while (it.hasNext()) {
            if (it.next().equals(element)) {
                return false;
            }
        }
        array.add(element);
        return true;
    }

    @Override
    public Iterator iterator() {
        return array.iterator();
    }

    public static void main(String[] args) {
        SimpleSet<Integer> array = new SimpleSet<>();
        array.add(5);
        array.add(5);
//        array.add(15);
//        array.add(20);
//        array.add(10);
        Iterator<Integer> flag = array.iterator();
        System.out.println(flag.hasNext());
//        System.out.println(flag.next());
//        System.out.println(flag.hasNext());
//        System.out.println(flag.next());
//        System.out.println(flag.hasNext());
//        System.out.println(flag.next());
//        System.out.println(flag.hasNext());
//        System.out.println(flag.next());
//        System.out.println(flag.hasNext());
//        System.out.println(flag.next());
    }
}
