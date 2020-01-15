package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Student;

public interface StudentService {

	public List<Student> getStudents();

	public void updateStudent(int id);

}
