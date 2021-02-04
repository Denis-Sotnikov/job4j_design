package ru.job4j.ood.storagefood;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControllQuality {
    private final List<Storage> storages = new ArrayList<>();

    private void distibute(Food food) {
        for (Storage s : storages) {
            if (s.accept(food)) {
                s.add(food);
                break;
            }
        }
    }

    public void dynamicReallocation(List<Storage> listStorage) {
        List<Food> ar = new ArrayList<>();
        for (Storage storage : listStorage) {
            ar.addAll(storage.clear());
        }
        for (Food food : ar) {
            this.distibute(food);
        }
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControllQuality controllQuality = new ControllQuality();
        controllQuality.storages.add(shop);
        controllQuality.storages.add(trash);
        controllQuality.storages.add(warehouse);
        Milk milk = new Milk("milk", new Date(new Date().getTime() + 100000000),
                new Date(new Date().getTime() - 2100000000), 100, 0);
        Milk chocolate = new Milk("chocolate", new Date(new Date().getTime() + 864000000),
                new Date(), 150, 0);
        controllQuality.distibute(milk);
        controllQuality.distibute(chocolate);

        System.out.println();

        List<Food> ar = new ArrayList<>();
        controllQuality.dynamicReallocation(controllQuality.storages);

        for (Storage storage : controllQuality.storages) {
            System.out.println(storage);
        }

    }
}
