package gr.hua.dit.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import gr.hua.dit.entity.Positions;
import gr.hua.dit.entity.Student;

@Repository
public class PositionsDAOImpl implements PositionsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Positions> getAllPositions() {
		// TODO Auto-generated method stub

		Session currentSession = sessionFactory.getCurrentSession();
		Query<Positions> query = currentSession.createQuery("from Positions where allowed=false ", Positions.class);
		List<Positions> positions = query.getResultList();

		return positions;
	}

	@Override
	public List<Positions> getAcceptedPositions() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Positions> query = currentSession.createQuery("from Positions where allowed=true", Positions.class);
		List<Positions> positions = query.getResultList();
		return positions;
	}

	@Override
	public void updatePositions(int id, String department) {
		Session currentSession = sessionFactory.getCurrentSession();
		Positions position = currentSession.get(Positions.class, id);
		position.setAllowed(true);
		position.setDepartment(department);
		System.out.println("Done!");
	}

	@Override
	public List<Positions> getDepartmentPositions(String department, int student_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Student student = currentSession.get(Student.class, student_id);

		List<Positions> positions = student.getPositions();
		List<Integer> posID = new ArrayList<Integer>();

		for (Positions pos : positions) {
			posID.add(pos.getId());
		}
		System.out.println(posID);

		String queryNull = "from Positions p where p.department=:department and available=true and p.allowed=true";
		String queryNotnull = "from Positions p where p.department=:department and p.allowed=true and p.available=true and p.id not in :positions";

		if (posID.isEmpty()) {
			Query<Positions> query = currentSession.createQuery(queryNull, Positions.class);
			query.setParameter("department", department);
			List<Positions> dept_Positions = query.getResultList();
			return dept_Positions;

		} else {
			Query<Positions> query = currentSession.createQuery(queryNotnull, Positions.class);
			query.setParameter("department", department);
			query.setParameterList("positions", posID);
			List<Positions> dept_Positions = query.getResultList();
			return dept_Positions;

		}

	}

	@Override
	public void savePosition(int student_id, int position_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Positions position = currentSession.get(Positions.class, position_id);
		Student student = currentSession.get(Student.class, student_id);
		List<Positions> positions = student.getPositions();
		System.out.println(positions);
		position.addStudent(student);
	}

	@Override
	public void saveCompanyPosition(String name, String category) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		Positions position = new Positions();
		position.setCategory(category);
		position.setName(name);
		position.setChosen_student(null);

		currentSession.save(position);
	}

	public List<Positions> seePositions(String compName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Positions> query = currentSession.createQuery("from Positions where allowed=true and available=true and name= :compName",
				Positions.class);
		query.setParameter("compName", compName);
		// List<Positions> positions = query.getResultList();
		List<Positions> positions = query.getResultList();
		return positions;

	}

	@Override
	public List<Student> StudentsForPosition(String compName, int posID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Positions position = currentSession.get(Positions.class, posID);
		List<Student> students = position.getStudents();
	List<Student> available_students = new ArrayList<Student>();
	for(Student st : students) {
		if(st.isChosen()==false) {
			available_students.add(st);
		}
	}
		System.out.println(students);
		return available_students;
	}

	@Override
	public boolean saveStudent(int posID, String studentID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Positions position = currentSession.get(Positions.class, posID);
		
		int sID = Integer.parseInt(studentID);
		Student student = currentSession.get(Student.class, sID);
		position.setChosen_student(studentID);
		position.setAvailable(false);
		student.setChosen(true);
		return true;
	}

}