package ru.job4j.ood.srp.report;

import java.util.function.Predicate;

public class ReportForBuhgalter implements Report {
    @Override
    public String generate(Predicate<Employee> filter, Store store) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        text.append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() * 2).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
