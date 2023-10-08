package com.demo.model.store;

import com.demo.model.store.pk.AuthorPK;
import java.io.Serializable;

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
 * @Function: Author.java
 * @Description: Author Entity
 * @author: kuo
 * @date: 2023/10/01
 * @MaintenancePersonnel: kuo
 */
@Data
@Entity
@IdClass(AuthorPK.class)
@Table(name = "AUTHOR")
@NamedQuery(name = "Author.findAll", query = "SELECT c FROM Author c")
public class Author implements Serializable {

    private static final long serialVersionUID = -6324209630358694434L;

    /**
     * pNo
     */
    @Id
    @Column(name = "pNo")
    private String pNo;

    /**
     * name
     */
    @Id
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
