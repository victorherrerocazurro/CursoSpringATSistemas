package curso.springbatch.simpleJob.dao;

import org.springframework.stereotype.Repository;

import curso.springbatch.simpleJob.model.Sample;

/*
CREATE TABLE sample (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    data VARCHAR(100),
    type INT(100)
);


);
 */
@Repository("simpleJob.sampleDao")
public class SampleDaoImpl extends BaseDao implements SampleDao{

	private String insertStatement="INSERT INTO sample (data,type) VALUES (?, ?) ";
	
	public void save(Sample sample){
		jdbcTemplate.update(insertStatement, new Object[]{sample.getData(), sample.getType()});
	}
	
}

