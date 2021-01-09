package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int value = 10;
        LOG.debug("int value : {}", value);
        float f = 3;
        LOG.debug("float f : {}", f);
        byte b = 5;
        LOG.debug("byte b : {}", b);
        long l = 15;
        LOG.debug("long l : {}", l);
        double v = 20.20;
        LOG.debug("double v : {}", v);
        char c = 'c';
        LOG.debug("char c : {}", c);
        short i = 8;
        LOG.debug("short i : {}", i);
        boolean b1 = true;
        LOG.debug("boolean b1 : {}", b1);
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);

    }
}