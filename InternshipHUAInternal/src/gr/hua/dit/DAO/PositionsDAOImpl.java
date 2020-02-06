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

		// System.out.println(positions);
		// System.out.println(students);

		// and p.id not in (select position_id from applications.data where
		// student_id=:username )
		// and p.id not in :positions
		String queryNull = "from Positions p where p.department=:department and p.allowed=true";
		String queryNotnull = "from Positions p where p.department=:department and p.allowed=true and p.id not in :positions";
		/*
		 * Query<Positions> query = currentSession.createQuery(
		 * "from Positions p where p.department=:department and p.allowed=true and p.id not in :positions"
		 * , Positions.class);
		 */
		if (posID.isEmpty()) {
			Query<Positions> query = currentSession.createQuery(
					 queryNull
					  , Positions.class);
			query.setParameter("department", department);
			List<Positions> dept_Positions = query.getResultList();
			return dept_Positions;
			
			}else {
				Query<Positions> query = currentSession.createQuery(
						 queryNotnull
						  , Positions.class);
				query.setParameter("department", department);
				query.setParameterList("positions", posID);
				List<Positions> dept_Positions = query.getResultList();
				return dept_Positions;
			
			}
//		query.setParameter("department", department);
//		query.setParameterList("positions", posID);
//		List<Positions> dept_Positions = query.getResultList();

		
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
		//int id =position.getId();
		 //position = currentSession.get(Positions.class,id);
		position.setCategory(category);
		position.setName(name);

		
			currentSession.save(position);
		}
	
	public List<Positions> seePositions( String compName){
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Positions> query = currentSession.createQuery("from Positions where allowed=true and name= :compName", Positions.class);
		query.setParameter("compName", compName);
		List<Positions> positions = query.getResultList();
		return positions;
		
	}

	@Override
	public List<Student> StudentsForPosition(String compName, int posID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Positions position = currentSession.get(Positions.class, posID);
		List<Student> students = position.getStudents();
		return students;
	}

	}



	/*
	 * private String getUsername(String userId) { Object principal =
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); if
	 * (principal instanceof UserDetails) { String username =
	 * ((UserDetails)principal).getUsername(); } else { String username =
	 * principal.toString(); } return userId;
	 * 
	 * 
	 * }
	 */


