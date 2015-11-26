package curso.spring.batch.ej01;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class ImprimirTasklet implements Tasklet {
	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public RepeatStatus execute(StepContribution contribution,	ChunkContext chunkContext) throws Exception {
		System.out.print(mensaje);
		return RepeatStatus.FINISHED;
	}
}