package curso.spring.batch.ej03;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class App4 {
 
  public static void main(String[] args) {
	 
	String[] springConfig = { "jobs/job4.xml" };
 
	ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
 
	JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
	Job job = (Job) context.getBean("testJob");
 
	try {
 
		JobParameters param = new JobParametersBuilder().addString("age", "25").toJobParameters();
 
		JobExecution execution = jobLauncher.run(job, param);
		System.out.println("Exit Status : " + execution.getStatus());
		System.out.println("Exit Status : " + execution.getAllFailureExceptions());
 
	} catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("Done");
 
  }
 
}