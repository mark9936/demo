package com.demo.model.store;

import com.demo.model.store.pk.BrowsePK;
import java.io.Serializable;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: Browse.java
 * @Description: Browse Entity
 * @author: kuo
 * @date: 2023/10/01
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@IdClass(BrowsePK.class)
@Table(name = "BROWSE")
@NamedQuery(name = "Browse.findAll", query = "SELECT c FROM Browse c")
public class Browse implements Serializable {

    private static final long serialVersionUID = -8608900476193959638L;

    /**
     * mId
     */
    @Id
    @Column(name = "mId")
    private String mId;

    /**
     * pNo
     */
    @Id
    @Column(name = "pNo")
    private String pNo;

    /**
     * browseTime
     */
    @Id
    @Column(name = "browseTime")
    private LocalDateTime browseTime;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}

