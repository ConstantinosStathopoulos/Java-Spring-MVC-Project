package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Positions;


public interface OfficeService {
	public List<Positions> getAllPositions();
	public List<Positions> getAcceptedPositions();
	public void updatePositions(int id,String department);
	
}
