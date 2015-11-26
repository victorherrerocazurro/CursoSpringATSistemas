package pruebas.batch;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ejemplo.batch.configuration.StandaloneInfrastructureConfiguration;
import ejemplo.batch.configuration.jobs.FlatfileToDbWithParametersAutowiringJobConfiguration;

/**
 * @author Tobias Flohre
 */
@ContextConfiguration(classes={StandaloneInfrastructureConfiguration.class, FlatfileToDbWithParametersAutowiringJobConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FlatfileToDbWithParametersAutowiringJobTests {
	
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;
	
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	@Before
	public void setup(){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Test
	public void testLaunchJob() throws Exception {
		JobParameters jobParameters = new JobParametersBuilder().addString("pathToFile", "partner-import.csv").toJobParameters();
		jobLauncher.run(job, jobParameters);
		assertThat(jdbcTemplate.queryForObject("select count(*) from PARTNER",Integer.class),is(6));
	}
	
}
