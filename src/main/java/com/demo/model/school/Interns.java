package com.demo.model.school;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 實習生資料。 */
@Entity
@Table(name = "interns")
public class Interns implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "InternID")
    private Integer internId;

    @Column(name = "PersonID")
    private Integer personId;

    @Column(name = "InternHourlyWage")
    private Integer internHourlyWage;

    public Interns() {
    }

    public Interns(Integer internId, Integer personId, Integer internHourlyWage) {
        this.internId = internId;
        this.personId = personId;
        this.internHourlyWage = internHourlyWage;
    }

    public Integer getInternId() {
        return internId;
    }

    public void setInternId(Integer internId) {
        this.internId = internId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getInternHourlyWage() {
        return internHourlyWage;
    }

    public void setInternHourlyWage(Integer internHourlyWage) {
        this.internHourlyWage = internHourlyWage;
    }

    @Override
    public String toString() {
        return "Interns{" +
                "internId=" + internId +
                ", personId=" + personId +
                ", internHourlyWage=" + internHourlyWage +
                '}';
    }
}
