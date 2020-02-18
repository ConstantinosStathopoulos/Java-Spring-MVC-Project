package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Positions;
import gr.hua.dit.entity.Student;

public interface StudentService {

	public List<Student> getStudents();

	public void updateStudent(int id);
	
	public boolean isAllowed(int id);
	
	public String getDepartment(int id);
	
	public List<Positions> getDepartmentPositions(String department, int student_id);

	public void savePosition(int student_id, int position_id );

	public List<Positions> getStudentApplications(int student_id);
	
}
