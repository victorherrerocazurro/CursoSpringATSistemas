package curso.spring.batch.ej03;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class App3 {
  public static void main(String[] args) {
 
	String[] springConfig  = 
	{	
			"config/database.xml", 
			"config/context.xml",
		"jobs/job3.xml" 
	};
 
	ApplicationContext context = 
		new ClassPathXmlApplicationContext(springConfig);
 
	JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
	Job job = (Job) context.getBean("reportJob3");
 
	try {
 
		JobExecution execution = jobLauncher.run(job, new JobParameters());
		System.out.println("Exit Status : " + execution.getStatus());
 
	} catch (Exception e) {
		e.printStackTrace();
	}
 
	System.out.println("Done");
 
  }
}
