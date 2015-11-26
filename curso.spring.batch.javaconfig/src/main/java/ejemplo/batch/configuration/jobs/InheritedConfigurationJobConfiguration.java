package ejemplo.batch.configuration.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.repeat.CompletionPolicy;
import org.springframework.batch.repeat.policy.SimpleCompletionPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ejemplo.batch.ValidationProcessor;
import ejemplo.batch.configuration.parent.CommonJobConfigurationForInheritance;
import ejemplo.batch.listener.LogSkipListener;
import ejemplo.domain.Partner;
import ejemplo.domain.UnknownGenderException;

@Configuration
public class InheritedConfigurationJobConfiguration extends CommonJobConfigurationForInheritance{
	
	@Bean
	public Job inheritedConfigurationJob(){
		return customJobBuilders().get("inheritedConfigurationJob")
				.start(step())
				.build();
	}
	
	@Bean
	public Step step(){
		return customStepBuilders().get("step")
				.faultTolerant()
				.skipLimit(10)
				.skip(UnknownGenderException.class)
				.listener(logSkipListener())
				.build();
	}

	@Override
	@Bean
	public ItemProcessor<Partner, Partner> processor() {
		return new ValidationProcessor();
	}
	
	@Override
	@Bean
	public CompletionPolicy completionPolicy() {
		return new SimpleCompletionPolicy(3);
	}

	@Bean
	public LogSkipListener logSkipListener(){
		return new LogSkipListener();
	}
	
}
