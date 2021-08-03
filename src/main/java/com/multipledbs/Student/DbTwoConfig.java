package com.multipledbs.Student;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableJpaRepositories(entityManagerFactoryRef = "db2EntityManagerFactory",
        transactionManagerRef = "db2TransactionManager",
        basePackages="com.multipledbs.Student")
public class DbTwoConfig {

    //data source
    @Bean
    @ConfigurationProperties(prefix = "db2.datasource")
    //all db1 prop from .prop will b loaded

    public DataSource db2DataSource(){
        return DataSourceBuilder.create().build();
        //datasourcebuilder will load all the props --> returns dbconnection
    }
    //Entity Manager
    @Bean
    public LocalContainerEntityManagerFactoryBean db2EntityManagerFactory(EntityManagerFactoryBuilder emfb){
        //dialect properties
        HashMap<String,Object> properties=new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto","create");
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");

        return emfb.dataSource(db2DataSource())
                .packages("com.multipledbs.Student")
                .properties(properties)
                .build();
    }
    //Tranc Manager
    @Bean
    public PlatformTransactionManager db2TransactionManager(@Qualifier("db2EntityManagerFactory") EntityManagerFactory entityManagerFactory){
        //readobj from container
        return new JpaTransactionManager(entityManagerFactory);
    }
}


