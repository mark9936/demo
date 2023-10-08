package com.demo.model.school;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigInteger;
import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

/**
 * @Function: Textbook.java
 * @Description: Textbook Entity
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@Table(name = "TEXTBOOK")
@NamedQuery(name = "Textbook.findAll", query = "SELECT c FROM Textbook c")
public class Textbook implements Serializable {

    private static final long serialVersionUID = -5914013587438811180L;

    /**
     * TextbookISBN
     */
    @Id
    @Column(name = "TextbookISBN")
    private Integer textbookISBN;

    /**
     * TextbookTitle
     */
    @Column(name = "TextbookTitle")
    private String textbookTitle;

    /**
     * TextbookAuthor
     */
    @Column(name = "TextbookAuthor")
    private String textbookAuthor;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
