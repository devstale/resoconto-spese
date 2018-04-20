package configuration;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(
		value = {"classpath:database.properties"}, encoding = "UTF-8", ignoreResourceNotFound = false
		)
@ComponentScan("it.devstale.resoconto.spese.dao")
@EnableJpaRepositories(basePackages={"it.devstale.resoconto.spese.repository"})
public class DataConfiguration {

	private static final String MODELS_PACKAGE = "it.devstale.resoconto.spese.model";
	
	@Autowired
	private Environment environment;

	/**
	 * Bean per la session factory di Hibernate
	 */
//	@Bean
//	public SessionFactory sessionFactory() {
//		
//		LocalSessionFactoryBuilder builder = 
//				new LocalSessionFactoryBuilder(dataSource());
//		builder
//			.scanPackages(MODELS_PACKAGE)
//			.addProperties(getHibernateProperties());
//
//		return builder.buildSessionFactory();
//		
//	}


	@Bean(name = "dataSource")
	public BasicDataSource dataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("db.driverClassName"));
		dataSource.setUrl(environment.getProperty("db.jdbcUrl"));
		dataSource.setUsername(environment.getProperty("db.username"));
		dataSource.setPassword(environment.getProperty("db.password"));
		dataSource.setInitialSize(Integer.valueOf(environment.getProperty("db.initialSize")));
		dataSource.setMaxActive(Integer.valueOf(environment.getProperty("db.maxActive")));
		dataSource.setValidationQuery(environment.getProperty("db.validationQuery"));
		
		return dataSource;
		
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan(MODELS_PACKAGE);
		entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
		
		return entityManagerFactoryBean;

	}

	
	@Bean
	public JpaTransactionManager transactionManager() {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;

	}


	/**
	 * Bean per la creazione del Transaction manager
	 */
//	@Bean
//	public HibernateTransactionManager transactionManager() {
//		return new HibernateTransactionManager(sessionFactory());
//	}
	
	/**
	 * PersistenceExceptionTranslationPostProcessor e' un bean di spring che aggiunge un
	 * adviser ad ogni bean annotato con @Repository di modo tale che ogni eccezione
	 * specifica di una data piattaforma sia cattura e ri-lanciata come una unchecked data-access
	 * exception di Spring.
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	/**
	 * Hibernate properties
	 */
	private Properties getHibernateProperties() {
		
		Properties hibernateProperties = new Properties();
		
		hibernateProperties.put("hibernate.dialect", environment.getProperty("db.dialect"));
		hibernateProperties.put("hibernate.show_sql", environment.getProperty("db.show.sql"));
		hibernateProperties.put("hibernate.generate_statistics", false);
		hibernateProperties.put("hibernate.format_sql", environment.getProperty("db.format.sql"));
		hibernateProperties.put("hibernate.hbm2ddl.auto", environment.getProperty("db.ddl.instr"));
		//hibernateProperties.put("hibernate.hbm2ddl.import_files", environment.getProperty("db.ddl.import_file"));
//		hibernateProperties.put("hibernate.c3p0.min_size", 5);
//		hibernateProperties.put("hibernate.c3p0.max_size", 20);
//		hibernateProperties.put("hibernate.c3p0.timeout", 300);
//		hibernateProperties.put("hibernate.c3p0.max_statements", 50);
//		hibernateProperties.put("hibernate.c3p0.idle_test_period", 3000);
		
		return hibernateProperties;
		
	}
	
	
}

