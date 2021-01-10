package ru.job4j.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public int getYearOfMake() {
        return yearOfMake;
    }

    public boolean isReady() {
        return ready;
    }

    public String getName() {
        return name;
    }

    public int[] getArray() {
        return array;
    }

    public Ventilation getVentilation() {
        return ventilation;
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

        System.out.println("--------------------");
        JSONObject jsonVentilation = new JSONObject(
                "{\"typeOfVentilation\":\"forced supply and exhaust ventilation\"}");

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        JSONArray jsonStatuses = new JSONArray(list);

        final House houseSecond = new House(1950, true, "myHome",
                new int[]{1, 2, 3}, new Ventilation("forced supply and exhaust ventilation"));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("yearOfMake", houseSecond.getYearOfMake());
        jsonObject.put("ready", houseSecond.isReady());
        jsonObject.put("name", houseSecond.getName());
        jsonObject.put("array", jsonStatuses);
        jsonObject.put("ventilation", jsonVentilation);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(houseSecond).toString());

    }
}