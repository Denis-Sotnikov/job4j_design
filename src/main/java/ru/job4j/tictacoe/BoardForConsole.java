package ru.job4j.tictacoe;

import ru.job4j.tictacoe.interfaice.Board;
import ru.job4j.tictacoe.interfaice.Output;

public class BoardForConsole implements Board {
    Boolean[][] array = new Boolean[3][3];
    Output output;

    public BoardForConsole(Output output) {
        this.output = output;
    }

    @Override
    public Boolean[][] getConditionBoard() {
        return this.array;
    }

    @Override
    public boolean setValue(int val1, int val2, Object val3) {
            if (array[val1][val2] == null) {
                array[val1][val2] = (Boolean) val3;
                return true;
            }
        return false;
    }

    @Override
    public void draw() {
        output.print(array);
    }
}
