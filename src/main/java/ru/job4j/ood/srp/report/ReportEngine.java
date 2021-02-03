package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import netscape.javascript.JSObject;
import ru.job4j.ood.srp.report.parser.ReportToFormat;
import ru.job4j.ood.srp.report.parser.ToHtml;
import ru.job4j.ood.srp.report.parser.ToJson;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportEngine {

    private Report report;
    private Store store;
    private ReportToFormat toFormat;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public ReportEngine(Store store, Report report) {
        this.report = report;
        this.store = store;
    }

    public ReportEngine(Report report, Store store, ReportToFormat toFormat) {
        this.report = report;
        this.store = store;
        this.toFormat = toFormat;
    }

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
        return text.toString();
    }

    public Report getReport() {
        return report;
    }

    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Vika", now, now, 200);

        ReportForHr reportFor = new ReportForHr();

        ReportToFormat reportToFormat = new ToJson();

        MemStore memStore = new MemStore();
        memStore.add(worker);
        memStore.add(worker1);

        ReportEngine engine = new ReportEngine(reportFor, memStore, reportToFormat);

        String report =  engine.report.generate(em -> true, memStore);

        System.out.println(engine.toFormat.toFormat(report));
    }

}