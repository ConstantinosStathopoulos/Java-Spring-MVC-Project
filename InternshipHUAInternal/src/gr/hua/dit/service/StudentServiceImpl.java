package gr.hua.dit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.hua.dit.DAO.StudentDAO;
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
	public void updateStudent(Student theStudent) {
		studentDAO.updateStudent(theStudent);
		
	}
	
	
}
