package ru.job4j.io;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (directory() != null && output() != null && exclude() != null) {
            return true;
        }
        System.out.println("Initial data not enough");
        return false;
    }

    public String directory() {
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("d=")) {
                return args[i].split("=")[1];
            }
        }
        return null;
    }

    public String exclude() {
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("e=")) {
                return args[i].split("=")[1];
            }
        }
        return null;
    }

    public String output() {
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("o=")) {
                return args[i].split("=")[1];
            }
        }
        return null;
    }
}