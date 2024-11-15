package ecm.service;

import java.sql.SQLException;
import java.util.List;

import ecm.dao.Dao;
import ecm.entity.Candidate;

public class Service {
Dao dao = new Dao();
	public List<Candidate> getAllCandidate() throws SQLException{
		return dao.getAllCandidate();
	}
	
	public void insertCandidate(Candidate candidate) {
		dao.insertCandidate(candidate);
		
	}

	public boolean updateCandidate(Candidate candidate) {
		return dao.updateCandidate(candidate);
	}

	public boolean deleteCandidate(int id) {
		return dao.updateCandidate(id);
	}
}
