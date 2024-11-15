package ecm;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import ecm.controller.Controller;
import ecm.entity.Candidate;

public class Client {
    public void getAllCandidateList() throws SQLException {

		Controller controller = new Controller();
		List<Candidate> candidates = controller.getAllCandidate();
		if (candidates != null) {
			for (Candidate candidate : candidates) {
				System.out.println(candidate);
			}
		} else {
			System.out.println("No candidates found.");
		}
	}

	private void insertCandidate() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Candidate ID: ");
		int c_id = sc.nextInt();

		System.out.print("Enter Candidate Name: ");
		String name = sc.next();

		System.out.print("Enter Candidate Party Name: ");
		String partyname = sc.next();

		System.out.print("Enter Candidate State: ");
		String state = sc.next();

		System.out.print("Enter Candidate assembelyr: ");
		String assembely = sc.next();

		System.out.print("Enter Candidate Gender: ");
		String gender = sc.next();

		System.out.print("Enter Candidate Age: ");
		int age = sc.nextInt();

		Candidate Candidate = new Candidate(c_id, name, partyname, state, assembely, gender, age);
		Controller controller = new Controller();
		controller.insertCandidate(Candidate);

		System.out.println("Employee inserted successfully!");

	}

	private void updateCandidate() {

		Scanner sc = new Scanner(System.in);
		Controller controller = new Controller();

		System.out.print("Enter Candidate ID To Update: ");
		int c_id = sc.nextInt();

		System.out.print("Enter Candidate Name To Update: ");
		String name = sc.next();

		System.out.print("Enter Candidate Party Name To Update: ");
		String partyname = sc.next();

		System.out.print("Enter Candidate State To Update: ");
		String state = sc.next();

		System.out.print("Enter Candidate assembely To Update: ");
		String assembely = sc.next();

		System.out.print("Enter Candidate Gender To Update: ");
		String gender = sc.next();

		System.out.print("Enter Candidate Age To Update: ");
		int age = sc.nextInt();

		Candidate Candidate = new Candidate(c_id, name, partyname, state, assembely, gender, age);
		boolean success = controller.updateCandidate(Candidate);

		if (success) {
			System.out.println("Candidate detail updated successfully.");
		} else {
			System.out.println("Candidate with the given ID not found.");
		}
	}

	private void deleteCandidate() {
		Scanner sc = new Scanner(System.in);
		Controller controller = new Controller();

		System.out.println("Enter Candidate ID to delete:");
		int id = sc.nextInt();

		boolean success = controller.deleteCandidate(id);

		if (success) {
			System.out.println("Candidate deleted successfully.");
		} else {
			System.out.println("Candidate with the given ID not found.");
		}
	}

	public static void main(String[] args) throws SQLException {

		Client c = new Client();

		char ch;
		do {
			System.out.println("1.See All Candidate");
			System.out.println("2.Insert Candidate");
			System.out.println("3.Update Candidate");
			System.out.println("4.Delete Candidate");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				c.getAllCandidateList();
				break;
			case 2:
				c.insertCandidate();
				break;
			case 3:
				c.updateCandidate();
				break;
			case 4:
				c.deleteCandidate();
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
			System.out.println("Continue y/n");
			ch = sc.next().charAt(0);
		} while (ch == 'y' || ch == 'Y');

        
	}
}