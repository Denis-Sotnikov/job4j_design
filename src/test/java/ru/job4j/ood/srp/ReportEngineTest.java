package ru.job4j.ood.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import ru.job4j.ood.srp.report.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportEngineTest {

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

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        System.out.println(expect);
        assertThat(engine.generate(em -> true, store), is(expect.toString()));
    }

    @Test
    public void whenReportForBuhgalter() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report report = new ReportForBuhgalter();
        ReportEngine engine = new ReportEngine(store, report);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() * 2).append(";")
                .append(System.lineSeparator());
        assertThat(engine.getReport().generate(em -> true, store), is(expect.toString()));
    }

    @Test
    public void whenGeneratedforHr() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Masha", now, now, 200);
        store.add(worker);
        store.add(worker1);
        Report report = new ReportForHr();
        ReportEngine engine = new ReportEngine(store, report);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.getReport().generate(em -> true, store), is(expect.toString()));
    }

    @Test
    public void whenReportForIt() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateFormat df = new SimpleDateFormat("dd MMM yyy");
        store.add(worker);
        Report report = new ReportForIt();
        ReportEngine engine = new ReportEngine(store, report);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(df.format(worker.getHired().getTime())).append(";")
                .append(df.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(toHtml(engine.getReport().generate(em -> true, store)), is(toHtml(expect.toString())));
    }
}