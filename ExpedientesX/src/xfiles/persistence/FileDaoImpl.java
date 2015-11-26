package xfiles.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import xfiles.model.File;

@Repository
public class FileDaoImpl implements FileDao, InitializingBean {
	private Long id = 0L;
	private Map<Long, File> files = new HashMap<Long, File>();

	public File find(Long id) {
		return files.get(id);
	}

	public List<File> list() {
		return new ArrayList<File>(files.values());
	}

	public void save(File file) {
		if (file.getId() == File.NEW_FILE) {
			file.setId(id++);
		}
		files.put(file.getId(), file);
	}

	public void delete(File file) {
		if(file.getId()!=null){
			files.remove(file.getId());
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		save(new File("The Bat Boy","In 2004, he was five feet tall and his weight was unknown. Change his wings every three years, and regenerates a new pair.", "images/batboy.jpg", "Mulder", true));
		save(new File("Big Foot Sighting","Bigfoot is described in reports as a large hairy ape-like creature, ranging between 6-10 feet tall (3.2 m), weighing more than 500 pounds (230 kg), and covered in dark brown or dark reddish hair.", "images/bigfoot.jpg", "Scully", false));
		save(new File("Elvis is alive","It is believed that the American rock singer had not really died in 1977, and lives incognito traveling the world. Where was seen Elvis? In Montana, Cambridge, Southampton, ...", "images/elvis.jpg", "Mulder", false));
		save(new File("Abductions by Alien","On November 27, 1973, Samantha Mulder mysteriously disappeared. She was abducted while was playing with her brother, their parents had gone out from home that night.", "images/alien.jpg", "Scully", true));
	}
}
