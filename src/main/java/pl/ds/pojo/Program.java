package pl.ds.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class Program {

    private String name;
    private boolean testEdits;
    private String mainRoutineName;
    private String description;
    private List<Tag> tags;
    private List<Routine> routines;

    public Program() {
    }

    @XmlAttribute(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "TestEdits")
    public boolean isTestEdits() {
        return testEdits;
    }

    public void setTestEdits(boolean testEdits) {
        this.testEdits = testEdits;
    }

    @XmlAttribute(name = "MainRoutineName")
    public String getMainRoutineName() {
        return mainRoutineName;
    }

    public void setMainRoutineName(String mainRoutineName) {
        this.mainRoutineName = mainRoutineName;
    }

    @XmlElement(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "Tag")
    @XmlElementWrapper(name = "Tags")
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @XmlElement(name = "Routine")
    @XmlElementWrapper(name = "Routines")
    public List<Routine> getRoutines() {
        return routines;
    }

    public void setRoutines(List<Routine> routines) {
        this.routines = routines;
    }

    @Override
    public String toString() {
        return "\n\tProgram{" +
                "name='" + name + '\'' +
                ", testEdits=" + testEdits +
                ", mainRoutineName='" + mainRoutineName + "\n\t" +
                "description='" + description + "\n\t" +
                "tags=" + tags + "\n\t" +
                "routines=" + routines +
                '}';
    }
}
