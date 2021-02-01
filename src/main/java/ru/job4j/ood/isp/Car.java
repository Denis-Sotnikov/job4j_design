package ru.job4j.ood.isp;
//Не всем автомобилям необходимо менять свечи в двигателе.
// Скажем для электромобилей это ненужно.
//Метод void replacementOfEnginePlugs() нарушает принцип isp
public interface Car {
    int getMaksimumSpeed();

    void move();

    void stop();

    void replacementOfEnginePlugs();
}
