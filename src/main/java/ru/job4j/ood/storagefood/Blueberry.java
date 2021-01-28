package ru.job4j.ood.storagefood;

import java.util.Date;

public class Blueberry extends Food {
    public Blueberry() {
    }

    public Blueberry(String name, Date expiryDate, Date createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
