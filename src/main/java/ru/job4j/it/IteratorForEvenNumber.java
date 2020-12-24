package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorForEvenNumber implements Iterator<Integer> {
    private int point = 0;
    private int[] array;

    public IteratorForEvenNumber(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        while (!(array[point] % 2 == 0) && point < (array.length - 1)) {
            point++;
        }
        return array[point] % 2 == 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[point++];
    }
}
