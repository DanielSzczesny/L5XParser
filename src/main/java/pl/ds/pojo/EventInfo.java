package pl.ds.pojo;

import javax.xml.bind.annotation.XmlAttribute;

public class EventInfo {

    private String eventTrigger;
    private String eventTag;

    public EventInfo() {
    }

    @XmlAttribute(name = "EventTrigger")
    public String getEventTrigger() {
        return eventTrigger;
    }

    public void setEventTrigger(String eventTrigger) {
        this.eventTrigger = eventTrigger;
    }

    @XmlAttribute(name = "EventTag")
    public String getEventTag() {
        return eventTag;
    }

    public void setEventTag(String eventTag) {
        this.eventTag = eventTag;
    }

    @Override
    public String toString() {
        return "EventInfo{" +
                "eventTrigger='" + eventTrigger + '\'' +
                ", eventTag='" + eventTag + '\'' +
                '}';
    }
}
