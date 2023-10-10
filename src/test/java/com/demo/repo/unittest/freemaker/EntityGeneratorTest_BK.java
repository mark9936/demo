package com.demo.repo.unittest.freemaker;

import com.demo.repo.unittest.AbstractIntegrationTest;
import com.demo.repo.unittest.config.ApplicationConfig;
import com.demo.util.constants.DBConstants;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.StringUtils;

@Slf4j
@ContextConfiguration(classes = ApplicationConfig.class)
public class EntityGeneratorTest_BK extends AbstractIntegrationTest {

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
    private final Configuration conf = new Configuration(Configuration.VERSION_2_3_32);

    /**
     * The Constant TABLE_NAME.
     */
    private static final String TABLE_NAME = "";
    private static String typeOfDb = "MSSQL";  // MySQL or MSSQL or Oracle
    private final String packageName = this.getClass().getPackage()
            .getName(); // 抓取專案名稱(ex:com.demo.repo.unittest.freemaker)


    /**
     * Test entity generator.
     *
     * @throws Exception the exception
     */
//    @Disabled
    @Test
    public void testEntityGenerator() throws Exception {

        try (Connection conn = dataSource.getConnection()) {
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
                columnBeans.sort(Comparator.comparing(ColumnBean::getOrdinal));
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
        }

        log.debug("finish");
    }

