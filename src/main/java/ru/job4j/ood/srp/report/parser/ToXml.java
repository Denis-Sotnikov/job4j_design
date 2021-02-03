package ru.job4j.ood.srp.report.parser;

public class ToXml {

    public static String toHtml(String val) {
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
                + "</body>\n"
                + "\n"
                + "</html>";
        StringBuilder builder = new StringBuilder();
        builder.append(head).append(body);
        return builder.toString();
    }
}
