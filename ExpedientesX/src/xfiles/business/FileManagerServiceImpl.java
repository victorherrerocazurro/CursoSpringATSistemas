package xfiles.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xfiles.model.File;
import xfiles.persistence.FileDao;

@Service
public class FileManagerServiceImpl implements FileManagerService {
	
	@Autowired
	private FileDao fileDao;

	private void update(File file) {
		fileDao.save(file);
		System.out.println("Updating File: " + file);
	}

	public void classify(File file) {
		if (!file.isClassified()) {
			file.setClassified(true);
			update(file);
			System.out.println("Classified File: " + file);
		}
	}

	public void declassify(File file) {
		if (file.isClassified()) {
			file.setClassified(false);
			update(file);
			System.out.println("Declassified File: " + file);
		}
	}

	public List<File> showAll() {
		List<File>files=fileDao.list();
		System.out.println("Show "+files.size()+" files: " + files.toString());
		return files;
	}

	public File show(Long id) {
		File file=fileDao.find(id);
		System.out.println("Show file: " + file.toString());
		return file;
	}

}