    private StringBuilder typeOfDbMapper(Connection conn) {
        StringBuilder sql = new StringBuilder();

        try {
            if ("mysql".equalsIgnoreCase(typeOfDb)) {
                sql.append("SELECT a.TABLE_NAME AS tableName, a.TABLE_NAME AS description ");
                sql.append("FROM INFORMATION_SCHEMA.TABLES a ");
                sql.append("WHERE a.TABLE_SCHEMA = '")
                        .append(conn.getCatalog())
                        .append("' ");
                if (StringUtils.hasText(TABLE_NAME)) {
                    sql.append(" AND a.TABLE_NAME = '" + TABLE_NAME + "'");
                }
                sql.append("ORDER BY a.TABLE_NAME");
            } else if ("oracle".equalsIgnoreCase(typeOfDb)) {
                sql.append(
                        "SELECT a.TABLE_NAME AS tableName, b.COMMENTS AS description FROM ALL_TABLES a ");
                sql.append(" JOIN ALL_TAB_COMMENTS b ON a.TABLE_NAME = b.TABLE_NAME ");
                sql.append(" WHERE a.OWNER = 'NSMS_DEV'");
                if (StringUtils.hasText(TABLE_NAME)) {
                    sql.append(" AND a.TABLE_NAME = '").append(TABLE_NAME).append("'");
                }
                sql.append(" ORDER BY a.TABLE_NAME");
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
     * @param conn
     * @return the list
     * @throws Exception the exception
     */
    private List<TableBean> listTableBeans(Connection conn) throws Exception {
        List<TableBean> tableBeans = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append(typeOfDbMapper(conn));

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
        SecureRandom secureRandom = new SecureRandom();

        // Generate a random number with up to 25 decimal places
        double randomDouble = secureRandom.nextDouble() * Math.pow(10, 25);
        BigDecimal bigDecimal = new BigDecimal(randomDouble);

        // Convert to string and take first 19 digits
        String serialVersion = bigDecimal.toString().substring(0, 19);

        // Replace the first digit with "8" if it starts with "9"
        if (serialVersion.startsWith("9")) {
            serialVersion = "8" + serialVersion.substring(1);
        }

        // Optionally add a negative sign
        String sign = secureRandom.nextDouble() >= 0.5 ? "" : "-";

        return sign + serialVersion + "L";
    }


    /**
     * 取得 Column 資訊.
     *
     * @param conn
     * @param tableBean the table bean
     * @return the list
     * @throws SQLException the SQL exception
     */
    private List<ColumnBean> readColumnTableInfo(Connection conn, TableBean tableBean)
            throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * ");
        sql.append("FROM INFORMATION_SCHEMA.COLUMNS ");
        sql.append("WHERE TABLE_NAME = ? ");
        sql.append("ORDER BY ORDINAL_POSITION ");

        PreparedStatement stat = conn.prepareStatement(sql.toString());
        stat.setString(1, tableBean.getTable());
        ResultSet rs = stat.executeQuery();

        List<ColumnBean> columnBeans = new ArrayList<>();
        while (rs.next()) {
            ColumnBean bean = new ColumnBean();
            String column = rs.getString("COLUMN_NAME");
            bean.setColumn(column);
            bean.setField(this.toCamelCase(column, false));
            bean.setDataType(this.convertDataType(rs.getString("DATA_TYPE").toUpperCase()));
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
        Map<String, String> currentMapping;
        if ("mysql".equalsIgnoreCase(typeOfDb)) {
            // MySQL到Java的數據類型映射
            currentMapping = getMssqlMap();
        } else if ("oracle".equalsIgnoreCase(typeOfDb)) {
            // Oracle數據庫到Java的數據類型映射
            currentMapping = getOracleMap();
        } else {
            // MSSQL數據庫到Java的數據類型映射
            currentMapping = getMssqlMap();
        }

        // 查找對應的Java數據類型
        String javaType = currentMapping.get(dataType.toUpperCase());
        if (javaType == null) {
            throw new RuntimeException("Incorrect Type: " + dataType);
        }

        return javaType;
    }

    private static Map<String, String> getOracleMap() {
        Map<String, String> oracleToJava = new HashMap<>();
        oracleToJava.put("NUMBER", "BigDecimal");
        oracleToJava.put("INTEGER", "Integer");
        oracleToJava.put("SMALLINT", "Integer");
        oracleToJava.put("FLOAT", "Double");
        oracleToJava.put("REAL", "Float");
        oracleToJava.put("DOUBLE PRECISION", "Double");
        oracleToJava.put("VARCHAR", "String");
        oracleToJava.put("VARCHAR2", "String");
        oracleToJava.put("CHAR", "String");
        oracleToJava.put("LONG", "String");
        oracleToJava.put("CLOB", "String");
        oracleToJava.put("NCLOB", "String");
        oracleToJava.put("RAW", "byte[]");
        oracleToJava.put("LONG RAW", "byte[]");
        oracleToJava.put("BLOB", "byte[]");
        oracleToJava.put("DATE", "LocalDate");
        oracleToJava.put("TIMESTAMP", "LocalDateTime");
        oracleToJava.put("TIMESTAMP WITH TIME ZONE", "ZonedDateTime");
        oracleToJava.put("TIMESTAMP WITH LOCAL TIME ZONE", "LocalDateTime");
        oracleToJava.put("INTERVAL YEAR TO MONTH", "Period");
        oracleToJava.put("INTERVAL DAY TO SECOND", "Duration");
        return oracleToJava;
    }

    private static Map<String, String> getMssqlMap() {
        Map<String, String> mssqlToJava = new HashMap<>();
        mssqlToJava.put("INT", "Integer");
        mssqlToJava.put("LONG", "Long");
        mssqlToJava.put("NUMERIC", "Long");
        mssqlToJava.put("NUMBER", "Double");
        mssqlToJava.put("FLOAT", "Double");
        mssqlToJava.put("DATE", "LocalDateTime");
        mssqlToJava.put("DATETIME", "LocalDateTime");
        mssqlToJava.put("TIMESTAMP", "LocalDateTime");
        mssqlToJava.put("TIMESTAMP(6)", "LocalDateTime");
        mssqlToJava.put("TIME", "LocalDateTime");
        mssqlToJava.put("CHAR", "String");
        mssqlToJava.put("NCHAR", "String");
        mssqlToJava.put("VARCHAR", "String");
        mssqlToJava.put("VARCHAR2", "String");
        mssqlToJava.put("NVARCHAR", "String");
        mssqlToJava.put("NVARCHAR2", "String");
        mssqlToJava.put("UNIQUEIDENTIFIER", "String");
        mssqlToJava.put("BLOB", "byte[]");
        mssqlToJava.put("BIGINT", "BigInteger");
        mssqlToJava.put("DECIMAL", "BigDecimal");
        return mssqlToJava;
    }

    private static Map<String, String> getMysqlMap() {
        Map<String, String> mysqlToJava = new HashMap<>();
        mysqlToJava.put("INT", "Integer");
        mysqlToJava.put("TINYINT", "Integer");
        mysqlToJava.put("SMALLINT", "Integer");
        mysqlToJava.put("MEDIUMINT", "Integer");
        mysqlToJava.put("BIGINT", "Long");
        mysqlToJava.put("DOUBLE", "Double");
        mysqlToJava.put("FLOAT", "Double");
        mysqlToJava.put("DECIMAL", "BigDecimal");
        mysqlToJava.put("DATETIME", "LocalDateTime");
        mysqlToJava.put("TIMESTAMP", "LocalDateTime");
        mysqlToJava.put("DATE", "LocalDate");
        mysqlToJava.put("TIME", "LocalTime");
        mysqlToJava.put("CHAR", "String");
        mysqlToJava.put("VARCHAR", "String");
        mysqlToJava.put("TEXT", "String");
        mysqlToJava.put("TINYTEXT", "String");
        mysqlToJava.put("MEDIUMTEXT", "String");
        mysqlToJava.put("LONGTEXT", "String");
        mysqlToJava.put("ENUM", "String");
        mysqlToJava.put("JSON", "String");
        mysqlToJava.put("BLOB", "byte[]");
        mysqlToJava.put("TINYBLOB", "byte[]");
        mysqlToJava.put("MEDIUMBLOB", "byte[]");
        mysqlToJava.put("LONGBLOB", "byte[]");
        mysqlToJava.put("SET", "Set<String>");
        return mysqlToJava;
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
            if (!columnBeanMap.containsKey(baseColumn)) {
                haveBaseColumn = false;
                break;
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
                .anyMatch(columnBean -> columnType.equals(columnBean.getDataType()));
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
        // 獲取基本的資源路徑
        File file = new File(this.getClass().getResource("/").getPath()).getParentFile()
                .getParentFile();

        // 從類的完整名稱生成包名稱的路徑
        String twoLevelsUpPath = getNLevelsUpPath(2);
        Path packagePath = Paths.get("", twoLevelsUpPath.split("\\."));

        // 創建完整的基本路徑
        Path basePath = Paths.get(file.getPath(), "src", "test", "java"
                , packagePath.toString()
                , "freemaker", "target");
        return new StringBuilder(basePath.toString());
    }

    /**
     * 建立 Bean.
     *
     * @param tableBean the table bean
     * @throws Exception the exception
     */
    private void build(TableBean tableBean, String type) throws Exception {
        Template template = conf.getTemplate(type + ".ftl");
        String tripleParentPath = getNLevelsUpPath(3);

        Map<String, Object> map = new HashMap<>();
        map.put("tableBean", tableBean);
        map.put("projectName", tripleParentPath);

        StringBuilder path = this.getBasePath().append(File.separator).append(type.toLowerCase());
        File parent = new File(path.toString());
        if (!parent.exists()) {
            parent.mkdirs();
        }

        File bean;
        if (type.equals("Entity")) {
            bean = new File(parent, tableBean.getEntityName() + ".java");
        } else {
            bean = new File(parent, tableBean.getEntityName() + type + ".java");
        }

        FileWriter fw = new FileWriter(bean);
        template.process(map, fw);
        fw.close();
    }

    /**
     * 取得上N層路徑並回傳(ex: levelsUp=3, com.demo)
     *
     * @return
     */
    private String getNLevelsUpPath(int levelsUp) {
        String[] parts = packageName.split("\\.");  // 使用點號分割
        return String.join(".", Arrays.copyOfRange(parts, 0, parts.length - levelsUp));
    }

}
