package curso.spring.batch.ej03.modelo;

public class Report6 {
	private int id;
	private String Impressions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImpressions() {
		return Impressions;
	}

	public void setImpressions(String impressions) {
		Impressions = impressions;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", Impressions=" + Impressions + "]";
	}
}
