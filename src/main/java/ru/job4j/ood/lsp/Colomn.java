package ru.job4j.ood.lsp;
//Класс Colomn служит для расчета строительных колонн.
//Класс имеет метод calculation(Briсk briсk).
//Ведется расчет колонны из кирпича.
//В классе наследнике - ColomnSecond, в метод принимается
//другой класс(calculation(Steel steel)). Класс расчитан для
//расчета колонн из стали С235. А это нарушает принцип Liskov.

public class Colomn {
    private boolean calculation(Briсk briсk) {
        Double g = n / a;
        return g <= 1200;
    }
}

