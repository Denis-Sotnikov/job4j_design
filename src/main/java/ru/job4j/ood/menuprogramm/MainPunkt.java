package ru.job4j.ood.menuprogramm;

public class MainPunkt implements Punkt {
    private static int numberPunkt = 1;
    private String name;

    public MainPunkt() {
        MainMenu.incrementStaticNumber();
    }

    public MainPunkt(String name) {
        this.name = name;
        MainMenu.incrementStaticNumber();
    }

    public String getName() {
        return name;
    }

    @Override
    public int getNumberPunkt() {
        return numberPunkt;
    }

    @Override
    public String print() {
        return toString();
    }
}
