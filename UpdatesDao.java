package com.apspdcl.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatesDao {
	public String updatevalues(String eId,String eDesignation, String eLocation) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			
			String sql = "update Employeer set Designation=?,WORK_LOCATION=? where EID=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			con = DriverManager.getConnection(url,user,pwd);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(3, eId);
			pstmt.setString(1, eDesignation);
			pstmt.setString(2, eLocation);
			i = pstmt.executeUpdate();
			if(i > 0) {
				return "Values are updated";
			}
			else {
				return "values not updated";
			}
			}
		catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
		finally {
			try {
				if(pstmt!=null)
					pstmt.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}