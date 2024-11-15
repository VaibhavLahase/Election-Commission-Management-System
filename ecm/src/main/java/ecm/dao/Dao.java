package ecm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecm.entity.Candidate;

public class Dao {
String path = "com.mysql.cj.jdbc.Driver"; 
	String url = "jdbc:mysql://localhost:3306/new_schema";
	String uname = "root";
	String pwd = "root@123";
	String query = "SELECT * FROM new_schema.candidate";
	PreparedStatement ps = null;
	
	ResultSet rs = null;
	Connection conn = null;
	
	public List<Candidate> getAllCandidate() throws SQLException {
		
		List<Candidate> allcandidatelist = new ArrayList<>();
		
		try {
			Class.forName(path);
		   conn = DriverManager.getConnection(url, uname, pwd);
		   ps = conn.prepareStatement(query);
           rs = ps.executeQuery();
		
           while (rs.next()) {
        	   
        	   Candidate can = new Candidate();
        	   can.setC_id(rs.getInt("c_id"));
        	   can.setCname(rs.getString("name"));
        	   can.setPartyname(rs.getString("Partyname"));
        	   can.setAssembely(rs.getString("Assembely"));
        	   can.setGender(rs.getString("Gender"));
        	   can.setAge(rs.getInt("Age"));
        	   allcandidatelist.add(can);
        	   
           }
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		return allcandidatelist;
	}
	public void insertCandidate(Candidate can) {
		String insertQuery = "INSERT INTO new_schema.candidate (c_id, name,partyname,state, assembely,gender,age) VALUES (?, ?, ?, ?, ?, ?,?)";
    	//PreparedStatement ps = null;
    	
    	try {
			Class.forName(path);
			conn = DriverManager.getConnection(url, uname, pwd);
		
			ps = conn.prepareStatement(insertQuery);
			ps.setInt(1, can.getC_id());
			ps.setString(2, can.getCname());
			ps.setString(3, can.getPartyname());
			ps.setString(4, can.getState());
			ps.setString(5, can.getAssembely());
			ps.setString(6, can.getGender());
			ps.setInt(7, can.getAge());

			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public boolean updateCandidate(Candidate can) {
		String query = "UPDATE candidate SET name = ?, partyname = ?, state = ?, assembely = ?, gender = ?, age = ? WHERE c_id = ?";
       // PreparedStatement ps = null;
        boolean isUpdated = false;

        try {
            conn = DriverManager.getConnection(url, uname, pwd);

            ps = conn.prepareStatement("SELECT COUNT(*) FROM candidate WHERE c_id = ?");
            ps.setInt(1, can.getC_id());
            rs = ps.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                System.out.println("Candidate with  " + can.getC_id() + " this Id not found.");
                return false;
            }

            ps = conn.prepareStatement(query);
            ps.setInt(1, can.getC_id());
			ps.setString(2, can.getCname());
			ps.setString(3, can.getPartyname());
			ps.setString(4, can.getState());
			ps.setString(5, can.getAssembely());
			ps.setString(6, can.getGender());
			ps.setInt(7, can.getAge());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isUpdated;
	}
	public boolean updateCandidate(int id) {
		String deleteQuery = "DELETE From candidate WHERE c_id = ?";
       // PreparedStatement ps = null;
        boolean isdeleted = false;
		
        try {
            conn = DriverManager.getConnection(url, uname, pwd);

            ps = conn.prepareStatement("SELECT COUNT(*) FROM candidate WHERE c_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                System.out.println("Candiadte with  " + id + " ID  not found.");
                return false;
            }

            ps = conn.prepareStatement(deleteQuery);
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                isdeleted = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return isdeleted;
		
		
	}
}
