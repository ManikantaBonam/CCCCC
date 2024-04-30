package com.apspdcl.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertsDao {
	public String setValues(String eId,String eName,String eDOB,String eGender,String eDesignation,String eLocation)throws Exception{

		Connection con=null;
		PreparedStatement pst=null;
		//ResultSet rs=null;
		int i=0;
		try{
		String driver="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="scott";
		String pass="tiger";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection(driver,user,pass);
		
		String query="insert into Employeer Values(?,?,?,?,?,?)";
		pst=con.prepareStatement(query);
		pst.setString(1, eId);
		pst.setString(2, eName);
		pst.setString(3, eDOB);
		pst.setString(4, eGender);
		pst.setString(5, eDesignation);
		pst.setString(6, eLocation);
		
		i=pst.executeUpdate();
				
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(i>0){
			return "Inserted Successfully";
		}
		else{
			return "please Insert Valid Values";
		}
		
		
}


}
