package ru.job4j.ood.menuprogramm;

import java.util.ArrayList;
import java.util.List;

public class SimplePodpunkt implements Podpunkt, PunktWithoutPodpunkt {
    private static int numberPodpuntk = 1;
    private String name;
    private int numberMainPunkt = MainMenu.getNumber();
    private int basenumberPodpunkt = numberPodpuntk;
    private List<Element> listElements = new ArrayList<>();

    public SimplePodpunkt(String name, int numberMainPunkt) {
        SimleElement.clearStaticNumber();
        this.name = name;
        this.numberMainPunkt = numberMainPunkt;
        numberPodpuntk++;
    }

    @Override
    public void add(Element element) {
        listElements.add(element);
    }

    @Override
    public void remove(Element element) {
        listElements.remove(element);
    }

    @Override
    public int getMainPunktNumber() {
        return numberMainPunkt;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getNumberPunkt() {
        return this.basenumberPodpunkt;
    }

    @Override
    public String print() {
        return null;
    }

    @Override
    public String print(String val) {
        return toString(val);
    }

    public String toString(String val) {
        StringBuilder s = new StringBuilder();
        StringBuilder p = new StringBuilder();
        s.append(getMainPunktNumber())
                .append(".")
                .append(getNumberPunkt())
                .append(".");
        p.append(s.toString());
        MainMenu.addToMap(s.toString(), this.getName());
        s.append(name).append(System.lineSeparator()).append("\u0009").append(val);
        for (Element el : listElements) {
            p.append(getNumberPunkt()).append(".").append(el.getNumber()).append(".");
            MainMenu.addToMap(p.toString(), el.getName());
            p.delete(4, p.length());
            s.append(getNumberPunkt()).append(".").append(el.getNumber()).append(". ");
            s.append(el.getName());
            s.append(System.lineSeparator());
            s.append("\u0009").append(val);
        }
        s.delete(s.length() - 1, s.length());
        return s.toString();
    }
}
