package ru.job4j.ood.srp.report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class ReportForIt implements Report {
    @Override
    public String generate(Predicate<Employee> filter, Store store) {
        StringBuilder text = new StringBuilder();
        DateFormat df = new SimpleDateFormat("dd MMM yyy");
        text.append("Name; Hired; Fired; Salary;");
        text.append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(df.format(employee.getHired().getTime())).append(";")
                    .append(df.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
