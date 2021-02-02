package ru.job4j.io.serialization.xml;

import ru.job4j.io.Home;
import ru.job4j.io.IngenerSolutions;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Home home = new Home(
                "new Earth", 2, true, new IngenerSolutions(
                "First", "Second"), new String[]{"First", "Second"});

        JAXBContext context = JAXBContext.newInstance(Home.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(home, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {

            Home result = (Home) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
