package curso.springbatch.simpleJob;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import curso.springbatch.simpleJob.model.Sample;

@Service("simpleJob.sampleProcessor")
public class SampleProcessor implements ItemProcessor<String, Sample>{

	public Sample process(String value){
		Sample exemple=new Sample();
		exemple.setData(value);
		exemple.setType(1);
		return exemple;
	}
}
