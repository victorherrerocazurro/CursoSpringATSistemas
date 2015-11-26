package ejemplo.batch.configuration.multithreadedstep;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.sql.DataSource;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
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

	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		//taskExecutor.setCorePoolSize(4);
		//taskExecutor.setQueueCapacity(0);
		taskExecutor.setMaxPoolSize(4);
		taskExecutor.afterPropertiesSet();
		return taskExecutor;
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory("tcp://localhost:61616");
	}

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("queueName");
	}
	
	@Bean
	public BrokerService broker() throws Exception{
		BrokerService broker = new BrokerService();
		// configure the broker
		broker.addConnector("tcp://localhost:61616");
		broker.start();
		return broker;
	}
	
	@Bean
	public JmsTemplate jmsTemplate(){
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
		jmsTemplate.setDefaultDestination(queue());
		jmsTemplate.setReceiveTimeout(500);
		return jmsTemplate;
	}

}
