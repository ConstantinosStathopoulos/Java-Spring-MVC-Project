package gr.hua.dit.internApp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students.data")
public class Student {
	//for postgres we use sequence type in generatedvalue
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "am")
	private int am;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "lessons")
	private int lessons;
	
	@Column(name = "year")
	private int year;
	
	@Column(name = "department")
	private int department;
	
	@Column(name = "average")
	private double average;
	
	@Column(name = "allowed")
	private boolean allowed;


public Student() {
		// TODO Auto-generated constructor stub
	}


//constractor
public Student( String name, String surname, int lessons, int year, int department, double average,
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
public int getAm() {
	return am;
}

public void setAm(int am) {
	this.am = am;
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

public int getDepartment() {
	return department;
}

public void setDepartment(int department) {
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



}
