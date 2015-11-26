package curso.spring.batch.ej01;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.job.SimpleJob;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
//		"classpath:/curso/spring/batch/ej01/spring-batch-config.xml"
		"classpath:/curso/spring/batch/ej01/spring-batch-config-namespace.xml"
		})
public class ImprimirHolaMundoTest {
 
    @Autowired
    private SimpleJobLauncher launcher;
 
    @Autowired
    @Qualifier("trabajoBatch")
    //private SimpleJob job;
    private Job job;
 
    @Test
    public void iniciarJob() throws Exception {
        JobParametersBuilder builder = new JobParametersBuilder();
        builder.addDate("Ejecucion", new Date());
        builder.addString("jobName", "Imprimir hola mundo por consola");
        JobParameters parameters = builder.toJobParameters();
 
        launcher.run(job, parameters);
    }
}