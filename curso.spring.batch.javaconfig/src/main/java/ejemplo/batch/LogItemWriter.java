package ejemplo.batch;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;

public class LogItemWriter<T> implements ItemWriter<T> {

	private static final Log log = LogFactory.getLog(LogItemWriter.class);
	
	public void write(List<? extends T> data) throws Exception {
		log.info(data);
	}

}
