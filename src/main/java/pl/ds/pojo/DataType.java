package pl.ds.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class DataType {

    private String name;
    private String description;
    private List<Member> members;

    public DataType() {
    }

    @XmlAttribute(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "Member")
    @XmlElementWrapper(name = "Members")
    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "\n\tDataType{" +
                "name='" + name + "\n\t" +
                "description='" + description + "\n\t" +
                "members=" + members + "\n\t" +
                '}' + "\n";
    }
}
