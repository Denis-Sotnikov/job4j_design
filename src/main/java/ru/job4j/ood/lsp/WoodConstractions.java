package ru.job4j.ood.lsp;
//Класс WoodConstractions имеет метод setAntipiren(Antipiren antipiren), который позволяет
//принять в работу антипирен для обработки деревянных конструкций
//Метод setAntipiren(Antipiren antipiren) имеет валидацию.
//Его наследник, класс WoodConstractionsFirst отличается тем, что не имеет
//валидацию антипирена. Это нарушает принцип Liskov
public class WoodConstractions {
    private boolean setAntipiren(Antipiren antipiren) {
        return validation(antipiren);
    }
}
