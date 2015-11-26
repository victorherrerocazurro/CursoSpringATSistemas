package xfiles.business;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import xfiles.model.File;

public interface FileManagerService {
	@PreAuthorize("hasRole('ROLE_ASSISTANT_DIRECTOR')")
	void classify(File file);

	@PreAuthorize("hasRole('ROLE_ASSISTANT_DIRECTOR') or #file.investigator == authentication.name")
	void declassify(File file);
	
	@PostFilter("not filterObject.report.contains(principal.username)")
	List<File> showAll();

	@PreAuthorize("hasAnyRole('ROLE_SPECIAL_AGENT','ROLE_ASSISTANT_DIRECTOR')")
	@PostAuthorize("hasRole('ROLE_ASSISTANT_DIRECTOR') or returnObject.investigator == authentication.name")
	File show(Long id);
}
