package ru.job4j.ood.dip.firstexample;
//Класс Shipping - осуществляет перевозку груза.
//Класс имеет поле private Truck truck;
//Это нарушает принцип DIP
public class Shipping {
    private Truck truck = new Truck();
    private int cargoWeight;

    public boolean move() {
        return truck.getCarryingCapacity() > cargoWeight;
    }
}
