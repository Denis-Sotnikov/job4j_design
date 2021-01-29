package ru.job4j.ood.storagefood;

import java.util.List;

public interface Storage {
    void add(Food food);

    boolean accept(Food food);

    List<Food> clear();
}
