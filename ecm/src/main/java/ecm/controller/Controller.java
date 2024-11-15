package ecm.controller;

import java.sql.SQLException;
import java.util.List;

import ecm.service.Service;

import ecm.entity.Candidate;

public class Controller {
Service service = new Service();

	public List<Candidate> getAllCandidate() throws SQLException {
		return service.getAllCandidate();
	}

	public void insertCandidate(Candidate Candidate) {
		service.insertCandidate(Candidate);
	}

	public boolean updateCandidate(Candidate candidate) {
		return service.updateCandidate(candidate);
	}

	public boolean deleteCandidate(int id) {
		return service.deleteCandidate(id);
	}
}
