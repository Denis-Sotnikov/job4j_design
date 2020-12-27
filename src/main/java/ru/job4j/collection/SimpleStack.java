package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        Iterator<T> it = linked.iterator();
        T value = null;
        while (it.hasNext()) {
            value = it.next();
        }
        linked.deleteLast();
        return value;
    }

    public void push(T value) {
        linked.add(value);
    }

    public static void main(String[] args) {
        SimpleStack<Integer> array = new SimpleStack<>();
        array.push(1);
        array.push(2);
        array.push(3);
        array.pop();
        Iterator<Integer> it = array.linked.iterator();
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
    }
}