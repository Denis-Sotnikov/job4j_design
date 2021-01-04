package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayForMap<K, T> implements Iterable<T> {
    private Node[] array;
    private int index = 0;
    private int modCount = 0;

    public ArrayForMap() {
        array = new Node[10];
    }

    public ArrayForMap(int val) {
        array = new Node[val];
    }

    public void addAtIndexForMap(int in, Node<K, T> model) {
        array[in] = model;
        index++;
        modCount++;
    }

    public int size() {
        return array.length;
    }

    public Node getForMap(int position) {
        return array[position];
    }

    public T getForMapValue(int position) {
        return (T) array[position].value;
    }

    public void remove(int index) {
        array[index] = null;
    }

    public void increasingArrayForMap() {
        //System.out.println("index = " + index);
        if (!(index < array.length)) {
            System.out.println("---------------");
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    System.out.println("i = " + i + " array[i].value = " + array[i].value);
                }
            }
            System.out.println("---------------");
            Integer w = null;
            Node[] arr = new Node[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    w = array[i].key.hashCode() % ((array.length) * 2);
                    System.out.println("w = " + w);
                    arr[w] = array[i];
                }
            }
            array = arr;
            System.out.println("****************");
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    System.out.println("i = " + i + " array[i].value = " + array[i].value);
                }
            }
            System.out.println("****************");
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Integer cursor = 0;

            @Override
            public boolean hasNext() {
                while (cursor < array.length && array[cursor] == null) {
                    cursor++;
                }
                return array[cursor] != null ? true : false;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[cursor++].getValue();
            }
        };
    }

    static class Node<K, T> {
        private T value;
        private K key;
        private Node<K, T> next;

        public Node(K key, T value, Node<K, T> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return this.value;
        }

        public K getKey() {
            return this.key;
        }
    }

    public static void main(String[] args) {
        ArrayForMap<String, Integer> array = new ArrayForMap<>();
        array.addAtIndexForMap(1, new Node(32427349, 32427349, null));
        System.out.println(array.getForMap(1).value);
    }
}