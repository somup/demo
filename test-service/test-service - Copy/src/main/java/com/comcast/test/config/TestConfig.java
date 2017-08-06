package com.comcast.test.config;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Component
@EnableTransactionManagement
@EnableJpaRepositories
@ComponentScan(basePackages = {"com.comcast.test.adcampaign.domains"})
public class TestConfig {
/*
    @Value("${service.name:generated-service}")
    private String serviceName;

    public String getServiceName() {
        return serviceName;
    }
    */
    @Bean
    public DataSource dataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(env.getProperty("db.driver"));
      dataSource.setUrl(env.getProperty("db.url"));
      dataSource.setUsername(env.getProperty("db.username"));
      dataSource.setPassword(env.getProperty("db.password"));
      return dataSource;
    }

    /**
     * Declare the JPA entity manager factory.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      LocalContainerEntityManagerFactoryBean entityManagerFactory =
          new LocalContainerEntityManagerFactoryBean();
      
      entityManagerFactory.setDataSource(dataSource);
      
      // Classpath scanning of @Component, @Service, etc annotated class
      entityManagerFactory.setPackagesToScan(
          env.getProperty("entitymanager.packagesToScan"));
      entityManagerFactory.setBeanName("com.comcast.test.adcampaign.domains.Partner");
      entityManagerFactory.setBeanName("com.comcast.test.adcampaign.domains.AdCamp");
      
      // Vendor adapter
      HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
      
      // Hibernate properties
      Properties additionalProperties = new Properties();
      additionalProperties.put(
          "hibernate.dialect", 
          env.getProperty("hibernate.dialect"));
      additionalProperties.put(
          "hibernate.show_sql", 
          env.getProperty("hibernate.show_sql"));
      additionalProperties.put(
          "hibernate.hbm2ddl.auto", 
          env.getProperty("hibernate.hbm2ddl.auto"));
      entityManagerFactory.setJpaProperties(additionalProperties);
      

      StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
        if (true) {
            standardServiceRegistryBuilder.applySetting("hibernate.hbm2ddl.auto", "verify");
        }
      
      return entityManagerFactory;
    }

    @Bean
    public Set<EntityManager> entityManagers(
            final List<LocalContainerEntityManagerFactoryBean> localContainerEntityManagerFactoryBeanList) {
        final Set<EntityManager> entityManagerSet = new HashSet<EntityManager>();
        for (final LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean : localContainerEntityManagerFactoryBeanList) {
            entityManagerSet.add(localContainerEntityManagerFactoryBean.getObject().createEntityManager());
        }
        return entityManagerSet;
    }
    
    /**
     * Declare the transaction manager.
     */
    @Bean
    public JpaTransactionManager transactionManager() {
      JpaTransactionManager transactionManager = 
          new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(
          entityManagerFactory.getObject());
      return transactionManager;
    }
    
    /**
     * PersistenceExceptionTranslationPostProcessor is a bean post processor
     * which adds an advisor to any bean annotated with Repository so that any
     * platform-specific exceptions are caught and then rethrown as one
     * Spring's unchecked data access exceptions (i.e. a subclass of 
     * DataAccessException).
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
      return new PersistenceExceptionTranslationPostProcessor();
    }

    // Private fields
    
    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;
    
    
    
}
