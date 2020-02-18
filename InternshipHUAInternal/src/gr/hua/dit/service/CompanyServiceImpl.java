package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.DAO.PositionsDAO;
import gr.hua.dit.entity.Positions;
import gr.hua.dit.entity.Student;

@Service
public class CompanyServiceImpl implements CompanyService {

	
	@Autowired
	private PositionsDAO positionsDAO;
	
	@Override
	@Transactional
	public void saveCompanyPosition(String name, String category) {
		positionsDAO.saveCompanyPosition(name,category);
		
	}

	@Override
	@Transactional
	public List<Positions> companyPositions(String compName) {
		return positionsDAO.seePositions(compName);
	}

	@Override
	@Transactional
	public List<Student> StudentsForPosition(String compName, int posID) {
		return positionsDAO.StudentsForPosition(compName, posID);
	}

	@Override
	@Transactional
	public boolean saveStudentsForPosition(int posID, String studentID) {
	
		return positionsDAO.saveStudent(posID,studentID);
	}

		
}
