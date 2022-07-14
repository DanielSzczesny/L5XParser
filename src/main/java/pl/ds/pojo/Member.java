package pl.ds.pojo;

import javax.xml.bind.annotation.XmlAttribute;

public class Member {

    private String name;
    private String dataType;
    private String dimension;
    private String radix;
    private String description;

    public Member() {
    }

    @XmlAttribute(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "DataType")
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @XmlAttribute(name = "Dimension")
    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    @XmlAttribute(name = "Radix")
    public String getRadix() {
        return radix;
    }

    public void setRadix(String radix) {
        this.radix = radix;
    }

    @XmlAttribute(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\n\tMember{" +
                "name='" + name + '\'' +
                ", dataType='" + dataType + '\'' +
                ", dimension='" + dimension + '\'' +
                ", radix='" + radix + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
