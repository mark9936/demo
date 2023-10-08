package com.demo.model.store;

import com.demo.model.store.pk.CartPK;
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
 * @Function: Cart.java
 * @Description: Cart Entity
 * @author: kuo
 * @date: 2023/10/01
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@IdClass(CartPK.class)
@Table(name = "CART")
@NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c")
public class Cart implements Serializable {

    private static final long serialVersionUID = -8501150666087802148L;

    /**
     * mId
     */
    @Id
    @Column(name = "mId")
    private String mId;

    /**
     * cartTime
     */
    @Id
    @Column(name = "cartTime")
    private LocalDateTime cartTime;

    /**
     * tNo
     */
    @Column(name = "tNo")
    private String tNo;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
