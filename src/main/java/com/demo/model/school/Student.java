package com.demo.model.school;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 學生資料，也是 README 中用來示範完整 CRUD 流程的主要 Entity。
 */
@Entity
@Table(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "StudentID")
    private Integer studentId;

    @Column(name = "StudentGPA")
    private Double studentGpa;

    @Column(name = "StudentName")
    private String studentName;

    @Column(name = "PersonID")
    private Integer personId;

    public Student() {
    }

    public Student(Integer studentId, Double studentGpa, String studentName, Integer personId) {
        this.studentId = studentId;
        this.studentGpa = studentGpa;
        this.studentName = studentName;
        this.personId = personId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Double getStudentGpa() {
        return studentGpa;
    }

    public void setStudentGpa(Double studentGpa) {
        this.studentGpa = studentGpa;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentGpa=" + studentGpa +
                ", studentName='" + studentName + '\'' +
                ", personId=" + personId +
                '}';
    }
}
