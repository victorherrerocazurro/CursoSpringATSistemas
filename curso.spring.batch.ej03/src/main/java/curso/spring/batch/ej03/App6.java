package curso.spring.batch.ej03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App6 {
 
	  public static void main(String[] args) {
	 
		String springConfig = "jobs/job6.xml";
	 
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
	 
	  }
	}
