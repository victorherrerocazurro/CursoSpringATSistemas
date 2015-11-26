package curso.springbatch.auditing;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Service;

@Service("auditing.stepListener")
public class SampleStepExecutionListener implements StepExecutionListener {

    public void beforeStep(StepExecution stepExecution){
    	Long jobExecutionId =stepExecution.getJobExecutionId();
    	String jobName=stepExecution.getJobExecution().getJobInstance().getJobName();
    	stepExecution.getExecutionContext().put("jobExecutionId", jobExecutionId);
    	stepExecution.getExecutionContext().put("stepExecutionId", stepExecution.getId());
    	stepExecution.getExecutionContext().put("jobName", jobName);
    }

    public ExitStatus afterStep(StepExecution stepExecution){
    	return null;
    }

}