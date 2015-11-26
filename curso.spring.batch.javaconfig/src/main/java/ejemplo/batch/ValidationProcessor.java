package ejemplo.batch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;

import ejemplo.domain.Partner;
import ejemplo.domain.UnknownGenderException;


public class ValidationProcessor implements ItemProcessor<Partner,Partner> {

	private static final Log log = LogFactory.getLog(ValidationProcessor.class);
	
	public Partner process(Partner partner) throws Exception {
		log.info(partner);
		if (!("m".equals(partner.getGender()) || ("w".equals(partner.getGender())))){
			throw new UnknownGenderException("Gender "+partner.getGender()+" is unknown!");
		}
		return partner;
	}

}
