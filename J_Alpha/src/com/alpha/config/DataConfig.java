package com.alpha.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.alpha.repository")
@PropertySource("classpath:database.properties")
public class DataConfig {

	private final String PROPERTY_DRIVER = "driver";
	private final String PROPERTY_URL = "url";
	private final String PROPERTY_USERNAME = "username";
	private final String PROPERTY_PASSWORD = "password";
	private final String PROPERTY_SHOW_SQL = "hibernate.showsql";
	private final String PROPERTY_DIALECT = "hibernate.dialect";
	private final String HBM2DDL = "hibernate.hbm2ddl.auto";
	private final String GENERATEDDL = "generateDdl";


	@Autowired
	org.springframework.core.env.Environment environment;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		System.out.println("entitManagerFactory");
		 HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		 vendorAdapter.setDatabase(Database.MYSQL);
		 vendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setDataSource(dataSource());
		lcemfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		lcemfb.setPackagesToScan("com.alpha.dba");
		Properties jpaProperties = hibernateProperties();
		lcemfb.setJpaProperties(jpaProperties);
		lcemfb.setJpaVendorAdapter(vendorAdapter);
		//lcemfb.setPersistenceUnitName("name");
		return lcemfb;
	}

	private DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty(PROPERTY_URL));
		dataSource.setUsername(environment.getProperty(PROPERTY_USERNAME));
		dataSource.setPassword(environment.getProperty(PROPERTY_PASSWORD));
		dataSource.setDriverClassName(environment.getProperty(PROPERTY_DRIVER));
		return dataSource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty(PROPERTY_DIALECT, environment.getProperty(PROPERTY_DIALECT));
		properties.setProperty(PROPERTY_SHOW_SQL, environment.getProperty(PROPERTY_SHOW_SQL));
	//	properties.setProperty(GENERATEDDL, environment.getProperty(GENERATEDDL));
			properties.setProperty("hibernate.archive.autodetection", "class,hbm");
		return properties;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return jpaTransactionManager;
	}

}
