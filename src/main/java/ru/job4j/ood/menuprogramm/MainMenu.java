package ru.job4j.ood.menuprogramm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainMenu implements Menu {
    private static int number = 0;
    private static Map<String, String> mapForAction = new HashMap();
    private List<Punkt> puntkList = new ArrayList<>();

    private void choice() {
        System.out.println("Выберете действие: ");
        System.out.println("например 1.1.1.2. ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = reader.readLine();
            System.out.println("Выполняется " + mapForAction.get(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getNumber() {
        return number;
    }

    public static void incrementStaticNumber() {
        number++;
    }

    public static void addToMap(String key, String val) {
        mapForAction.put(key, val);
    }

    @Override
    public void add(Punkt punkt) {
        puntkList.add(punkt);
    }

    @Override
    public void remove(Punkt punkt) {
        puntkList.remove(punkt);
    }

    @Override
    public String toString() {
        StringBuilder p = new StringBuilder();
        p.append("MainMenu ").append(System.lineSeparator());
        for (Punkt punkt : puntkList) {
            p.append(punkt.print());
        }
        return p.toString();
    }

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();

        PunktAndPopunkt punktAndPopunktFirst = new PunktAndPopunkt(
                "Пyнкт с подпунктом");
        SimplePodpunkt podpunktFirst = new SimplePodpunkt(
                "Первый подпункт", punktAndPopunktFirst.getNumberPunkt());
        punktAndPopunktFirst.add(podpunktFirst);

        SimleElement elementFirst = new SimleElement("первый элемент");
        SimleElement elementSecond = new SimleElement("второй элемент");
        SimleElement elementThree = new SimleElement("третий элемент");

        podpunktFirst.add(elementFirst);
        podpunktFirst.add(elementSecond);
        podpunktFirst.add(elementThree);

        SimplePodpunkt podpunktSecond = new SimplePodpunkt(
                "Второй подпункт", punktAndPopunktFirst.getNumberPunkt());
        podpunktSecond.add(elementFirst);
        podpunktSecond.add(elementSecond);
        podpunktSecond.add(elementThree);
        punktAndPopunktFirst.add(podpunktSecond);

        SimplePodpunkt podpunktThree = new SimplePodpunkt(
                "Третий подпункт", punktAndPopunktFirst.getNumberPunkt());
        punktAndPopunktFirst.add(podpunktThree);

        SimleElement elementForThreeFirst = new SimleElement(
                "первый элемент");
        SimleElement elementForThreeSecond = new SimleElement(
                "первый элемент");
        podpunktThree.add(elementForThreeFirst);
        podpunktThree.add(elementForThreeSecond);
        menu.add(punktAndPopunktFirst);

        SimplePunkt simplePunktFisrt = new SimplePunkt("Первая глава");
        simplePunktFisrt.add(elementFirst);
        simplePunktFisrt.add(elementSecond);
        simplePunktFisrt.add(elementThree);
        menu.add(simplePunktFisrt);

        SimplePunkt simplePunktSecond = new SimplePunkt("Вторая глава");
        SimleElement elementFour = new SimleElement("первый элемент");
        simplePunktSecond.add(elementFour);

        menu.add(simplePunktSecond);

        System.out.println(menu.toString());
        System.out.println(mapForAction.toString());
        menu.choice();
    }
}
