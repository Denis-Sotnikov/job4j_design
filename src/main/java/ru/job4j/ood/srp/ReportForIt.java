package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportForIt implements Report {
    @Override
    public String generate(Predicate<Employee> filter, Store store) {
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
