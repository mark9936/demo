package com.demo.model.school;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 課程資料。textbookIsbn 先以數字保存對應教科書的主鍵。 */
@Entity
@Table(name = "course")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CourseID")
    private Integer courseId;

    @Column(name = "CourseName")
    private String courseName;

    @Column(name = "TextbookISBN")
    private Integer textbookIsbn;

    public Course() {
    }

    public Course(Integer courseId, String courseName, Integer textbookIsbn) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.textbookIsbn = textbookIsbn;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getTextbookIsbn() {
        return textbookIsbn;
    }

    public void setTextbookIsbn(Integer textbookIsbn) {
        this.textbookIsbn = textbookIsbn;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", textbookIsbn=" + textbookIsbn +
                '}';
    }
}
