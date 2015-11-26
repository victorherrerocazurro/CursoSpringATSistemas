package curso.spring.batch.ej03;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class App7 {
 
  public static void main(String[] args) {
	 
	String[] springConfig = { "jobs/job7.xml" };
 
	ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
 
	JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
	Job job = (Job) context.getBean("partitionJob");
 
	try {
		 
		JobParametersBuilder builder = new JobParametersBuilder();
		builder.addDate("Ejecucion", new Date());
		JobParameters parameters = builder.toJobParameters();
		JobExecution execution = jobLauncher.run(job, parameters);
		System.out.println("Exit Status : " + execution.getStatus());
 
	} catch (Exception e) {
		e.printStackTrace();
	}

	System.out.println("Done");
 
  }
 
}