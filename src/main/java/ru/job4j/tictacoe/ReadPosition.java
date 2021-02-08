package ru.job4j.tictacoe;

import ru.job4j.tictacoe.interfaice.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadPosition implements Input {
    @Override
    public Object read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }
}
