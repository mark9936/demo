package com.demo.repo.unittest.freemaker;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ColumnBean {

    /**
     * 欄位名稱
     */
    private String column;

    /**
     * 欄位 Field
     */
    private String field;

    /**
     * 資料類型
     */
    private String dataType;

    /**
     * 欄位中文名稱
     */
    private String columnName;

    /**
     * 排序
     */
    private Integer ordinal;

    /**
     * 欄位名稱
     */
    public String getColumn() {
        return column;
    }

    /**
     * 欄位名稱
     */
    public void setColumn(String column) {
        this.column = column;
    }

    /**
     * 欄位 Field
     */
    public String getField() {
        return field;
    }

    /**
     * 欄位 Field
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * 資料類型
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * 資料類型
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * 欄位中文名稱
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 欄位中文名稱
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * 排序
     */
    public Integer getOrdinal() {
        return ordinal;
    }

    /**
     * 排序
     */
    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    /**
     * 首字大寫
     */
    public String getMethodFiled() {
        return field.substring(0, 1).toUpperCase() + field.substring(1);
    }

    /**
     * (non-Javadoc)
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
