package ru.job4j.tictacoe.interfaice;

public interface Rules<T> {
    boolean getResult(T[][] val1, T val2);
}
