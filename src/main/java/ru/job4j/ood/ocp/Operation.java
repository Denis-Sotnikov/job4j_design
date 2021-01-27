package ru.job4j.ood.ocp;

//Тут суть заключается в следующем
//сначала мы сделали метод для order для выполнения операции по возведению аргумента в степень
//потом от заказчика пршила доп цель о неоходимости чтобы была возможность взятия корня.
//тут придется добавлять метод с корнем и мы его добавили. И это нарушает принцип OCP.
public class Operation {
    public int order(int val) {
        return val * val;
    }

    public double order1(int val) {
        return Math.sqrt(val);
    }
}
