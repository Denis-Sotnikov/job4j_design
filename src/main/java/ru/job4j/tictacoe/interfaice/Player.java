package ru.job4j.tictacoe.interfaice;

import ru.job4j.tictacoe.BoardForConsole;

import java.io.IOException;

public interface Player<T> {
    void move(BoardForConsole board, Input in) throws IOException;
    T getSide();
    Input getIn();
}
