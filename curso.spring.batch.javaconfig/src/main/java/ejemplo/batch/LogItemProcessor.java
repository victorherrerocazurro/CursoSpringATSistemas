package ejemplo.batch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;

public class LogItemProcessor<T> implements ItemProcessor<T,T> {

	private static final Log log = LogFactory.getLog(LogItemProcessor.class);
	
	public T process(T item) throws Exception {
		log.info(Thread.currentThread().getName()+":"+item);
		return item;
	}

}
