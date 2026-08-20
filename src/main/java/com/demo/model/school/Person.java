package com.demo.model.school;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 個人基本資料。 */
@Entity
@Table(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PersonID")
    private Integer personId;

    @Column(name = "PersonPhoneNumber")
    private String personPhoneNumber;

    @Column(name = "PersonName")
    private String personName;

    public Person() {
    }

    public Person(Integer personId, String personPhoneNumber, String personName) {
        this.personId = personId;
        this.personPhoneNumber = personPhoneNumber;
        this.personName = personName;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonPhoneNumber() {
        return personPhoneNumber;
    }

    public void setPersonPhoneNumber(String personPhoneNumber) {
        this.personPhoneNumber = personPhoneNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", personPhoneNumber='" + personPhoneNumber + '\'' +
                ", personName='" + personName + '\'' +
                '}';
    }
}
