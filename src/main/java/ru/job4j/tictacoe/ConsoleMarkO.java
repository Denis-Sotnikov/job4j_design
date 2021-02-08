package ru.job4j.tictacoe;

import ru.job4j.tictacoe.interfaice.Mark;

import java.io.IOException;
import java.io.OutputStream;

public class ConsoleMarkO implements Mark<OutputStream> {
    @Override
    public void print(OutputStream screen) {
        try {
            screen.write("X".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
