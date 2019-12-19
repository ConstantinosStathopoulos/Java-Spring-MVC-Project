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
	private String subject;
	
	@Column(name = "allowed")
	private boolean allowed;

	public Positions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Positions(String name, String subject, boolean allowed) {
		super();
		
		this.name = name;
		this.subject = subject;
		this.allowed = allowed;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public boolean isAllowed() {
		return allowed;
	}

	public void setAllowed(boolean allowed) {
		this.allowed = allowed;
	}
	
	
	@Override
	public String toString() {
	        return "Position [id=" + id + ", companyName =" + name +
	        		", positionSubject=" + subject + ", allowed=" + allowed +"]";
	}
	
}
