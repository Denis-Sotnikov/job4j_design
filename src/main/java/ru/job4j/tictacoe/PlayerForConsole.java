package ru.job4j.tictacoe;

import ru.job4j.tictacoe.interfaice.Input;
import ru.job4j.tictacoe.interfaice.Player;

import java.io.*;

public class PlayerForConsole implements Player {
    private boolean zero;
    private Input in;

    public PlayerForConsole(boolean zero) {
        this.zero = zero;
    }

    public PlayerForConsole(boolean zero, Input in) {
        this.zero = zero;
        this.in = in;
    }

    @Override
    public void move(BoardForConsole val, Input in) throws IOException {
        boolean flag = false;
        int y = 0;
        int x = 0;
        while (!flag) {
            System.out.println("введите координату знака по оси Y: ");
            y = (Integer) in.read();
            System.out.println("Y = " + y);
            System.out.println("введите координату знака по оси X: ");
            x = (Integer) in.read();
            System.out.println("X = " + x);
            flag = validate(y, x, val);
        }
        val.setValue(y, x, zero);
    }

    private boolean validate(int val1, int val2, BoardForConsole val3) {
        if (val3.array[val1][val2] == null) {
            return true;
        }
        System.out.println("Эта ячейка занята. Выберете другую");
        return false;
    }

    public Boolean getSide() {
        return zero;
    }

    @Override
    public Input getIn() {
        return this.in;
    }


}
