package ru.job4j.io;

public class Ventilation {
    private String typeOfVentilation;

    public Ventilation(String typeOfVentilation) {
        this.typeOfVentilation = typeOfVentilation;
    }

    @Override
    public String toString() {
        return "Ventilation{"
                + "typeOfVentilation='"
                + typeOfVentilation
                + '\''
                + '}';
    }
}
