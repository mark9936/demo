package com.demo.model.school;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 校舍資料。
 *
 * <p>{@link Entity} 表示這個 Java 類別要對應到資料庫資料表。
 * 這個類別同時也是本範例的 POJO：它只保存資料，不負責商業流程。</p>
 */
@Entity
@Table(name = "buildings")
public class Buildings implements Serializable {

    private static final long serialVersionUID = 1L;

    /** {@link Id} 表示這是每筆資料唯一的主鍵，這個範例由 API 呼叫者提供。 */
    @Id
    @Column(name = "BuildingID")
    private Integer buildingId;

    @Column(name = "BuildingName")
    private String buildingName;

    @Column(name = "CollegeName")
    private String collegeName;

    public Buildings() {
    }

    public Buildings(Integer buildingId, String buildingName, String collegeName) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.collegeName = collegeName;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        return "Buildings{" +
                "buildingId=" + buildingId +
                ", buildingName='" + buildingName + '\'' +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }
}
