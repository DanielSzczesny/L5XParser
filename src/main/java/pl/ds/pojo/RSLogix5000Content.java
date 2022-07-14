package pl.ds.pojo;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "RSLogix5000Content")
public class RSLogix5000Content {

    private String targetName;

    private Controller controller;

    public RSLogix5000Content() {
    }

    @XmlAttribute(name = "TargetName")
    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    @XmlElement(name = "Controller")
    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public String toString() {
        return "RSLogix5000Content{" +
                "targetName='" + targetName + "\n\t" +
                "controller=" + controller + "\n\t" +
                '}';
    }
}
