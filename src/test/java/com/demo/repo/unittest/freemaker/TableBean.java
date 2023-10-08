package com.demo.repo.unittest.freemaker;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TableBean {

    /**
     * 系統使用者名稱
     */
    private String userName;

    /**
     * serialVersionUID
     */
    private String serialVersion;

    /**
     * table name
     */
    private String table;

    /**
     * table 中文名稱
     */
    private String tableName;

    /**
     * Entity Name
     */
    private String entityName;

    /**
     * 欄位資料
     */
    private List<ColumnBean> columnBeans;

    /**
     * 是否有 LocalDate 欄位
     */
    private boolean localDate;

    /**
     * 是否有 LocalDateTime 欄位
     */
    private boolean localDateTime;

    /**
     * Entity Header javaDoc createDate
     */
    private Date createDate;

    /**
     * 是否為 BaseEntity
     */
    private boolean baseEntity;

    /**
     * Constructors.
     */
    public TableBean() {
        super();
    }

    /**
     * Constructors.
     *
     * @param table the table
     */
    public TableBean(String table) {
        this();

        this.table = table;
    }

    /**
     * 系統使用者名稱
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 系統使用者名稱
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * serialVersionUID
     */
    public String getSerialVersion() {
        return serialVersion;
    }

    /**
     * serialVersionUID
     */
    public void setSerialVersion(String serialVersion) {
        this.serialVersion = serialVersion;
    }

    /**
     * table name
     */
    public String getTable() {
        return table;
    }

    /**
     * table name
     */
    public void setTable(String table) {
        this.table = table;
    }

    /**
     * table 中文名稱
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * table 中文名稱
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * Entity Name
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * Entity Name
     */
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    /**
     * 欄位資料
     */
    public List<ColumnBean> getColumnBeans() {
        return columnBeans;
    }

    /**
     * 欄位資料
     */
    public void setColumnBeans(List<ColumnBean> columnBeans) {
        this.columnBeans = columnBeans;
    }

    /**
     * 是否有 LocalDate 欄位
     */
    public boolean isLocalDate() {
        return localDate;
    }

    /**
     * 是否有 LocalDate 欄位
     */
    public void setLocalDate(boolean localDate) {
        this.localDate = localDate;
    }

    /**
     * 是否有 LocalDateTime 欄位
     */
    public boolean isLocalDateTime() {
        return localDateTime;
    }

    /**
     * 是否有 LocalDateTime 欄位
     */
    public void setLocalDateTime(boolean localDateTime) {
        this.localDateTime = localDateTime;
    }

    /**
     * Entity Header javaDoc createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Entity Header javaDoc createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the baseEntity
     */
    public boolean isBaseEntity() {
        return baseEntity;
    }

    /**
     * @param baseEntity the baseEntity to set
     */
    public void setBaseEntity(boolean baseEntity) {
        this.baseEntity = baseEntity;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
