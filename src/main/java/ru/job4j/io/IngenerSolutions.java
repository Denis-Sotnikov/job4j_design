package ru.job4j.io;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "contact")
public class IngenerSolutions {
    @XmlAttribute
    private String ventilation;
    @XmlAttribute
    private String foundation;

    public IngenerSolutions() {
    }

    public IngenerSolutions(String ventilation, String foundation) {
        this.ventilation = ventilation;
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "IngenerSolutions{"
                + "ventilation='" + ventilation + '\''
                + ", foundation='" + foundation + '\''
                + '}';
    }
}