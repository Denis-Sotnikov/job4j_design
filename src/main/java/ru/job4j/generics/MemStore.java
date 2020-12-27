package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        mem.set(looking(id), model);
        if (mem.get(looking(model.getId())).equals(model)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        int size1 = mem.size();
        int point = looking(id);
        mem.remove(point);
        int size2 = mem.size();
        return size1 > size2;
    }

    @Override
    public T findById(String id) {
        return mem.get(looking(id));
    }

    private Integer looking(String id) {
        Integer indexForObject = null;
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
//        System.out.println(sd.findById("5").getId());
//        System.out.println(sd.findById("3").getId());
    }

}