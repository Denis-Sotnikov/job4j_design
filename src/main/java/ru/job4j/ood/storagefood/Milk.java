package ru.job4j.ood.storagefood;

import java.util.Date;

public class Milk extends Food {
    public Milk() {
    }

    public Milk(String name, Date expiryDate, Date createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
