package com.apspdcl.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.apspdcl.model.Emp;






public class ListDao {
	public List<Emp> view() throws ClassNotFoundException, SQLException  {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Emp> emp = new ArrayList<Emp>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			pstmt = conn.prepareStatement("SELECT * from Employeer order by eid");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Emp b=new Emp();
				b.seteId(rs.getString(1));
				b.seteName(rs.getString(2));
				b.seteDob(rs.getString(3));
				b.seteGender(rs.getString(4));
				b.seteDesignation(rs.getString(5));
				b.seteLocation(rs.getString(6));
				emp.add(b);

			} 

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		return emp;

	}

}