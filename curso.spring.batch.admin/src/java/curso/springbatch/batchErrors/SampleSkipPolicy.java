package curso.springbatch.batchErrors;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.stereotype.Service;

@Service("batchErrors.skipPolicy")
public class SampleSkipPolicy implements SkipPolicy{

	private static final int MAX_SKIPS = 5;

	public boolean shouldSkip(Throwable t, int skipCount) throws SkipLimitExceededException {
		System.out.println(" shouldSkip skipCount="+skipCount);
		return SampleSkipException.class.isAssignableFrom(t.getClass());
			//	&& skipCount<MAX_SKIPS;
	}

}

