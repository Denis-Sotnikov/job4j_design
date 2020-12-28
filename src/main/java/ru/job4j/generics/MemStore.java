package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        Integer flag = looking(id);
        if (flag == -1) {
            System.out.println("This element did not found");
            return false;
        }
        mem.set(looking(id), model);
        return mem.get(looking(model.getId())).equals(model);
    }

    @Override
    public boolean delete(String id) {
        int size1 = mem.size();
        Integer flag = looking(id);
        if (flag == -1) {
            System.out.println("This element did not found");
            return false;
        }
        mem.remove(flag);
        int size2 = mem.size();
        return size1 > size2;
    }

    @Override
    public T findById(String id) {
        Integer flag = looking(id);
        if (flag == -1) {
            System.out.println("This element did not found");
            throw new NoSuchElementException();
        }
        return mem.get(flag);
    }

    private Integer looking(String id) {
        Integer indexForObject = -1;
        boolean flag = false;
        for (T m : mem) {
            if (m.getId().equals(id)) {
                indexForObject = mem.indexOf(m);
                break;
            }
        }
        return indexForObject;
    }

    public static void main(String[] args) {
        RoleStore sd = new RoleStore();
        sd.add(new Role("1"));
        sd.add(new Role("2"));
        sd.add(new Role("3"));
        System.out.println(sd.findById("3").getId());
        sd.delete("3");
        System.out.println(sd.findById("2").getId());
        System.out.println(sd.replace("2", new Role("5")));
        System.out.println(sd.findById("5").getId());
        System.out.println(sd.delete("7"));
//        System.out.println(sd.findById("3").getId());
    }

}