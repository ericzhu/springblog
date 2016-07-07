package com.sl.staas.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
@EnableTransactionManagement(mode = AdviceMode.PROXY, proxyTargetClass = false)
@ComponentScan(basePackages = "com.sl.staas", excludeFilters = @ComponentScan.Filter({ Controller.class, ControllerAdvice.class }) )
public class RootContextConfiguration implements TransactionManagementConfigurer {

   private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
   private static final String DB_URL            = "jdbc:mysql://localhost:3306/doc_center";
   private static final String DB_USER           = "root";
   // private static final String DB_PASSWORD = "silanis1";
   private static final String DB_PASSWORD       = "root";
   private static final int    CONN_POOL_SIZE    = 5;

   @Bean(destroyMethod = "close")
   public DataSource dataSource() {
      BasicDataSource basicDataSource = new BasicDataSource();
      basicDataSource.setDriverClassName(DRIVER_CLASS_NAME);
      basicDataSource.setUrl(DB_URL);
      basicDataSource.setUsername(DB_USER);
      basicDataSource.setPassword(DB_PASSWORD);
      basicDataSource.setInitialSize(CONN_POOL_SIZE);
      return basicDataSource;
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

      Map<String, Object> properties = new HashMap<>();
      properties.put("javax.persistence.schema-generation.database.action", "none");

      factory.setJpaVendorAdapter(jpaVendorAdapter());
      factory.setDataSource(this.dataSource());
      factory.setPackagesToScan("com.sl.staas.domain");
      factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
      factory.setValidationMode(ValidationMode.NONE);
      factory.setJpaPropertyMap(properties);
      return factory;
   }

   @Bean
   public JpaVendorAdapter jpaVendorAdapter() {
      HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
      adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
      adapter.setGenerateDdl(true);
      return adapter;
   }

   @Bean
   public PlatformTransactionManager jpaTransactionManager() {
      return new JpaTransactionManager(this.entityManagerFactoryBean().getObject());
   }

   @Override
   public PlatformTransactionManager annotationDrivenTransactionManager() {
      return this.jpaTransactionManager();
   }
}
