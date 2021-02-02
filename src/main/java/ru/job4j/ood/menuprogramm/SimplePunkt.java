package ru.job4j.ood.menuprogramm;

import java.util.ArrayList;
import java.util.List;

public class SimplePunkt extends MainPunkt implements PunktWithoutPodpunkt {
    private int number = MainMenu.getNumber();
    private String name;
    private List<Element> listElements = new ArrayList<>();

    public SimplePunkt(String name) {
        super(name);
        SimleElement.clearStaticNumber();
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
    public String toString() {
            StringBuilder s = new StringBuilder();
            s.append(number).append(".");
            MainMenu.addToMap(s.toString(), this.getName());
            s.append(super.getName())
                    .append(System.lineSeparator()).append("\u0009");
            for (Element el : listElements) {
                StringBuilder builder = new StringBuilder()
                        .append(number)
                        .append(".")
                        .append(el.getNumber())
                        .append(".");
                MainMenu.addToMap(builder.toString(), el.getName());
                s.append(number).append(".").append(el.getNumber()).append(".");
                s.append(el.getName());
                s.append(System.lineSeparator());
                s.append("\u0009");
            }
            s.delete(s.length() - 1, s.length());
            return s.toString();
    }
}
