package curso.spring.batch.ej03;


import org.springframework.batch.item.ItemProcessor;

import curso.spring.batch.ej03.modelo.Report3;

 
//run before writing
public class FilterReportProcessor implements ItemProcessor<Report3, Report3> {
 
	@Override
	public Report3 process(Report3 item) throws Exception {
 
		//filter object which age = 30
		if(item.getAge()==30){
			return null; // null = ignore this object
		}
		return item;
	}
 
}