package curso.spring.batch.ej03;

import org.springframework.batch.item.ItemProcessor;

import curso.spring.batch.ej03.modelo.Report;

public class CustomItemProcessor implements ItemProcessor<Report, Report> {

	@Override
	public Report process(Report item) throws Exception {

		System.out.println("Processing..." + item);
		return item;
	}

}