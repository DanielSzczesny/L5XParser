package pl.ds.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Rung {

    private String comment;
    private String text;
    private int number;

    public Rung() {
    }

    @XmlElement(name = "Comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @XmlElement(name = "Text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @XmlAttribute(name = "Number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Rung{" +
                "comment='" + checkCommentExist(comment) + '\'' +
                ", text='" + text + "'" +
                '}';
    }

    private String checkCommentExist(String comment) {
        if (comment != null && !comment.isEmpty()) return "exist";
        else return "not exist";
    }
}
