package ru.job4j.ood.storagefood;

import java.util.HashMap;
import java.util.Map;

public class Place {
    protected Map<String, Map<Integer, Food>> mapaFood = new HashMap<>();

    protected void add(Food food) {
        int id = 0;
        if (mapaFood.containsKey(food.getClass().getName())) {
            id = mapaFood.get(food.getClass().getName()).size();
            mapaFood.get(food.getClass().getName()).put(id, food);
        } else {
            mapaFood.put(food.getClass().getName(), new HashMap<Integer, Food>());
            mapaFood.get(food.getClass().getName()).put(id, food);
        }
    }
}
