package gr.hua.dit.DAO;

import java.util.List;

import gr.hua.dit.entity.Student;

public interface StudentDAO {

	public List<Student> getStudents();

	public void updateStudent(int id);

	public boolean isAllowed(int id);

	public String getDepartment(int id);

}
