package curso.springbatch.auditing;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.SkipListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.springbatch.auditing.dao.SkipItemsDao;
import curso.springbatch.auditing.model.SkipItems;
import curso.springbatch.batchErrors.SampleSkipException;

@Service("auditing.skipListener")
public class SampleSkipListener extends BaseElement implements SkipListener<Object, Object>{

	public final static Log log = LogFactory.getLog(SampleSkipListener.class);
	@Autowired
	private SkipItemsDao skipItemsDao;
	
	public void onSkipInProcess(Object item, Throwable t) {
		log.info("onSkipInProcess:" +item.getClass()+" "+t.getClass());
		if(t instanceof SampleSkipException){
			SampleSkipException sampleSkipException=(SampleSkipException)t;
			skipItemsDao.save(createSkipElement("PROCESS", item.toString(), t.getClass().toString(), sampleSkipException));
		}
	}

	public void onSkipInRead(Throwable t) {
		log.info("onSkipInRead:"+ t.getClass());
		if(t instanceof SampleSkipException){
			SampleSkipException sampleSkipException=(SampleSkipException)t;
			skipItemsDao.save(createSkipElement("READ", "", t.getClass().toString(), sampleSkipException));
		}
	}

	public void onSkipInWrite(Object item, Throwable t) {
		log.info("onSkipInWrite:" +item.getClass()+" "+t.getClass());
		if(t instanceof SampleSkipException){
			SampleSkipException sampleSkipException=(SampleSkipException)t;
			skipItemsDao.save(createSkipElement("WRITE", item.toString(), t.getClass().toString(), sampleSkipException));
		}
	}

	private SkipItems createSkipElement(String type, String item, String msg, SampleSkipException sampleSkipException){
		SkipItems skipElement=new SkipItems();
		skipElement.setType(type);
		skipElement.setItem(item);
		skipElement.setMsg(msg);
		skipElement.setJobExecutionId(getJobExecutionId());
		skipElement.setStepExecutionId(getStepExecutionId());
		return skipElement;
	}
	public SkipItemsDao getSkipItemsDao() {
		return skipItemsDao;
	}

	public void setSkipItemsDao(SkipItemsDao skipItemsDao) {
		this.skipItemsDao = skipItemsDao;
	}
}