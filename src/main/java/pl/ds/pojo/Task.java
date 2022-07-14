package pl.ds.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class Task {

    private String name;
    private String type;
    private int priority;
    private int watchdog;
    private List<ScheduledProgram> scheduledPrograms;
    private EventInfo eventInfo;
    private String description;

    public Task() {
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

    @XmlAttribute(name = "Priority")
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @XmlAttribute(name = "Watchdog")
    public int getWatchdog() {
        return watchdog;
    }

    public void setWatchdog(int watchdog) {
        this.watchdog = watchdog;
    }

    @XmlElement(name = "ScheduledProgram")
    @XmlElementWrapper(name = "ScheduledPrograms")
    public List<ScheduledProgram> getScheduledPrograms() {
        return scheduledPrograms;
    }

    public void setScheduledPrograms(List<ScheduledProgram> scheduledPrograms) {
        this.scheduledPrograms = scheduledPrograms;
    }

    @XmlElement(name = "EventInfo")
    public EventInfo getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(EventInfo eventInfo) {
        this.eventInfo = eventInfo;
    }

    @XmlElement(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\nTask{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", priority=" + priority +
                ", watchdog=" + watchdog +
                ", scheduledPrograms=" + scheduledPrograms +
                ", eventInfo=" + eventInfo +
                ", description='" + description + '\'' +
                '}';
    }
}
