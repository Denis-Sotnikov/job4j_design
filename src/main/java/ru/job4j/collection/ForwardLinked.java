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
        if (head.next != null) {
            Node<T> node = head;
            Node<T> buf = head;
            int count = 0;
            while (count != 2) {
                if (count == 0) {
                    node = node.next;
                    head = node;
                    buf.next = null;
                    count++;
                } else {
                    //дальше
                    if (node.next != null) {
                        node = node.next;
                    } else {
                        count = 2;
                    }
                    head.next = buf;
                    buf = head;
                    head = node;
                }
            }
        }

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
        } else {
            throw new NoSuchElementException();
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
        } else {
            throw new NoSuchElementException();
        }
        if (node != null) {
            valueForReturn = node.value;
            if (node == head) {
                head = null;
            }
            node.value = null;
            node = null;
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
//        array.add(3);
//        array.add(4);
//        array.add(5);
//        array.add(6);
//        array.add(7);
//        array.add(8);
        array.revert();
        Iterator<Integer> it = array.iterator();
//            System.out.println(it.hasNext());
            System.out.println(it.next());
//            System.out.println(it.hasNext());
            System.out.println(it.next());
////            System.out.println(it.hasNext());
//            System.out.println(it.next());
//            System.out.println(it.next());
//        System.out.println(it.next());
////            System.out.println(it.hasNext());
//        System.out.println(it.next());
////            System.out.println(it.hasNext());
//        System.out.println(it.next());
//        System.out.println(it.next());
    }
}