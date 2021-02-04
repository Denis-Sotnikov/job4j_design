package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.report.parser.ReportToFormat;
import ru.job4j.ood.srp.report.parser.ToJson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportForIt implements Report {
    private Store store;
    private ReportToFormat toFormat;

    public ReportForIt() {
    }

    public ReportForIt(Store store, ReportToFormat toFormat) {
        this.store = store;
        this.toFormat = toFormat;
    }

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

    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Vika", now, now, 200);

        MemStore memStore = new MemStore();
        memStore.add(worker);
        memStore.add(worker1);
        ReportToFormat reportToFormat = new ToJson();
        ReportForIt reportFor = new ReportForIt(memStore, reportToFormat);

        reportFor.generate(employee -> true, reportFor.store);

       // System.out.println(engine.toFormat.toFormat(report));
    }
}
