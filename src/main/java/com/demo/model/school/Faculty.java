package com.demo.model.school;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 教職員資料。 */
@Entity
@Table(name = "faculty")
public class Faculty implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FacultyID")
    private Integer facultyId;

    @Column(name = "FacultyTitle")
    private String facultyTitle;

    @Column(name = "FacultySalary")
    private Integer facultySalary;

    @Column(name = "FacultyName")
    private String facultyName;

    @Column(name = "PersonID")
    private Integer personId;

    public Faculty() {
    }

    public Faculty(Integer facultyId, String facultyTitle, Integer facultySalary,
                   String facultyName, Integer personId) {
        this.facultyId = facultyId;
        this.facultyTitle = facultyTitle;
        this.facultySalary = facultySalary;
        this.facultyName = facultyName;
        this.personId = personId;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyTitle() {
        return facultyTitle;
    }

    public void setFacultyTitle(String facultyTitle) {
        this.facultyTitle = facultyTitle;
    }

    public Integer getFacultySalary() {
        return facultySalary;
    }

    public void setFacultySalary(Integer facultySalary) {
        this.facultySalary = facultySalary;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyTitle='" + facultyTitle + '\'' +
                ", facultySalary=" + facultySalary +
                ", facultyName='" + facultyName + '\'' +
                ", personId=" + personId +
                '}';
    }
}
