package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    private <T> T extremum(List<T> data, Comparator<T> comparator, Predicate<Integer> condition) {
        T val = null;
        if (!data.isEmpty() && data.get(0) != null) {
            val = data.get(0);
        }
        for (T v : data) {
            if (condition.test(comparator.compare(val, v))) {
                val = v;
            }
        }
        return val;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return extremum(value, comparator, integer -> integer > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return extremum(value, comparator, integer -> integer < 0);
    }
}