package gr.hua.dit.DAO;

import java.util.List;


import gr.hua.dit.entity.Positions;
import gr.hua.dit.entity.Student;

public interface PositionsDAO {
	public List<Positions> getAllPositions();
	public List<Positions> getAcceptedPositions();
	public void updatePositions(int id, String department);
	public List<Positions> getDepartmentPositions(String department, int student_id);
	public void savePosition(int student_id, int position_id);
	void saveCompanyPosition(String name, String category);
	public List<Positions> seePositions( String compName);
	public List<Student> StudentsForPosition( String compName, int posID);
	public boolean saveStudent(int posID, String studentID);
}
