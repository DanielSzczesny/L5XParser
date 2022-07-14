package pl.ds.pojo;

import javax.xml.bind.annotation.XmlAttribute;

public class Tag {

    private String name;
    private String tagType;
    private String dataType;
    private String dimensions;
    private String data;

    public Tag() {
    }

    @XmlAttribute(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "TagType")
    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    @XmlAttribute(name = "DataType")
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @XmlAttribute(name = "Dimensions")
    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @XmlAttribute(name = "Data")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                ", tagType='" + tagType + '\'' +
                ", dataType='" + dataType + '\'' +
                ", dimensions='" + dimensions + '\'' +
                '}';
    }
}
