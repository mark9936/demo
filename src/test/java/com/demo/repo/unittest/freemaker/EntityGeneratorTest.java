package com.demo.repo.unittest.freemaker;

import com.demo.repo.unittest.AbstractIntegrationTest;

import com.demo.repo.unittest.config.ApplicationConfig;
import com.demo.util.constants.DBConstants;
import com.zaxxer.hikari.pool.HikariProxyConnection;
import freemarker.template.Version;
import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.StringUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ContextConfiguration(classes = ApplicationConfig.class)
public class EntityGeneratorTest extends AbstractIntegrationTest {

    /**
     * The data source.
     */
    @Autowired
//    @Qualifier(ConstantsUtil.SCHOOL_DATA_SOURCE)
    @Qualifier(DBConstants.STORE_DATA_SOURCE)
    private DataSource dataSource;

    /**
     * The conf.
     */
    private Configuration conf = new Configuration(new Version("2.3.32"));
//    private Configuration conf;

    // /** The Constant DB_OWNER. */
    // private static final String DB_OWNER = "NSMS_DEV";

    /**
     * The Constant TABLE_NAME.
     */
    private static final String TABLE_NAME = "";

    private static final String typeOfDb = "MSSQL";  // MySQL or MSSQL

    /**
     * Test entity generator.
     *
     * @throws Exception the exception
     */
//    @Ignore
    @Test
    public void testEntityGenerator() throws Exception {
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            String templatePath = this.getClass().getResource("/freemaker").getPath();
            templatePath = templatePath.replace("%20", " ");
            conf.setDirectoryForTemplateLoading(new File(templatePath));

            // 取得 Table
            List<TableBean> tableBeans = this.listTableBeans(conn);
            AtomicInteger atomicInteger = new AtomicInteger(0);
            for (TableBean tableBean : tableBeans) {
                log.debug(
                        "== 處理 Table(" + atomicInteger.incrementAndGet() + "/" + tableBeans.size()
                                + ")：" + tableBean.getTable());

                // 取得欄位
                List<ColumnBean> columnBeans = this.readColumnTableInfo(conn, tableBean);
                columnBeans.sort((o1, o2) -> o1.getOrdinal().compareTo(o2.getOrdinal()));
                tableBean.setColumnBeans(columnBeans);
                // Process
                tableBean.setBaseEntity(this.processBaseEntity(columnBeans));
                tableBean.setLocalDate(this.processDate(columnBeans, "LocalDate"));
                tableBean.setLocalDateTime(this.processDate(columnBeans, "LocalDateTime"));

                CompletableFuture<Void> buildEntityOp = CompletableFuture.runAsync(() -> {
                    try {
                        this.build(tableBean, "Entity");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

                CompletableFuture<Void> buildRepositoryOp = CompletableFuture.runAsync(() -> {
                    try {
                        this.build(tableBean, "Repository");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

                CompletableFuture<Void> buildMapperOp = CompletableFuture.runAsync(() -> {
                    try {
                        this.build(tableBean, "Mapper");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

                CompletableFuture<Void> buildBeanOp = CompletableFuture.runAsync(() -> {
                    try {
                        this.build(tableBean, "Bean");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

                CompletableFuture<Void> buildServiceOp = CompletableFuture.runAsync(() -> {
                    try {
                        this.build(tableBean, "Service");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

                CompletableFuture<Void> buildServiceImplOp = CompletableFuture.runAsync(() -> {
                    try {
                        this.build(tableBean, "ServiceImpl");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

                CompletableFuture.allOf(buildServiceOp, buildServiceImplOp, buildRepositoryOp,
                        buildEntityOp, buildBeanOp, buildMapperOp).join();
            }
        } catch (Exception e) {
            log.error("", e);
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

        log.debug("finish");
    }

    private StringBuilder typeOfDbMapper(Connection conn) {
        StringBuilder sql = new StringBuilder();

        try {
            if ("mysql".equalsIgnoreCase(typeOfDb)) {
                sql.append("SELECT a.TABLE_NAME AS tableName, a.TABLE_NAME AS description ");
                sql.append("FROM INFORMATION_SCHEMA.TABLES a ");
//                sql.append("WHERE a.TABLE_SCHEMA = '").append(((ConnectionImpl) conn).getDatabase())
//                sql.append("WHERE a.TABLE_SCHEMA = '").append((conn instanceof HikariProxyConnection) ? ((HikariProxyConnection) conn).getCatalog() : null)
                sql.append("WHERE a.TABLE_SCHEMA = '")
                        .append(((HikariProxyConnection) conn).getCatalog())
//                sql.append("WHERE a.TABLE_SCHEMA = '").append(((ConnectionImpl) ((HikariProxyConnection) conn).delegate).database)
                        .append("' ");
                if (StringUtils.hasText(TABLE_NAME)) {
                    sql.append(" AND a.TABLE_NAME = '" + TABLE_NAME + "'");
                }
                sql.append("ORDER BY a.TABLE_NAME");
            } else { // 適用於SQL Server
                sql.append("SELECT a.name AS tableName, a.name AS description ");
                sql.append("FROM SYSOBJECTS a ");
                sql.append("WHERE a.xtype = 'U' ");
                if (StringUtils.hasText(TABLE_NAME)) {
                    sql.append(" AND a.name = '" + TABLE_NAME + "'");
                }
                sql.append("ORDER BY a.name");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sql;
    }

    /**
     * List table beans.
     *
     * @param conn the conn
     * @return the list
     * @throws Exception the exception
     */
    private List<TableBean> listTableBeans(Connection conn) throws Exception {
        List<TableBean> tableBeans = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        // sql.append("SELECT a.TABLE_NAME AS tableName, b.COMMENTS AS description FROM ALL_TABLES a ");
        // sql.append(" JOIN ALL_TAB_COMMENTS b ON a.TABLE_NAME = b.TABLE_NAME ");
        // sql.append(" WHERE a.OWNER = '" + DB_OWNER + "'");
        // if (StringUtils.hasText(TABLE_NAME)) {
        // sql.append(" AND a.TABLE_NAME = '" + TABLE_NAME + "'");
        // }
        // sql.append(" ORDER BY a.TABLE_NAME");

        sql.append(typeOfDbMapper(conn));
//        sql.append("SELECT a.name AS tableName, a.name AS description ");
//        sql.append("FROM SYSOBJECTS a ");  // 適用於SQL Server
//        sql.append("WHERE a.xtype = 'U' ");
//        if (StringUtils.hasText(TABLE_NAME)) {
//            sql.append(" AND a.name = '" + TABLE_NAME + "'");
//        }
//        sql.append("ORDER BY a.name");

        PreparedStatement stat = conn.prepareStatement(sql.toString());
        ResultSet rs = stat.executeQuery();
        while (rs.next()) {
            TableBean tableBean = new TableBean(rs.getString("tableName").toUpperCase());
            String table = this.toCamelCase(tableBean.getTable(), true);
            String entityName = table.substring(0, 1).toUpperCase() + table.substring(1);

            tableBean.setUserName(System.getProperties().getProperty("user.name"));
            tableBean.setTableName(
                    StringUtils.hasText(rs.getString("description")) ? rs.getString("description")
                            : "");
            tableBean.setEntityName(entityName);
            tableBean.setSerialVersion(this.buildSerialVersionUid());
            tableBeans.add(tableBean);
        }

        return tableBeans;
    }

    /**
     * serialVersionUID.
     *
     * @return the string
     */
    private String buildSerialVersionUid() {
        String serialVersion = new BigDecimal(
                (Double) (new SecureRandom().nextDouble() * Math.pow(10, 25))).toString()
                .substring(0, 19);
        serialVersion =
                serialVersion.startsWith("9") ? "8" + serialVersion.substring(1) : serialVersion;
        String pre = new SecureRandom().nextDouble() >= 0.5 ? "" : "-";

        return pre + serialVersion + "L";
    }

    /**
     * 取得 Column 資訊.
     *
     * @param conn      the conn
     * @param tableBean the table bean
     * @return the list
     * @throws SQLException the SQL exception
     */
    private List<ColumnBean> readColumnTableInfo(Connection conn, TableBean tableBean)
            throws SQLException {
        StringBuilder sql = new StringBuilder();
        // sql.append("SELECT tab.COLUMN_NAME, col.COMMENTS AS DESCRIPTION, DATA_TYPE, COLUMN_ID AS ORDINAL_POSITION");
        // sql.append(" FROM ALL_TAB_COLUMNS tab");
        // sql.append(" JOIN ALL_COL_COMMENTS col ON col.OWNER = tab.OWNER ");
        // sql.append(" AND col.TABLE_NAME = tab.TABLE_NAME AND col.COLUMN_NAME = tab.COLUMN_NAME");
        // sql.append(" WHERE tab.OWNER = '" + DB_OWNER + "'");
        // sql.append(" AND tab.TABLE_NAME = ?");
        // sql.append(" ORDER BY ORDINAL_POSITION");
        sql.append("SELECT ");
        sql.append("    * ");
        sql.append("FROM ");
        sql.append("    INFORMATION_SCHEMA.COLUMNS ");
        sql.append("WHERE ");
        sql.append("    TABLE_NAME = ? ");
        sql.append("ORDER BY ORDINAL_POSITION ");

        PreparedStatement stat = conn.prepareStatement(sql.toString());
        stat.setString(1, tableBean.getTable());
        ResultSet rs = stat.executeQuery();

        List<ColumnBean> columnBeans = new ArrayList<>();
        while (rs.next()) {
            ColumnBean bean = new ColumnBean();
            // String column = rs.getString("COLUMN_NAME").toUpperCase();
            String column = rs.getString("COLUMN_NAME");
            bean.setColumn(column);
            bean.setField(this.toCamelCase(column, false));
            bean.setDataType(this.convertDataType(rs.getString("DATA_TYPE").toUpperCase()));
            // columnBean.setColumnName(rs.getString("DESCRIPTION"));
            bean.setColumnName(rs.getString("COLUMN_NAME"));
            bean.setOrdinal(rs.getInt("ORDINAL_POSITION"));

            columnBeans.add(bean);
        }

        rs.close();
        stat.close();

        return columnBeans;
    }

    /**
     * Convert data type.
     *
     * @param dataType the data type
     * @return the string
     */
    private String convertDataType(String dataType) {
        if ("mysql".equalsIgnoreCase(typeOfDb)) {
            switch (dataType) {
                case "INT":
                case "TINYINT":
                case "SMALLINT":
                case "MEDIUMINT":
                    dataType = "Integer";
                    break;
                case "BIGINT":
                    dataType = "Long";
                    break;
                case "DOUBLE":
                case "FLOAT":
                    dataType = "Double";
                    break;
                case "DECIMAL":
                    dataType = "BigDecimal";
                    break;
                case "DATETIME":
                case "TIMESTAMP":
                    dataType = "LocalDateTime";
                    break;
                case "DATE":
                    dataType = "LocalDate";
                    break;
                case "TIME":
                    dataType = "LocalTime";
                    break;
                case "CHAR":
                case "VARCHAR":
                case "TEXT":
                case "TINYTEXT":
                case "MEDIUMTEXT":
                case "LONGTEXT":
                    dataType = "String";
                    break;
                case "BLOB":
                case "TINYBLOB":
                case "MEDIUMBLOB":
                case "LONGBLOB":
                    dataType = "byte[]";
                    break;
                case "ENUM":
                    dataType = "String"; // 或者對應到一個自定義的Enum類型
                    break;
                case "SET":
                    dataType = "Set<String>"; // 或者對應到一個自定義的Set類型
                    break;
                case "JSON":
                    dataType = "String"; // 或者對應到一個更複雜的Java類型，如Map或自定義的類
                    break;
                default:
                    throw new RuntimeException("Incorrect Type : " + dataType);
            }
        } else {
            switch (dataType) {
                case "INT":
                    dataType = "Integer";
                    break;
                case "LONG":
                case "NUMERIC":
                    dataType = "Long";
                    break;
                case "NUMBER":
                case "FLOAT":
                    dataType = "Double";
                    break;
                case "DATE":
                case "DATETIME":
                case "TIMESTAMP":
                case "TIMESTAMP(6)":
                case "TIME":
                    dataType = "LocalDateTime";
                    break;
                case "CHAR":
                case "NCHAR":
                case "VARCHAR":
                case "VARCHAR2":
                case "NVARCHAR":
                case "NVARCHAR2":
                    // FIXME 確認Java type
                case "UNIQUEIDENTIFIER":
                    dataType = "String";
                    break;
                case "BLOB":
                    dataType = "byte[]";
                    break;
                case "BIGINT":
                    dataType = "BigInteger";
                    break;
                case "DECIMAL":
                    dataType = "BigDecimal";
                    break;
                default:
                    throw new RuntimeException("Incorrect Type : " + dataType);
            }
        }
        return dataType;
    }

    /**
     * 是否為 BaseEntity.
     *
     * @param columnBeans the column beans
     * @return true, if successful
     */
    private boolean processBaseEntity(List<ColumnBean> columnBeans) {
        Map<String, ColumnBean> columnBeanMap = columnBeans.parallelStream()
                .collect(Collectors.toMap(ColumnBean::getField, Function.identity()));
        List<String> baseColumns = Arrays.asList("CreationUserId", "CreationDTime", "ModifyUserId",
                "ModifyDTime");
        baseColumns = baseColumns.stream().map(baseColumn -> this.toCamelCase(baseColumn, false))
                .collect(Collectors.toList());

        boolean haveBaseColumn = true;
        for (String baseColumn : baseColumns) {
            if (false == columnBeanMap.containsKey(baseColumn)) {
                haveBaseColumn = false;
            }
        }

        if (haveBaseColumn) {
            Iterator<ColumnBean> iterator = columnBeans.iterator();
            while (iterator.hasNext()) {
                if (baseColumns.contains(iterator.next().getField())) {
                    iterator.remove();
                }
            }
        }

        return haveBaseColumn;
    }

    /**
     * 是否有 LocalData or LocalDataTime 欄位.
     *
     * @param columnBeans the column beans
     * @return true, if successful
     */
    private boolean processDate(List<ColumnBean> columnBeans, String columnType) {
        return columnBeans.stream()
                .filter(columnBean -> columnType.equals(columnBean.getDataType()))
                .collect(Collectors.counting()) > 0;
    }

    /**
     * 駝峰式命名.
     *
     * @param name the name
     * @return the string
     */
    private String toCamelCase(String name, boolean isTable) {
        // Split string by capital letters
        String[] strs = isTable ? name.split("_") : name.split("(?=\\p{Lu})");

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            str = str.toLowerCase();
            if (sb.length() == 0) {
                sb.append(str);
            } else {
                sb.append(str.substring(0, 1).toUpperCase()).append(str.substring(1));
            }
        }
        return sb.toString();
    }

    /**
     * Gets the base path.
     *
     * @return the base path
     */
    private StringBuilder getBasePath() {
        File file = new File(this.getClass().getResource("/").getPath()).getParentFile()
                .getParentFile();
        StringBuilder sb = new StringBuilder();
        sb = sb.append(file.getPath());
        sb = sb.append(File.separator).append("src");
        sb = sb.append(File.separator).append("test");
        sb = sb.append(File.separator).append("java");
        sb = sb.append(File.separator).append("com");
        sb = sb.append(File.separator).append("demo");
        sb = sb.append(File.separator).append("repo");
        sb = sb.append(File.separator).append("freemaker");
        sb = sb.append(File.separator).append("target");
        return sb;
    }

    /**
     * 建立 Bean.
     *
     * @param tableBean the table bean
     * @throws Exception the exception
     */
    private void build(TableBean tableBean, String type) throws Exception {
        Template template = conf.getTemplate(type + ".ftl");
        Map<String, Object> map = new HashMap<>();
        map.put("tableBean", tableBean);

        StringBuilder path = this.getBasePath().append(File.separator).append(type.toLowerCase());
        File parent = new File(path.toString());
        if (false == parent.exists()) {
            parent.mkdirs();
        }

        File bean = null;
        switch (type) {
            case "Entity":
                bean = new File(parent, tableBean.getEntityName() + ".java");
                break;
            default:
                bean = new File(parent, tableBean.getEntityName() + type + ".java");
                break;
        }

        // try (FileWriter fw = new FileWriter(bean)) {
        // template.process(map, fw);
        // }
        FileWriter fw = new FileWriter(bean);
        template.process(map, fw);
        fw.close();
    }

}
