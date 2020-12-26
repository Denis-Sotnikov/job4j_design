package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimplyArray<T> implements Iterable {
    private Object[] array;
    private int index = 0;
    private int count = 0;

    public SimplyArray(int count) {
        array = new Object[count];
    }

    private void add(T model) {
        if (index < array.length) {
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
        System.arraycopy(array, position + 1, array, position, array.length - position - 1);
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
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[count++];
            }
        };
    }

//    public static void main(String[] args) {
//        SimplyArray<Integer> data = new SimplyArray<Integer>(5);
//        data.add(1);
//        data.add(2);
//        data.add(3);
//        data.add(4);
//        data.add(5);
//        data.remove(4);
//        for (int i = 0; i < data.index; i++) {
//            System.out.println(data.get(i));
//        }
//    }
}
