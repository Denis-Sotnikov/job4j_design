package ru.job4j.tictacoe.interfaice;

import java.io.IOException;

public interface Input<T> {
    T read() throws IOException;
}
