package ru.job4j.ood.menuprogramm;

public class SimleElement implements Element {
    private static int numberElement = 1;
    private int number = numberElement;
    private String name;

    public SimleElement() {
        numberElement++;
    }

    public SimleElement(String name) {
        this.name = name;
        numberElement++;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumber() {
        return number;
    }

    public static void clearStaticNumber() {
        numberElement = 1;
    }
}
