package gr.hua.dit.DAO;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Positions;
import gr.hua.dit.entity.Student;

@Repository
public class PositionsDAOImpl implements PositionsDAO{
	
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
	  public List<Positions> getAcceptedPositions(){ 
		  Session currentSession = sessionFactory.getCurrentSession(); 
		  Query<Positions> query =
				  currentSession.createQuery("from Positions where allowed=true",
						  Positions.class); 
	  List<Positions> positions = query.getResultList(); 
	  return positions; 
	  }
	  
	  
	  	@Override
		public void updatePositions(int id,String department) {
			Session currentSession = sessionFactory.getCurrentSession();
			Positions position = currentSession.get(Positions.class, id);
			position.setAllowed(true);
			position.setDepartment(department);
			System.out.println("Done!");
		}
	  
	  	@Override
		public List<Positions> getDepartmentPositions(String department) {
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query<Positions> query = currentSession.createQuery("from Positions p.id left join Student s.id on p.id=s.id where p.department= :department and allowed=true", 
					Positions.class);
			query.setParameter("department", department);
			List<Positions> dept_Positions = query.getResultList();
			return dept_Positions;
		}


		@Override
		public void savePosition(int student_id, int position_id) {
			Session currentSession = sessionFactory.getCurrentSession();
			Positions position = currentSession.get(Positions.class,position_id);
			Student student = currentSession.get(Student.class, student_id);
			List<Positions> positions = student.getPositions();
			System.out.println(positions);
			position.addStudent(student);
		}
	  
	 
}
