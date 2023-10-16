package com.demo.config.jpa;

import static com.demo.util.constants.DBConstants.SCHOOL_DATA_SOURCE;
import static com.demo.util.constants.DBConstants.SCHOOL_ENTITY_MANAGER_FACTORY;
import static com.demo.util.constants.DBConstants.SCHOOL_TRANSACTION_MANAGER;

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
        basePackages = {"com.demo.repository.school"},
        entityManagerFactoryRef = SCHOOL_ENTITY_MANAGER_FACTORY,
        transactionManagerRef = SCHOOL_TRANSACTION_MANAGER
)
public class SchoolJPAConfig {

    @Bean(name = "schoolProperties")
    @ConfigurationProperties(prefix = "spring.datasource.school")
    public SourceProperties schoolProperties() {
        return new SourceProperties();
    }

    @Bean(name = SCHOOL_DATA_SOURCE)
    public DataSource SCHOOL_DATA_SOURCE(
            @Qualifier("schoolProperties") SourceProperties properties) {
        HikariConfig config = new HikariConfig();
        applyProperties(config, properties);
        return new HikariDataSource(config);
    }

    @Bean(name = "schoolJpaVendorAdapter")
    public JpaVendorAdapter schoolJpaVendorAdapter(
            @Qualifier("schoolProperties") SourceProperties properties) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setDatabasePlatform(properties.getDatabasePlatform());
        vendorAdapter.setShowSql(properties.isShowSql());
        vendorAdapter.setGenerateDdl(properties.isGenerateDdl());
        return vendorAdapter;
    }

    @Bean(name = "schoolJpaProperties")
    public Properties schoolJpaProperties() {
        Properties jpaProps = new Properties();
        jpaProps.put("hibernate.jdbc.batch_size", "100");
        jpaProps.put("hibernate.order_inserts", "true");
        jpaProps.put("hibernate.order_updates", "true");
        return jpaProps;
    }

    @Bean(name = SCHOOL_ENTITY_MANAGER_FACTORY)
    public LocalContainerEntityManagerFactoryBean SCHOOL_ENTITY_MANAGER_FACTORY(
            @Qualifier(SCHOOL_DATA_SOURCE) DataSource dataSource,
            @Qualifier("schoolJpaVendorAdapter") JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setJpaVendorAdapter(jpaVendorAdapter);
        em.setPackagesToScan("com.demo.model.school");
        em.setDataSource(dataSource);
        em.setJpaProperties(this.schoolJpaProperties());
        return em;
    }

    @Bean(name = SCHOOL_TRANSACTION_MANAGER)
    public PlatformTransactionManager SCHOOL_TRANSACTION_MANAGER(
            @Qualifier(SCHOOL_ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
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