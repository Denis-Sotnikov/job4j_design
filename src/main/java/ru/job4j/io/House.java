package ru.job4j.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class House {
    private int yearOfMake;
    private boolean ready;
    private String name;
    private int[] array;
    private Ventilation ventilation;

    public House() {
    }

    public House(int yearOfMake, boolean ready, String name, int[] array, Ventilation ventilation) {
        this.yearOfMake = yearOfMake;
        this.ready = ready;
        this.name = name;
        this.array = array;
        this.ventilation = ventilation;
    }

    @Override
    public String toString() {
        return "House{"
                + "yearOfMake="
                + yearOfMake
                + ", ready="
                + ready
                + ", name='"
                + name
                + '\''
                + ", array="
                + Arrays.toString(array)
                + ", ventilation="
                + ventilation
                + '}';
    }

    public static void main(String[] args) {
        final Gson gson = new GsonBuilder().create();
        House house = new House(1950, true, "myHome",
                new int[]{1, 2, 3}, new Ventilation("forced supply and exhaust ventilation"));
        String houseAtJson = gson.toJson(house);
        System.out.println(houseAtJson);
        final House myHouse = gson.fromJson(houseAtJson, House.class);
        System.out.println(myHouse);

    }
}