package com.springcerticom.schedluerIntranet.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "qualityEntityManagerFactory", basePackages = "com.springcerticom.schedluerIntranet.quality.repository", transactionManagerRef = "qualityTransactionManager")
public class QualityDBCconfig {

	@Value("${spring.quality.datasource.url}")
	private String url;
	@Value("${spring.quality.datasource.databaseName}")
	private String databaseName;
	@Value("${spring.quality.datasource.serverName}")
	private String serverName;
	@Value("${spring.quality.datasource.numbrePort}")
	private String numbrePort;	
	@Value("${spring.quality.datasource.driver}")
	private String drive;
	@Value("${spring.quality.datasource.username}")
	private String username;
	@Value("${spring.quality.datasource.password}")
	private String password;

	@Primary
	@Bean(name = "qualityDatasource")
	public DataSource qualityDataSource() throws AbstractMethodError {
		System.out.println("QUALITY DATASOURCE ");
		try {
			HikariConfig hikariConfig = new HikariConfig();			
			hikariConfig.setMaximumPoolSize(32);
			hikariConfig.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");						
			hikariConfig.setJdbcUrl(url);
			hikariConfig.setUsername(username);
			hikariConfig.setPassword(password);
			hikariConfig.setAutoCommit(true);
			hikariConfig.setConnectionTestQuery("SELECT GETDATE()");
			System.out.println("SUCCES QUALITY DATASOURCE ");			
			return new HikariDataSource(hikariConfig);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("EXCEPCION DE QUALITY");
			System.out.println(e.getStackTrace());
		}
		return null;
	}
	private String getConnectionUrl() {
		// TODO Auto-generated method stub
		return url+";user="+username+";password="+password+";selectMethod=cursor;";
	}

	@Primary
	@Bean(name = "qualityEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean qualityEntityManagerFactory() {
		System.out.println("INICIO FACTORY");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setDataSource(qualityDataSource());
		factoryBean.setPackagesToScan("com.springcerticom.schedluerIntranet.quality.model");
		System.out.println("FIN FACTORY");
		return factoryBean;

	}

	@Primary
	@Bean(name = "qualityTransactionManager")
	public PlatformTransactionManager qualityTransactionManager() {
		System.out.println("INICIO TRANSACTION");
		return new JpaTransactionManager(qualityEntityManagerFactory().getObject());
	}
}
