package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
            if (data.length > row) {
                if (data[data.length - 1].length > column) {
                    return true;
                }
            }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer result = null;
        while (result == null) {
            if (data[row].length > 0) {
                result = data[row][column];
            }
            if ((data[row].length - 1) > column) {
                column++;
            } else {
                row++;
            }
        }
        return result;
    }
}