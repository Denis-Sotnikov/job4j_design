package ru.job4j.ood.dip.threeexample;
//Класс Computer содержит процессор.
//В данном случае класс зависим от реализации процессора.
//Это нарушение принципа DIP
public class Computer {
    private IntelCorei5 corei5 = new IntelCorei5();

    public int resolveTask(int quantityOperation) {
        return quantityOperation / corei5.getSpeed();
    }
}
