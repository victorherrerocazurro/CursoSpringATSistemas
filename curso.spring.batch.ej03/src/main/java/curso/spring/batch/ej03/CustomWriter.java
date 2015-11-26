package curso.spring.batch.ej03;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import curso.spring.batch.ej03.modelo.Report6;

public class CustomWriter implements ItemWriter<Report6> {

	@Override
	public void write(List<? extends Report6> items) throws Exception {

		System.out.println("writer..." + items.size());		
		for(Report6 item : items){
			System.out.println(item);
		}

	}

}