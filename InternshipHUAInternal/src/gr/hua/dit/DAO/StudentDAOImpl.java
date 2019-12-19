package gr.hua.dit.DAO;
import java.util.List;

import javax.transaction.Transactional;

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
	
	//for list of all student
	@Override
	@Transactional
	public List<Student> getStudents() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Student> query = currentSession.createQuery("from Student where lessons<4 and year<5 and year>2 and allowed=false", 
				Student.class);
		
		
		// execute the query and get the results list
		List<Student> students = query.getResultList();
				
		//return the results
		return students;
	}
	
	//for list of allowed students
//	@Override
//	public List<Student> getAllowedStudents(){
//		
//		// get current hibernate session
//				Session currentSession = sessionFactory.getCurrentSession();
//				
//				// create a query
//				Query<Student> query = currentSession.createQuery("from Student s where s.allowed='true' order by id", 
//						Student.class);
//				
//				
//				// execute the query and get the results list
//				List<Student> AllowedStudents = query.getResultList();
//						
//				//return the results
//				return AllowedStudents;
//	}

}
