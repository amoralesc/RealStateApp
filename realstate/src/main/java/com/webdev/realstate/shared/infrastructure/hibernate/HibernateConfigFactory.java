package com.webdev.realstate.shared.infrastructure.hibernate;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfigFactory {

	@Autowired
	private Environment env;

	@Bean("session-factory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(this.dataSource());
		sessionFactoryBean.setHibernateProperties(this.hibernateProperties());

		FileSystemResource resource1 = new FileSystemResource(
				"realstate/src/main/java/com/webdev/realstate/users/user/infrastructure/hibernate/User.hbm.xml"
		);
		FileSystemResource resource2 = new FileSystemResource(
				"realstate/src/main/java/com/webdev/realstate/properties/property/infrastructure/hibernate/Property.hbm.xml"
		);
		FileSystemResource resource3 = new FileSystemResource(
				"realstate/src/main/java/com/webdev/realstate/appointments/appointment/infrastructure/hibernate/Appointment.hbm.xml"
		);
		FileSystemResource resource4 = new FileSystemResource(
				"realstate/src/main/java/com/webdev/realstate/appointments/request/infrastructure/hibernate/Request.hbm.xml"
		);
		FileSystemResource resource5 = new FileSystemResource(
				"realstate/src/main/java/com/webdev/realstate/properties/address/infrastructure/hibernate/Address.hbm.xml"
		);

		sessionFactoryBean.setMappingLocations(
				resource1, resource2, resource3, resource4, resource5
		);

		return sessionFactoryBean;
	}

	@Bean("transactional-manager")
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());

		return transactionManager;
	}

	private Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "none");
		hibernateProperties.put(AvailableSettings.SHOW_SQL, "false");
		hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MariaDBDialect");

		return hibernateProperties;
	}

	private DataSource dataSource() {
		String url = env.getProperty("datasource.url");
		String username = env.getProperty("datasource.username");
		String password = env.getProperty("datasource.password");

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:mariadb://" + url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		return dataSource;
	}
}