package ru.job4j.ood.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngine {
    private Comparator<Employee> comp = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Double.compare(o2.getSalary(), o1.getSalary());
        }
    };

    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        text.append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public String newGenerate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        text.append(System.lineSeparator());
        List<Employee> list =  store.findBy(filter);
        list.sort(comp);
        for (Employee employee : list) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary() * 2).append(";")
                    .append(System.lineSeparator());
        }

        return toHtml(text.toString());
    }

    private String toHtml(String val) {
        String head = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "\n"
                + "    <head>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <title>Report</title>\n"
                + "    </head>";
        String body = "<body>\n"
                + "        <h1>Report</h1>\n"
                + val
                + "    </body>\n"
                + "\n"
                + "</html>";
        StringBuilder builder = new StringBuilder();
        builder.append(head).append(body);
        return builder.toString();
    }
}