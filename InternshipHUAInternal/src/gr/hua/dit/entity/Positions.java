package gr.hua.dit.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "applications.data", joinColumns = @JoinColumn(name = "position_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

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
	public void addStudent(Student student) {
		
		if (students == null) {
			students = new ArrayList<>();
		}
		
		students.add(student);
	}
	@Override
	public String toString() {
		return "Position [id=" + id + ", companyName =" + name + ", positionCategory=" + category + ", department ="
				+ department + ", allowed=" + allowed + "]";
	}

}
