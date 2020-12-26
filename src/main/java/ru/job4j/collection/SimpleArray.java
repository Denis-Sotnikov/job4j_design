package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int index = 0;
    private int count = 0;
    private int modCount = 0;
    private int saveCount = 0;

    public SimpleArray() {
        array = new Object[10];
    }

    public T get(int position) {
        Objects.checkIndex(position, index);
        return (T) array[position];
    }

    public void add(T model) {
        if (index < array.length) {
            array[index] = model;
            index++;
            modCount++;
        } else {
            Object[] buf = new Object[array.length + 10];
            System.arraycopy(array, 0, buf, 0, array.length);
            array = buf;
            array[index] = model;
            index++;
            modCount++;
        }
    }

    @Override
    public Iterator<T> iterator() {
        saveCount = modCount;
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (saveCount == modCount) {
                    return index > count;
                } else {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public T next() {
                if (saveCount == modCount) {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return (T) array[count++];
                } else {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    public static void main(String[] args) {
        SimpleArray<Integer> array = new SimpleArray<>();
        array.iterator().next();
        array.add(1);
        array.add(2);
        System.out.println(array.array.length);
        array.add(3);
        System.out.println(array.array.length);
    }
}