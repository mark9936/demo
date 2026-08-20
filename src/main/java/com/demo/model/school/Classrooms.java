package com.demo.model.school;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 教室資料。欄位中的 buildingId 是關聯校舍的識別值；為了讓初學者先專注於 CRUD，
 * 本範例先以 Integer 保存外鍵，不建立 JPA 關聯物件。
 */
@Entity
@Table(name = "classrooms")
public class Classrooms implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "RoomNumber")
    private Integer roomNumber;

    @Column(name = "HasProjector")
    private String hasProjector;

    @Column(name = "BuildingID")
    private Integer buildingId;

    public Classrooms() {
    }

    public Classrooms(Integer roomNumber, String hasProjector, Integer buildingId) {
        this.roomNumber = roomNumber;
        this.hasProjector = hasProjector;
        this.buildingId = buildingId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(String hasProjector) {
        this.hasProjector = hasProjector;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    @Override
    public String toString() {
        return "Classrooms{" +
                "roomNumber=" + roomNumber +
                ", hasProjector='" + hasProjector + '\'' +
                ", buildingId=" + buildingId +
                '}';
    }
}
