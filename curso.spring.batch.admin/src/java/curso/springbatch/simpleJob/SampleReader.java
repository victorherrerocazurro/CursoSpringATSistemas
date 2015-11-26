package curso.springbatch.simpleJob;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Service;

@Service("simpleJob.sampleReader")
public class SampleReader implements ItemReader<String> {

	static String[] array = new String[100];
	static {
		for (int i = 0; i < 100; i++) {
			array[i] = new String("Name:"+i);
		}
	}
	
	static int readIndex = -1;
	
	public String read()  {
		readIndex++;
		if (readIndex>=array.length) {
			readIndex=-1;
			return null;
		}
		return array[readIndex];
	}

}

