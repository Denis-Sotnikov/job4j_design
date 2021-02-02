package ru.job4j.ood.menu;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.ood.menu.SimplePodpunkt.numberPodpuntk;

public class PodpunktWithPodpunkt implements Podpunkt, PunktWithPodpunkt {
    private String name;
    private int numberMainPunkt = MainMenu.number;
    private int basenumberPodpunkt = numberPodpuntk;
    private List<Podpunkt> puntkList = new ArrayList<>();

    public PodpunktWithPodpunkt(String val) {
        this.name = val;
        numberPodpuntk++;
    }

    @Override
    public int getMainPunktNumber() {
        return numberMainPunkt;
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
    public String print(String val) {
        return toString(val);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumberPunkt() {
        return this.basenumberPodpunkt;
    }

    @Override
    public String print() {
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder p = new StringBuilder();
        p.append(this.numberMainPunkt).append(".")
                .append(getNumberPunkt()).append(". ")
                .append(getName()).append(System.lineSeparator())
                .append("\u0009");
        for (Podpunkt podpunkt : puntkList) {
            p.append(podpunkt.print("\u0009"));
        }
        p.delete(p.length() - 1, p.length());
        return p.toString();
    }

    public String toString(String val) {
        StringBuilder p = new StringBuilder();
        p.append(this.numberMainPunkt).append(".")
                .append(getNumberPunkt()).append(". ")
                .append(getName()).append(System.lineSeparator())
                .append("\u0009" + val);

        for (Podpunkt podpunkt : puntkList) {
            p.append(podpunkt.print("\u0009" + val));
        }
        p.delete(p.length() - 1, p.length());
        return p.toString();
    }
}
