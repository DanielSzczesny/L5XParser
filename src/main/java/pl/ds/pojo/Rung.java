package pl.ds.pojo;

import javax.xml.bind.annotation.XmlElement;

public class Rung {
    public Rung(String comment, String text) {
        this.comment = comment;
        this.text = text;
    }

    private String comment;
    private String text;

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
