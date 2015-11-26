package curso.spring.batch.ej03.listeners;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

import curso.spring.batch.ej03.modelo.Domain;

public class CustomItemWriterListener implements ItemWriteListener<Domain> {

	@Override
	public void beforeWrite(List<? extends Domain> items) {
		System.out.println("ItemWriteListener - beforeWrite");
	}

	@Override
	public void afterWrite(List<? extends Domain> items) {
		System.out.println("ItemWriteListener - afterWrite");
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Domain> items) {
		System.out.println("ItemWriteListener - onWriteError");
	}

}
