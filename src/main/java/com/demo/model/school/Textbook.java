package com.demo.model.school;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 教科書資料。 */
@Entity
@Table(name = "textbook")
public class Textbook implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TextbookISBN")
    private Integer textbookIsbn;

    @Column(name = "TextbookTitle")
    private String textbookTitle;

    @Column(name = "TextbookAuthor")
    private String textbookAuthor;

    public Textbook() {
    }

    public Textbook(Integer textbookIsbn, String textbookTitle, String textbookAuthor) {
        this.textbookIsbn = textbookIsbn;
        this.textbookTitle = textbookTitle;
        this.textbookAuthor = textbookAuthor;
    }

    public Integer getTextbookIsbn() {
        return textbookIsbn;
    }

    public void setTextbookIsbn(Integer textbookIsbn) {
        this.textbookIsbn = textbookIsbn;
    }

    public String getTextbookTitle() {
        return textbookTitle;
    }

    public void setTextbookTitle(String textbookTitle) {
        this.textbookTitle = textbookTitle;
    }

    public String getTextbookAuthor() {
        return textbookAuthor;
    }

    public void setTextbookAuthor(String textbookAuthor) {
        this.textbookAuthor = textbookAuthor;
    }

    @Override
    public String toString() {
        return "Textbook{" +
                "textbookIsbn=" + textbookIsbn +
                ", textbookTitle='" + textbookTitle + '\'' +
                ", textbookAuthor='" + textbookAuthor + '\'' +
                '}';
    }
}
