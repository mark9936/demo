package com.demo.model.store;

import com.demo.model.store.pk.RecordPK;
import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Function: Record.java
 * @Description: Record Entity
 * @author: kuo
 * @date: 2023/10/01
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@IdClass(RecordPK.class)
@Table(name = "RECORD")
@NamedQuery(name = "Record.findAll", query = "SELECT c FROM Record c")
public class Record implements Serializable {

    private static final long serialVersionUID = 3210500001536842619L;

    /**
     * tNo
     */
    @Id
    @Column(name = "tNo")
    private String tNo;

    /**
     * pNo
     */
    @Id
    @Column(name = "pNo")
    private String pNo;

    /**
     * salePrice
     */
    @Column(name = "salePrice")
    private BigDecimal salePrice;

    /**
     * amount
     */
    @Column(name = "amount")
    private Integer amount;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
