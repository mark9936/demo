package com.demo.model.school;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 開課班級資料。LocalDate 會對應到資料庫的日期型別。 */
@Entity
@Table(name = "school_section")
public class Section implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "SectionID")
    private Integer sectionId;

    @Column(name = "SectionDate")
    private LocalDate sectionDate;

    @Column(name = "RoomNumber")
    private Integer roomNumber;

    @Column(name = "CourseID")
    private Integer courseId;

    @Column(name = "BuildingID")
    private Integer buildingId;

    @Column(name = "PersonID")
    private Integer personId;

    public Section() {
    }

    public Section(Integer sectionId, LocalDate sectionDate, Integer roomNumber,
                   Integer courseId, Integer buildingId, Integer personId) {
        this.sectionId = sectionId;
        this.sectionDate = sectionDate;
        this.roomNumber = roomNumber;
        this.courseId = courseId;
        this.buildingId = buildingId;
        this.personId = personId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public LocalDate getSectionDate() {
        return sectionDate;
    }

    public void setSectionDate(LocalDate sectionDate) {
        this.sectionDate = sectionDate;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionId=" + sectionId +
                ", sectionDate=" + sectionDate +
                ", roomNumber=" + roomNumber +
                ", courseId=" + courseId +
                ", buildingId=" + buildingId +
                ", personId=" + personId +
                '}';
    }
}
