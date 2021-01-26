package ru.job4j.ood.srp;

import java.util.HashMap;
import java.util.Map;

public class Manufacture {
    private Map<String, Integer> stockOfParts() {
        //идет соединение с базой данных и производится выборка необходимых
        // деталей и их запаса сохранятеся этот запас в карту
        Map<String, Integer> stockOfParts = new HashMap<>();
        return stockOfParts;
    }

    private Map<String, Integer> quantityMakedCarInThisMonth() {
        //идет соединение с базой данных и производится выборка необходимой
        // информации о количестве произведенных авто этом месяце
        Map<String, Integer> carInThisMonth = new HashMap<>();
        return carInThisMonth;
    }
}
