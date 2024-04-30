package com.apspdcl.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Deletedao {
	public String deleteValues(String bId) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String username = "scott";
			String password = "tiger";
			
			String query = "delete from Employeer where EID=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,username,password);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bId);
			rs = pstmt.executeQuery();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(rs.next()) {
			return "Deleted Successfully";
		}
		else {
			return "Fail to delete";
		}
	}


}


