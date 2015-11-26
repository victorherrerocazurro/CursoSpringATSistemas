package curso.springbatch.batchErrors;

import org.springframework.stereotype.Service;

import curso.springbatch.simpleJob.SampleProcessor;
import curso.springbatch.simpleJob.model.Sample;

@Service("batchErrors.sampleSkipProcessor")
public class SampleProcessorSkipProcessor extends SampleProcessor {

   public Sample process(String value){
       Integer id=new Integer(value.substring(5));
       Sample sample=super.process(value);
       //Filter this element
       if(id==45){
           return null;
       }
       
     
       //Skip this element
       if(id==95){
       //if(id>95){
           throw new SampleSkipException();
       }
       
//       if(id==50){
//    	   System.out.println("error trying to connect...");
//    	   throw new SampleRetryableException();
//       }
       
       return sample;
   }
}
