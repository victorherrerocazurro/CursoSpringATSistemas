package curso.spring.batch.ej03.listeners;

import org.springframework.batch.core.ItemReadListener;

import curso.spring.batch.ej03.modelo.Domain;

/*
In Spring batch, there are six “listeners” to intercept the step execution:

StepExecutionListener
ItemReadListener
ItemProcessListener
ItemWriteListener
ChunkListener
SkipListener
*/

public class CustomItemReaderListener implements ItemReadListener<Domain> {

	@Override
	public void beforeRead() {
		System.out.println("ItemReadListener - beforeRead");
	}

	@Override
	public void afterRead(Domain item) {
		System.out.println("ItemReadListener - afterRead");
	}

	@Override
	public void onReadError(Exception ex) {
		System.out.println("ItemReadListener - onReadError");
	}

}
