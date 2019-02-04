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
@EnableJpaRepositories(entityManagerFactoryRef="entityManagerFactory", 
basePackages= "com.springcerticom.schedluerIntranet.intranet.repository",
transactionManagerRef="transactionManager")
public class IntranetDBCconfig {
	
	@Value("${spring.intranet.datasource.jdbc-url}")
	private String url;
	@Value("${spring.intranet.datasource.driver-class-name}")
	private String drive;
	@Value("${spring.intranet.datasource.username}")
	private String username;
	@Value("${spring.intranet.datasource.password}")
	private String password;
	
	
	@Bean(name="datasourceIntranet")
	@ConfigurationProperties(prefix = "spring.intranet.datasource")
	public DataSource dataSourceIntranet() {
		return DataSourceBuilder.create().build();
		/*HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(drive);
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setUsername(username);
		hikariConfig.setPassword(password);
		
		return new HikariDataSource(hikariConfig);*/
		//return DataSourceBuilder.create().build();
	}	
	
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean 
		entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("datasourceIntranet") DataSource dataSource) {
		/*HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setDataSource(dataSourceIntranet());
		factoryBean.setPackagesToScan("com.springcerticom.schedluerIntranet.intranet.model");
		return factoryBean;*/
		return builder.dataSource(dataSource)
				.packages("com.springcerticom.schedluerIntranet.intranet.model")				
				.persistenceUnit("intranet")				
				.build();
		
	}	
	
	private Map<String, Object> jpaproperties() {
		// TODO Auto-generated method stub
		Map<String,Object> props = new HashMap<>();
		props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLSDialect");
		
		return props;
	}

	@Bean(name="transactionManager")
	public PlatformTransactionManager 
		transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory barEntityManagerFactory) {
			return new JpaTransactionManager(barEntityManagerFactory);
			//return new JpaTransactionManager(entityManagerFactory);
		}
	}

