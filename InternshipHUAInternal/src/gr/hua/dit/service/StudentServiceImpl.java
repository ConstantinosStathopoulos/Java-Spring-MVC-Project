package gr.hua.dit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.hua.dit.DAO.PositionsDAO;
import gr.hua.dit.DAO.StudentDAO;
import gr.hua.dit.entity.Positions;
import gr.hua.dit.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	// inject the student dao
	@Autowired
	private StudentDAO studentDAO;
	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}
	@Override
	@Transactional
	public void updateStudent(int id) {
		studentDAO.updateStudent(id);
		
	}
	
	@Override
	@Transactional
	public boolean isAllowed(int id) {
		return studentDAO.isAllowed(id);
		
	}

	@Override
	@Transactional
	public String getDepartment(int id) {
		return studentDAO.getDepartment(id);
	}
	@Autowired
	private PositionsDAO positionsDAO;
	@Override
	@Transactional
	public List<Positions> getDepartmentPositions(String department) {
		return positionsDAO.getDepartmentPositions(department);
	}
	@Override
	@Transactional
	public void savePosition(int student_id, int position_id) {
		positionsDAO.savePosition(student_id,position_id);
		
	}
	
}
