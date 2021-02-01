package ru.job4j.ood.isp;
//Не все мосты разводятся
//Метод void BridgeOpening() нарушает принцип isp
public interface Bridge {
    int getTrafficCar();

    void bridgeOpening();
}
