package curso.springbatch.executionFlow;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import curso.springbatch.simpleJob.SampleProcessor;
import curso.springbatch.simpleJob.model.Sample;



@Service("executionflow.sampleProcessor")
public class SampleProcessorSkipProcessor extends SampleProcessor implements ItemProcessor<String, Sample>{

	public Sample process(String value){
		Integer id=new Integer(value.substring(5));
		Sample sample=super.process(value);
		//Filter this element
		if(id==45){
			return null;
		}
		//Skip this element
		if(id==95){
			throw new SampleSkipException(); 
		}
		return sample;
	}
}
