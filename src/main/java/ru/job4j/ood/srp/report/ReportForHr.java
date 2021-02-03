package ru.job4j.ood.srp.report;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportForHr implements Report {
    private Comparator<Employee> comp = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Double.compare(o2.getSalary(), o1.getSalary());
        }
    };

    @Override
    public String generate(Predicate<Employee> filter, Store store) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        text.append(System.lineSeparator());
        List<Employee> list =  store.findBy(filter);
        list.sort(comp);
        for (Employee employee : list) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
