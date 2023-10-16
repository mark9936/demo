package com.demo.config.jpa;

import static com.demo.util.constants.DBConstants.STORE_DATA_SOURCE;
import static com.demo.util.constants.DBConstants.STORE_ENTITY_MANAGER_FACTORY;
import static com.demo.util.constants.DBConstants.STORE_TRANSACTION_MANAGER;

import com.demo.util.SourceProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.demo.repository.store"},
        entityManagerFactoryRef = STORE_ENTITY_MANAGER_FACTORY,
        transactionManagerRef = STORE_TRANSACTION_MANAGER
)
public class StoreJPAConfig {

    @Bean(name = "storeProperties")
    @ConfigurationProperties(prefix = "spring.datasource.store")
    public SourceProperties storeProperties() {
        return new SourceProperties();
    }

    @Primary
    @Bean(name = STORE_DATA_SOURCE)
    public DataSource STORE_DATA_SOURCE(
            @Qualifier("storeProperties") SourceProperties properties) {
        HikariConfig config = new HikariConfig();
        applyProperties(config, properties);
        return new HikariDataSource(config);
    }

    @Primary
    @Bean(name = "storeJpaVendorAdapter")
    public JpaVendorAdapter storeJpaVendorAdapter(
            @Qualifier("storeProperties") SourceProperties properties) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.SQL_SERVER);
        vendorAdapter.setDatabasePlatform(properties.getDatabasePlatform());
        vendorAdapter.setShowSql(properties.isShowSql());
        vendorAdapter.setGenerateDdl(properties.isGenerateDdl());
        return vendorAdapter;
    }

    @Bean(name = "storeJpaProperties")
    public Properties storeJpaProperties() {
        Properties jpaProps = new Properties();
        jpaProps.put("hibernate.jdbc.batch_size", "100");
        jpaProps.put("hibernate.order_inserts", "true");
        jpaProps.put("hibernate.order_updates", "true");
        return jpaProps;
    }

    @Primary
    @Bean(name = STORE_ENTITY_MANAGER_FACTORY)
    public LocalContainerEntityManagerFactoryBean storeDBEntityManagerFactory(
            @Qualifier(STORE_DATA_SOURCE) DataSource dataSource,
            @Qualifier("storeJpaVendorAdapter") JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setJpaVendorAdapter(jpaVendorAdapter);
        em.setPackagesToScan("com.demo.model.store");
        em.setDataSource(dataSource);
        em.setJpaProperties(this.storeJpaProperties());
        return em;
    }

    @Primary
    @Bean(name = STORE_TRANSACTION_MANAGER)
    public PlatformTransactionManager storeDBTransactionManager(
            @Qualifier(STORE_ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    private void applyProperties(HikariConfig config, SourceProperties properties) {
        config.setJdbcUrl(properties.getUrl());
        config.setDriverClassName(properties.getDriverClassName());
        config.setUsername(properties.getUsername());
        config.setPassword(properties.getPassword());
        config.setMaximumPoolSize(properties.getMaximumPoolSize());
        config.setIdleTimeout(properties.getIdleTimeout());
        config.setConnectionTimeout(properties.getConnectionTimeout());
        config.setMaxLifetime(properties.getMaxLifetime());
        config.setValidationTimeout(properties.getValidationTimeout());
    }
}