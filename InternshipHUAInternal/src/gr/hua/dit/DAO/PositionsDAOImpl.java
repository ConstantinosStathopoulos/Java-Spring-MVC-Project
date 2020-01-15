package gr.hua.dit.DAO;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Positions;

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
	  
	  
	  
	 
}
