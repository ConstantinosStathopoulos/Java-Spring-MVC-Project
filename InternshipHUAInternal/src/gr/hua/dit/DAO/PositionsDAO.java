package gr.hua.dit.DAO;

import java.util.List;

import gr.hua.dit.entity.Positions;

public interface PositionsDAO {
	public List<Positions> getAllPositions();
	public List<Positions> getAcceptedPositions();
	public void updatePositions(int id, String department);
	
}
