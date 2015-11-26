package curso.springbatch.simpleJob;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.springbatch.simpleJob.dao.SampleDao;
import curso.springbatch.simpleJob.model.Sample;

@Service("simpleJob.sampleWriter")
public class SampleWriter implements ItemWriter<Sample> {

	StringBuilder sb = new StringBuilder();
	@Autowired
	private SampleDao sampleDao;
	
	public void write(List<? extends Sample> items) throws Exception {
		for(Sample exemple: items){
			Integer id=new Integer(exemple.getData().substring(5));
			sampleDao.save(exemple);
		}
	}
	
	public SampleDao getSampleDao() {
		return sampleDao;
	}

	public void setSampleDao(SampleDao sampleDao) {
		this.sampleDao = sampleDao;
	}
}

