package ejemplo.batch.configuration.parent;

import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ejemplo.batch.listener.ProtocolListener;

@Configuration
public class CommonJobConfigurationForDelegation {
	
	@Autowired
	private JobRepository jobRepository;
	
	@Bean
	public CustomJobBuilderFactory customJobBuilders(){
		return new CustomJobBuilderFactory(jobRepository, protocolListener());
	}
	
	@Bean
	public ProtocolListener protocolListener(){
		return new ProtocolListener();
	}
	

}
