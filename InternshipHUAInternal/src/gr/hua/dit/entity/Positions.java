package gr.hua.dit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "companies.positions")
public class Positions {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "comp_name")
	private String name;

	@Column(name = "category")
	private String category;
	
	@Column(name = "allowed")
	private boolean allowed;
	
	@Column(name = "department")
	private String department;

	public Positions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Positions(String name, String category, boolean allowed, String department) {
		super();
		
		this.name = name;
		this.category = category;
		this.allowed = allowed;
		this.department = department;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isAllowed() {
		return allowed;
	}

	public void setAllowed(boolean allowed) {
		this.allowed = allowed;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	@Override
	public String toString() {
	        return "Position [id=" + id + ", companyName =" + name +
	        		", positionCategory=" + category + ", department =" + department + ", allowed=" + allowed +"]";
	}
	
}
