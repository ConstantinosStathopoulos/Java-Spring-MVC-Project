package gr.hua.dit.entity;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students.data")
public class Student {
	// for postgres we use sequence type in generatedvalue
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "lessons")
	private int lessons;

	@Column(name = "year")
	private int year;

	@Column(name = "department")
	private String department;

	@Column(name = "average")
	private double average;

	@Column(name = "allowed")
	private boolean allowed;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "applications.data", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "position_id"))
	private List<Positions> positions;

	public List<Positions> getPositions() {
		return positions;
	}

	public void setPositions(List<Positions> positions) {
		this.positions = positions;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

//constractor
	public Student(String name, String surname, int lessons, int year, String department, double average,
			boolean allowed) {
		super();

		this.name = name;
		this.surname = surname;
		this.lessons = lessons;
		this.year = year;
		this.department = department;
		this.average = average;
		this.allowed = allowed;
	}

//Getters-Setters
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getLessons() {
		return lessons;
	}

	public void setLessons(int lessons) {
		this.lessons = lessons;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public boolean isAllowed() {
		return allowed;
	}

	public void setAllowed(boolean allowed) {
		this.allowed = allowed;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + name + ", lastName=" + surname + ", lessons=" + lessons
				+ ", year=" + year + ", department=" + department + ", average=" + average + ", allowed=" + allowed
				+ "]";

	}
}
