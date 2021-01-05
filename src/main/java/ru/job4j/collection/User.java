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

    public static void main(String[] args) {

        User first = new User("Dmitriy", 1, new GregorianCalendar(2017, 0, 25));
        User second = new User("Dmitriy", 1, new GregorianCalendar(2017, 0, 25));
        Map<User, Object> userMap = new HashMap<>();
        userMap.put(first, new Object());
        userMap.put(second, new Object());
//        System.out.println(userMap);
        for (Map.Entry<User, Object> t : userMap.entrySet()) {
            System.out.println(t);
        }
//        String w = binary(first.hashCode()>>>16);
//        System.out.println("first.hashCode() = " + first.hashCode());
//        System.out.println(w);

//        System.out.println(hash(first.hashCode()));
//        System.out.println(123>>>4);
//        Integer index = first.hashCode() & (16-1);
//        Integer index1 = second.hashCode() & (16-1);
//        Integer index2 = 1531448569 & (16-1);
//        Integer index3 = 1072408673 & (16-1);
//        Integer index4 = 1389133897 & (16-1);
//        Integer index5 = 885284298 & (16-1);
//        System.out.println(index);
//        System.out.println(index1);
//        System.out.println(index2);
//        System.out.println(index3);
//        System.out.println(index4);
//        System.out.println(index5);
    }

    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
