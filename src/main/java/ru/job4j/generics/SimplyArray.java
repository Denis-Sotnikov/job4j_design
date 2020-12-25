package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimplyArray<T> implements Iterable {
    private Object[] array;
    private int index = 0;
    private int count = 0;

    public SimplyArray(int count) {
        array = new Object[count];
    }

    private void add(T model) {
        if (index < 5) {
            array[index] = model;
            index++;
        } else {
            System.out.println("array is full");
        }
    }

    private void set(int position, T model) {
        Objects.checkIndex(position, index);
        array[index] = model;
    }

    private void remove(int position) {
        Objects.checkIndex(position, index);
        Object[] arrayFirst = new Object[array.length];
        Object[] arraySecond = new Object[array.length];
        Object[] arrayResult = new Object[array.length];
        System.arraycopy(array, 0, arrayFirst, 0, position);
        System.arraycopy(array, position + 1, arraySecond, position, array.length - position - 1);
        System.arraycopy(arrayFirst, 0, arrayResult, 0, position);
        System.arraycopy(arraySecond, position, arrayResult, position, array.length - position - 1);
        array = arrayResult;
        index--;
    }

    public Object get(int position) {
        Objects.checkIndex(position, index);
        return array[position];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return index > count;
            }

            @Override
            public T next() {
                return (T) array[count++];
            }
        };
    }
}
