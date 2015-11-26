package curso.spring.batch.ej02.model;

import java.io.Serializable;

public class Element implements Serializable {

	private static final long serialVersionUID = 141976950236790725L;

	private int id;

	private String text;

	public Element() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Element [id=" + id + ", text=" + text + "]";
	}
	
	

}