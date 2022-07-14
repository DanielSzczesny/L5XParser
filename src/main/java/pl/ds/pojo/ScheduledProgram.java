package pl.ds.pojo;

import javax.xml.bind.annotation.XmlAttribute;

public class ScheduledProgram {

    private String name;

    public ScheduledProgram() {
    }

    @XmlAttribute(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name='" + name + "'";
    }
}
