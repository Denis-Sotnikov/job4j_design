package ru.job4j.tictacoe.interfaice;

public interface Board<T> {
    T[][] getConditionBoard();
    boolean setValue(int val1, int val2, T val3);
    void draw();
}
