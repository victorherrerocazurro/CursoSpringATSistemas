package xfiles.persistence;

import java.util.List;

import xfiles.model.File;

public interface FileDao {
	File find(Long id);
	List<File> list();
	void save(File file);
	void delete(File file);
}
