package ru.job4j.ood.storagefood;

import java.util.Date;

public class Chocolate extends Food {
    public Chocolate() {
    }

    public Chocolate(String name, Date expiryDate, Date createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
