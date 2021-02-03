package ru.job4j.ood.srp.report;

import java.util.function.Predicate;

public interface Report {
    public String generate(Predicate<Employee> filter, Store store);
}
