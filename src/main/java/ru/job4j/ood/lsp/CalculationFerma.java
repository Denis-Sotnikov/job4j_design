package ru.job4j.ood.lsp;
//Класс CalculationFerma служит для расчет строительной фермы.
//Класс имеет метод calculation().
//Наследник класса CalculationFermaInAnotherRegion отличается тем,
//что он для расчета в другом регионе. В другом регионе, другая снеговая нагрузка.
//Ввиду этого обстоятельства в формуле расчета постоянная нагрузка
//поделена на два (N/2). Это нарущает принцип Liskov.
public class CalculationFerma {
    private boolean calculation() {
        return g < (N * A * l * (l / 2));
    }
}
