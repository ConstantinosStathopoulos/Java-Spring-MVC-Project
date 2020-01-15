package gr.hua.dit.DAO;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Student;




@Repository
public class StudentDAOImpl implements StudentDAO {
	
	//session factory injection
	@Autowired
	private SessionFactory sessionFactory;
	
	//for list of all student, sorted by id
	@Override
	public List<Student> getStudents() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Student> query = currentSession.createQuery("from Student where lessons<4 and year<5 and year>2 and allowed=false order by id", 
				Student.class);
		
		
		// execute the query and get the results list
		List<Student> students = query.getResultList();
				
		//return the results
		return students;
	}

	@Override
	public void updateStudent(int id) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
		//update the student
				Student student = currentSession.get(Student.class, id);
				student.setAllowed(true);
				System.out.println("Done!");
		
	}
	

}
