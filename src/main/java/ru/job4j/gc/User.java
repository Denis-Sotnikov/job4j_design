package ru.job4j.gc;

public class User {
    private int age;
    private String name;

    public User() {
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", age, name);
    }

    public static void main(String[] args) {
        User a = new User(25, "Vika");
        User b = new User(28, "Katya");
    }
}
