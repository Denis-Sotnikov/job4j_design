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
        Integer result = null;
                if (data.length > row && data[data.length - 1].length > column) {
                    while (result == null) {
                        if (data[row].length > 0) {
                            result = data[row][column];
                        } else {
                            changePosition();
                        }
                    }
                } else {
                return false;
            }
        return result != null;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer buf = data[row][column];
        changePosition();
        return buf;
    }

    private void changePosition() {
        if ((data[row].length - 1) > column) {
            column++;
        } else {
            row++;
        }
    }
}