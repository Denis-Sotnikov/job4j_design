package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        T flag = null;
        T flagForReturn = null;
        int size = 0;
        while ((flag = in.pop()) != null) {
            flagForReturn = flag;
            out.push(flag);
            size++;
        }
        if (size == 0) {
            throw new NoSuchElementException();
        }
        out.pop();
        size--;
        while (size != 0) {
            in.push(out.pop());
            size--;
        }
        return flagForReturn;
    }

    public void push(T value) {
        in.push(value);
    }
}