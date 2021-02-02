package ru.job4j.ood.dip.secondexample;
//Класс Airport.
//Класс имеет поле private Boing boing;
//Это нарушает принцип DIP
public class Airport {
    private Boing boing = new Boing();

    public boolean flight(int n) {
        return boing.getCapacity() > n;
    }
}
