package ru.job4j.collection;

import java.util.*;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User() {
    }

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                Objects.equals(name, user.name) &&
                Objects.equals(birthday, user.birthday);
    }

    public static void main(String[] args) {
        User first = new User("Dmitriy", 1, new GregorianCalendar(2017, 0, 25));
        User second = new User("Dmitriy", 1, new GregorianCalendar(2017, 0, 25));
        Map<User, Object> userMap = new HashMap<>();
        userMap.put(first, new Object());
        userMap.put(second, new Object());
        System.out.println(userMap);
        for (Map.Entry<User, Object> t : userMap.entrySet()) {
            System.out.println(t);
        }
    }
}
