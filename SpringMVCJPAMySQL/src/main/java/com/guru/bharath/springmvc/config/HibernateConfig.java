package com.guru.bharath.springmvc.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(value= {"com.guru.bharath.springmvc"})
@PropertySource("classpath:datasource.properties")
public class HibernateConfig {
	
	@Autowired
	private Environment enviroment;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setJpaProperties(jpaProperties());
		em.setPackagesToScan(new String[] {"com.guru.bharath.springmvc.model"});
		em.setJpaVendorAdapter(jpaVendorAdapter());
		em.setPersistenceUnitName("springMvc");
		return em;
	}
	
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(enviroment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(enviroment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(enviroment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(enviroment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}
	
	
	public Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", enviroment.getRequiredProperty("hibernate.dialect"));
        // properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql", enviroment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", enviroment.getRequiredProperty("hibernate.format_sql"));
        return properties;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		return adapter;
	}
	
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

}
