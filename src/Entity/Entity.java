package Entity;

public class Entity {
	/* Atributes */
	private Integer id;
	
	/* Constructor */
	Entity(Integer id){
		this.id = id;
	}

	/* Methods */	
	public Integer getId() { 
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean equals(Entity other) {
		return this.id == other.getId();
	}
	
}
