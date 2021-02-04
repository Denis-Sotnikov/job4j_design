package ru.job4j.ood.srp.report.parser;

public class ToJson implements ReportToFormat {
    @Override
    public String toFormat(String val) {
        String ds = val.substring(0, val.indexOf(System.lineSeparator()) - 1);
        String[] namesOfFields = ds.split("; ");
        String[] array = val.split("Salary;" + System.lineSeparator());
        String[] arrayFirst = array[1].replaceAll(System.lineSeparator(), "").split(";");

        String[] arraySecond = new String[namesOfFields.length];
        int count = 0;
        StringBuilder employee = new StringBuilder();

        for (int i = 0; i < arrayFirst.length; i++) {
            arraySecond[count++] = arrayFirst[i];
            if (count == namesOfFields.length) {
                employee.append("Employee {")
                        .append(System.lineSeparator());
                for (int j = 0; j < count; j++) {
                    employee.append(namesOfFields[j] + " : ")
                            .append(arraySecond[j])
                            .append(System.lineSeparator());
                }
                employee.append("}")
                .append(System.lineSeparator());
                count = 0;
            }
        }
        return employee.toString();
    }
}
