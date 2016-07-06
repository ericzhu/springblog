package com.sl.staas.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class RootContextConfiguration {
   
   @Bean
   public DataSource dataSource() {
      return null;
   }
   
   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
      return null;
   }
}
