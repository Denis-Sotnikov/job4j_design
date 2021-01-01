package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        T result = linked.deleteLastAndReturn();
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    public void push(T value) {
        linked.add(value);
    }

    boolean isEmpty() {
        Iterator<T> it = linked.iterator();
        return !it.hasNext();
    }

    public static void main(String[] args) {
        SimpleStack<Integer> array = new SimpleStack<>();
        array.push(1);
        array.push(2);
        array.push(3);
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println("----------------");
        Iterator<Integer> it = array.linked.iterator();
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
    }
}