package ru.job4j.io;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "home")
@XmlAccessorType(XmlAccessType.FIELD)
public class Home {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int quantityFloor;
    @XmlAttribute
    private boolean status;
    private IngenerSolutions solutions;
    @XmlElementWrapper(name = "reasonsForBuys")
    @XmlElement(name = "reasonForBuy")
    private String[] reasonsForBuys;

    public Home() {
    }

    public Home(
            String name, int quantityFloor, boolean status,
            IngenerSolutions solutions, String[] reasonsForBuys) {
        this.name = name;
        this.quantityFloor = quantityFloor;
        this.status = status;
        this.solutions = solutions;
        this.reasonsForBuys = reasonsForBuys;
    }

    @Override
    public String toString() {
        return "Home{"
                + "name='" + name + '\''
                + ", quantityFloor=" + quantityFloor
                + ", status=" + status
                + ", solutions=" + solutions
                + ", reasonsForBuys="
                + Arrays.toString(reasonsForBuys)
                + '}';
    }
}

