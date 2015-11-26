package ejemplo.batch.configuration;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
//it takes the DataSource and creates a DataSourceTransactionManager working on it, 
//it creates a JobRepository working with the transaction manager and the DataSource,
//and it creates a JobLauncher using the JobRepository. 
//In addition it registers the StepScope for usage on batch components and a JobRegistry 
//to find jobs by name.
@EnableBatchProcessing
public class StandaloneInfrastructureConfiguration implements InfrastructureConfiguration {
	
	static @Bean public PropertySourcesPlaceholderConfigurer myPropertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
        Resource[] resourceLocations = new Resource[] {
                new ClassPathResource("database.properties")
        };
        p.setLocations(resourceLocations);
        return p;
    }
	
	@Value("${jdbc.driverClassName}") private String driverClassName;
	@Value("${jdbc.url}")             private String dbUrl;
	@Value("${jdbc.username}")        private String dbUserName;
	@Value("${jdbc.password}")        private String dbPassword;

	
	@Value("classpath:org/springframework/batch/core/schema-drop-mysql.sql")
	private Resource dropSchemaScript;
	
	@Value("classpath:org/springframework/batch/core/schema-mysql.sql")
	private Resource createSchemaScript;

	@Value("classpath:schema-partner.sql")
	private Resource dataScript;

	@Bean
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
	    DataSourceInitializer initializer = new DataSourceInitializer();
	    initializer.setDataSource(dataSource);
	    initializer.setDatabasePopulator(databasePopulator());
	    return initializer;
	}

	private DatabasePopulator databasePopulator() {
	    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	    populator.addScript(dropSchemaScript);
	    populator.addScript(createSchemaScript);
	    populator.addScript(dataScript);
	    return populator;
	}


	@Override
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}
	
	
	
//	@Bean
//	public DataSource dataSource(){
//		EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
//		return embeddedDatabaseBuilder.addScript("classpath:org/springframework/batch/core/schema-drop-hsqldb.sql")
//				.addScript("classpath:org/springframework/batch/core/schema-hsqldb.sql")
//				.addScript("classpath:schema-partner.sql")
//				.setType(EmbeddedDatabaseType.HSQL)
//				.build();
//	}
	
	

}
