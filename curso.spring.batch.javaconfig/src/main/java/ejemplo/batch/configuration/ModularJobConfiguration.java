package ejemplo.batch.configuration;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ejemplo.batch.configuration.jobs.FlatfileToDbJobConfiguration;
import ejemplo.batch.configuration.jobs.FlatfileToDbWithParametersJobConfiguration;

@Configuration
@EnableBatchProcessing(modular=true)
public class ModularJobConfiguration {
	
	@Bean
	public ApplicationContextFactory someJobs() {
		return new GenericApplicationContextFactory(FlatfileToDbJobConfiguration.class);
	}

	@Bean
	public ApplicationContextFactory someMoreJobs() {
		return new GenericApplicationContextFactory(FlatfileToDbWithParametersJobConfiguration.class);
	}

}
