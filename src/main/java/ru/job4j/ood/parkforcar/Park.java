package ru.job4j.ood.parkforcar;

public interface Park {
    int putCar(Car car);

    int removeTheCar(Car car);

    int getQuantityPlaceForCar();

    boolean nPlaceTogether(int n);
}
