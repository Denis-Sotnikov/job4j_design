package ru.job4j.ood.menuprogramm;

import java.util.ArrayList;
import java.util.List;

public class PunktAndPopunkt extends MainPunkt implements PunktWithPodpunkt {
    private static int numberPunkt = 1;
    private List<Podpunkt> puntkList = new ArrayList<>();
    private int number = MainMenu.getNumber();

    public PunktAndPopunkt(String name) {
        super(name);
    }

    @Override
    public void add(Podpunkt punkt) {
        puntkList.add(punkt);
    }

    @Override
    public void remove(Podpunkt punkt) {
        puntkList.remove(punkt);
    }

    @Override
    public int getNumberPunkt() {
        return number;
    }

    @Override
    public String toString() {
        StringBuilder p = new StringBuilder();
        p.append(getNumberPunkt()).append(".");
        MainMenu.addToMap(p.toString(), this.getName());
        p.append(getName()).append(System.lineSeparator())
                .append("\u0009");
        for (Podpunkt podpunkt : puntkList) {
            p.append(podpunkt.print("\u0009"));
        }
        p.delete(p.length() - 1, p.length());
        return p.toString();
    }
}
