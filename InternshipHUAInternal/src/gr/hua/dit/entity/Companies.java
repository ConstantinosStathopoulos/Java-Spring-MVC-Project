package gr.hua.dit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companies.data")
public class Companies {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	
	
	public Companies() {
		// TODO Auto-generated constructor stub
	}
	
	public Companies(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
