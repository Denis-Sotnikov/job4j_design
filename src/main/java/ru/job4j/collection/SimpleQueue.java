package ru.job4j.collection;

import org.w3c.dom.ls.LSOutput;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int sizeOut = 0;
    private int sizeIn = 0;

    public T poll() {
        T flag = null;
        if (sizeOut == 0) {
            if (sizeIn == 0) {
                throw new NoSuchElementException();
            } else {
                while (sizeIn != 0) {
                    if (sizeIn == 1) {
                        flag = in.pop();
                        sizeIn--;
                    } else {
                        flag = in.pop();
                        out.push(flag);
                        sizeIn--;
                        sizeOut++;
                    }
                }
            }
        } else {
            flag = out.pop();
            sizeOut--;
        }
        return flag;
    }

    public void push(T value) {
        in.push(value);
        sizeIn++;
    }
}