package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        T point = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            point = comparator
                    .compare(point, value.get(i)) >= 0
                    ? point : value.get(i);
        }
        return point;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        T point = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            point = comparator
                    .compare(point, value.get(i)) < 0
                    ? point : value.get(i);
        }
        return point;
    }
}