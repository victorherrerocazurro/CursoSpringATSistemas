package xfiles.model;

public class File {
	public static final long NEW_FILE = -1L;
	private Long id = NEW_FILE;
	private String title;
	private String report;
	private String image;
	private String investigator;
	private boolean classified;

	public File() {
	}

	public File(String title, String report, String image,
			String investigator, boolean classified) {
		this.title = title;
		this.report = report;
		this.image = image;
		this.investigator = investigator;
		this.classified = classified;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getInvestigator() {
		return investigator;
	}

	public void setInvestigator(String investigator) {
		this.investigator = investigator;
	}

	public boolean isClassified() {
		return classified;
	}

	public void setClassified(boolean classified) {
		this.classified = classified;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", title=" + title + ", report=" + report
				+ ", image=" + image + ", investigator=" + investigator
				+ ", classified=" + classified + "]";
	}



}
