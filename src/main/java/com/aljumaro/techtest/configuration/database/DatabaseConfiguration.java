package com.aljumaro.techtest.configuration.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Date 10/04/2016
 * @Time 10:13
 * @Author Juanma */
@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(dataSourceProperties.getDriverClassName());
        ds.setUrl(dataSourceProperties.getUrl());
        ds.setUsername(dataSourceProperties.getUsername());
        ds.setPassword(dataSourceProperties.getPassword());
        return ds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(Boolean.TRUE);
        adapter.setGenerateDdl(Boolean.TRUE);
        adapter.setDatabasePlatform(HibernateConstants.DATABASE_PLATFORM);

        return adapter;
    }

    public Properties getJpaProperties(){
        Properties jpaProperties = new Properties();
        jpaProperties.put(
                "hibernate.physical_naming_strategy",
                "com.aljumaro.techtest.configuration.database.CENamingStrategy");

        jpaProperties.put(
                "hibernate.hbm2ddl.auto",
                "update");

        jpaProperties.put(
                "hibernate.format_sql",
                "true");

        return jpaProperties;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter){

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactoryBean.setPackagesToScan(HibernateConstants.PACKAGE_TO_SCAN);
        entityManagerFactoryBean.setJpaProperties(getJpaProperties());
        entityManagerFactoryBean.afterPropertiesSet();
        entityManagerFactoryBean.setMappingResources(HibernateConstants.ITEM_ENTITY_MAPPINGS);
        //entityManagerFactoryBean.setMappingResources(HibernateConstants.ITEM_HIBERNATE_MAPPINGS);
        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
