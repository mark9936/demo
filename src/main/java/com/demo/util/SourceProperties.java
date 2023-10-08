package com.demo.util;

import lombok.Data;

@Data
public class SourceProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private int maximumPoolSize;
    private long idleTimeout;
    private long connectionTimeout;
    private long maxLifetime;
    private long validationTimeout;
    private String databasePlatform;
    private boolean showSql;
    private boolean generateDdl;
}
