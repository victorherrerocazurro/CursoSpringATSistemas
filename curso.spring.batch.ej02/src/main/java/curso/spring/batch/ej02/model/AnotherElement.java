package curso.spring.batch.ej02.model;

import java.io.Serializable;

public class AnotherElement implements Serializable {

    private static final long serialVersionUID = 269176933236284899L;
    
	private String id;
	
	public AnotherElement() {
		// TODO Auto-generated constructor stub
	}

	
	
	public AnotherElement(String id) {
		super();
		this.id = id;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "AnotherElement [id=" + id + "]";
	}
	
	
	
}
