package ru.job4j.ood.storagefood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.job4j.ood.storagefood.Food.percent;

public class Trash implements Storage {
    private Map<Integer, Food> foodMap = new HashMap<>();
    private Integer index = 0;

    @Override
    public void add(Food food) {
        foodMap.put(index++, food);
    }

    @Override
    public boolean accept(Food food) {
        if (percent(food) == 0) {
            return true;
        }
        return false;
    }

    public List<Food> clear() {
        List<Food> foodList = new ArrayList<>(foodMap.values());
        foodMap.clear();
        index = 0;
        return foodList;
    }

    @Override
    public String toString() {
        return "Trash{"
                + "foodMap=" + foodMap + '}';
    }
}
