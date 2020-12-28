package ru.job4j.collection;

import org.w3c.dom.Node;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable {
    private int size = 0;
    private Node<T> first;
    private Node<T> last;
    private int modCount = 0;
    private int saveCount = 0;

    public void add(T value) {
        if (size == 0) {
            first = new Node<T>(null, value, null);
            last = first;
            first.next = first;
        } else {
            last.next = new Node<T>(last, value, null);
            last = last.next;
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        for (int i = 0; i < index; i++) {
            first = first.next;
        }
        return first.item;
    }

    @Override
    public Iterator iterator() {
        saveCount = modCount;
        return new Iterator<T>() {
            private transient MyLinkedList.Node<T> it = first;
            private transient MyLinkedList.Node<T> buf;
            private Integer countGoBackParametr = 0;
            @Override
            public boolean hasNext() {
                if (saveCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (size > countGoBackParametr) {
                    return it.item != null;
                }
                return false;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                buf = it;
                it = it.next;
                countGoBackParametr++;
                return buf.item;
            }
        };
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //System.out.println(list.get(0));
        Iterator<Integer> raz = list.iterator();
        System.out.println(raz.hasNext());
        System.out.println("vozvrat = " + raz.next());
        System.out.println(raz.hasNext());
        System.out.println("vozvrat = " + raz.next());
        System.out.println(raz.hasNext());
        System.out.println("vozvrat = " + raz.next());
        System.out.println(raz.hasNext());
        System.out.println("vozvrat = " + raz.next());
        System.out.println(raz.hasNext());
        System.out.println("vozvrat = " + raz.next());
    }
}
