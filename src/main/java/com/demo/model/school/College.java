package com.demo.model.school;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 學院資料。此資料表使用文字 collegeName 作為主鍵。 */
@Entity
@Table(name = "college")
public class College implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CollegeName")
    private String collegeName;

    @Column(name = "CollegeTotalStudents")
    private Integer collegeTotalStudents;

    public College() {
    }

    public College(String collegeName, Integer collegeTotalStudents) {
        this.collegeName = collegeName;
        this.collegeTotalStudents = collegeTotalStudents;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Integer getCollegeTotalStudents() {
        return collegeTotalStudents;
    }

    public void setCollegeTotalStudents(Integer collegeTotalStudents) {
        this.collegeTotalStudents = collegeTotalStudents;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeName='" + collegeName + '\'' +
                ", collegeTotalStudents=" + collegeTotalStudents +
                '}';
    }
}
