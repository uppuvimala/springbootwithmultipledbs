package com.multipledbs.Employee;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "db1EntityManagerFactory",
transactionManagerRef = "db1TransactionManager",
basePackages="com.multipledbs.Employee")
public class DbOneConfig {

    //data source
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "db1.datasource")
    //all db1 prop from .prop will b loaded

    public DataSource db1DataSource(){
        return DataSourceBuilder.create().build();
        //datasourcebuilder will load all the props --> returns dbconnection
    }
    //Entity Manager
    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean db1EntityManagerFactory(EntityManagerFactoryBuilder emfb){
       //dialect properties
        HashMap<String,Object>properties=new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto","create");
        properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");

        return emfb.dataSource(db1DataSource())
                .packages("com.multipledbs.Employee")
                .properties(properties)
                .build();
    }
    //Tranc Manager
    @Primary
    @Bean
    public PlatformTransactionManager db1TransactionManager(@Qualifier("db1EntityManagerFactory") EntityManagerFactory entityManagerFactory){
        //readobj from container
        return new JpaTransactionManager(entityManagerFactory);
    }
}
