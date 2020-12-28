package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void revert() {
        ForwardLinked out = new ForwardLinked();
        T flag = null;
            while ((flag = deleteLastAndReturn()) != null) {
                out.add(flag);
            }
            Iterator<T> it = out.iterator();
            this.head = out.head;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T value = head.value;
        head = head.next;
        return value;
    }

    public void deleteLast() {
        Node<T> value = null;
        Node<T> node = head;
        if (node != null) {
            while (node.next != null) {
                value = node;
                node = node.next;
            }
        }
        if (node != null) {
            node.value = null;
        }
        if (value != null) {
            value.next = null;
        }
    }

    public T deleteLastAndReturn() {
        Node<T> value = null;
        Node<T> node = head;
        T valueForReturn = null;
        if (node != null) {
            while (node.next != null) {
                value = node;
                node = node.next;
            }
        }
        if (node != null) {
            valueForReturn = node.value;
            node.value = null;
        }
        if (value != null) {
            value.next = null;
        }
        return valueForReturn;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ForwardLinked<Integer> array = new ForwardLinked<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.revert();
        Iterator<Integer> it = array.iterator();
//            System.out.println(it.hasNext());
            System.out.println(it.next());
//            System.out.println(it.hasNext());
            System.out.println(it.next());
//            System.out.println(it.hasNext());
            System.out.println(it.next());
    }
}