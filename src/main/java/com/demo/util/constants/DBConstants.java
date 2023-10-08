package com.demo.util.constants;

public class DBConstants {

    // ------------ Data Source ------------
    public static final String ENTITY_MANAGER_FACTORY = "EntityManagerFactory";
    public static final String TRANSACTION_MANAGER = "TransactionManager";
    public static final String DATA_SOURCE = "DataSource";

    private static final String STORE = "storeDB";
    public static final String STORE_ENTITY_MANAGER_FACTORY = STORE + ENTITY_MANAGER_FACTORY;
    public static final String STORE_TRANSACTION_MANAGER = STORE + TRANSACTION_MANAGER;
    public static final String STORE_DATA_SOURCE = STORE + DATA_SOURCE;

    private static final String SCHOOL = "schoolDB";
    public static final String SCHOOL_ENTITY_MANAGER_FACTORY = SCHOOL + ENTITY_MANAGER_FACTORY;
    public static final String SCHOOL_TRANSACTION_MANAGER = SCHOOL + TRANSACTION_MANAGER;
    public static final String SCHOOL_DATA_SOURCE = SCHOOL + DATA_SOURCE;

}
