package Entity;

public class Entity {
	/* Attributes */
	private Integer id;

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
