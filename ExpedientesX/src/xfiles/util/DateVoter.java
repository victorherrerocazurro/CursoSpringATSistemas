package xfiles.util;

import java.util.Calendar;
import java.util.Collection;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

public class DateVoter implements AccessDecisionVoter<Object> {

	@Override
	public boolean supports(ConfigAttribute configAttribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) {
		int vote=AccessDecisionVoter.ACCESS_DENIED;
		int actualMinute = Calendar.getInstance().get(Calendar.MINUTE);
		
		if (actualMinute % 2 == 0){
			vote=AccessDecisionVoter.ACCESS_GRANTED;
		}
		System.out.println("Voting: "+vote +" for minute "+actualMinute);
		return vote;
	}

}
