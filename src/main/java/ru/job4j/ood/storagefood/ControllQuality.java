package ru.job4j.ood.storagefood;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.Date;
import java.util.Map;
import java.util.function.DoubleToIntFunction;

public class ControllQuality {
    private Place place;

    public Place consider(Food food) {
        System.out.println("here");
        int percent = percent(food);
        System.out.println("here1");
        System.out.println(percent);
        if (percent > 75) {
            System.out.println("here2");
            sentTo(food, new Warehouse());
        } else {
            if (percent > 25 && percent < 75) {
                sentTo(food, new Shop());
            } else {
                if (percent < 25) {
                    food.setDiscount(30);
                    sentTo(food, new Shop());
                } else {
                    if (percent == 0) {
                        sentTo(food, new Trash());
                    }
                }
            }
        }
        return this.place;
    }

    private void sentTo(Food food, Place place) {
        this.place = place;
        place.add(food);
    }

    private int percent(Food food) {
        long interval = food.getExpiryDate().getTime() - food.getCreateDate().getTime();
        System.out.println(interval);
        return Math.toIntExact(((interval - (
                new Date().getTime() - food.getCreateDate().getTime())) * 100)
                / interval);
    }

    public static void main(String[] args) {
        ControllQuality controllQuality = new ControllQuality();
        Milk milk = new Milk("milk", new Date(new Date().getTime() + 14400000), new Date(), 100, 0);
        System.out.println(controllQuality
                .consider(milk).getClass().getName());
        for (Map.Entry<String, Map<Integer, Food>> v
                : controllQuality.consider(milk).mapaFood.entrySet()) {
            System.out.println(v.getKey() + " " + v.getValue().size());
            for (Map.Entry<Integer, Food> w : v.getValue().entrySet()) {
                System.out.println(w.getKey() + " " + w.getValue());
            }
        }
    }

}
