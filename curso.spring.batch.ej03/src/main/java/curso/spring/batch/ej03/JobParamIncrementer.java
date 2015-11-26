package curso.spring.batch.ej03;

import java.util.Calendar;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

public class JobParamIncrementer implements JobParametersIncrementer {
    public JobParameters getNext(JobParameters parameters) {
        System.out.println("got job parameters: " + parameters);
        /*if (parameters==null || parameters.isEmpty()) {
            return new JobParametersBuilder().addLong("run.id", 1L).toJobParameters();
        }*/
        return new JobParametersBuilder().addLong("run.id", Calendar.getInstance().getTimeInMillis()).toJobParameters();
        /*long id = parameters.getLong("run.id",Calendar.getInstance().getTimeInMillis()) + 1;
        JobParametersBuilder jobParamBuilder  = new JobParametersBuilder().addLong("run.id", id);
        return  jobParamBuilder.toJobParameters();*/

    }
}
