package gr.hua.dit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.hua.dit.DAO.PositionsDAO;
import gr.hua.dit.entity.Positions;

@Service
public class OfficeServiceImpl implements OfficeService {

	
	// inject the student dao
		@Autowired
		private PositionsDAO positionsDAO;
	@Override
	@Transactional
	public List<Positions> getAllPositions() {
		// TODO Auto-generated method stub
		return positionsDAO.getAllPositions();
	}

	@Override
	@Transactional
	public List<Positions> getAcceptedPositions() {
		// TODO Auto-generated method stub
		return positionsDAO.getAcceptedPositions();
	}

}
