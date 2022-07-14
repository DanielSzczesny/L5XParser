package pl.ds.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class Routine {

    private String name;
    private String type;
    private List<Rung> rungs;

    public Routine() {
    }

    @XmlAttribute(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name = "Rung")
    @XmlElementWrapper(name = "RLLContent")
    public List<Rung> getRungs() {
        return rungs;
    }

    public void setRungs(List<Rung> rungs) {
        this.rungs = rungs;
    }

    @Override
    public String toString() {
        return "Routine{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", rungs=" + rungs +
                '}';
    }
}
