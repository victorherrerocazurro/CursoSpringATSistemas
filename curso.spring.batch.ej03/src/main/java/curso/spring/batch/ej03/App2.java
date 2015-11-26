package curso.spring.batch.ej03;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
	public static void main(String[] args) {

		String[] springConfig  = 
			{	"config/database.xml", 
				"config/context.xml",
				"jobs/job2.xml" 
			};
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(springConfig);
		
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		//JobOperator  jobOperator = (JobOperator) context.getBean("jobOperator");
		Job job = (Job) context.getBean("reportJob");

		try {

			JobExecution execution = jobLauncher.run(job, new JobParameters());
		//	Long instance = jobOperator.startNextInstance("reportJob");
			System.out.println("Exit Status : " + execution.getStatus());
		//	System.out.println("Exit Status : " + instance);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}
}
