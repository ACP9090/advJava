package com.ap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ap.BO.EmployeeBo;

public class EmployeeDaoImpl implements EmployeeDao{
private static final String INSERT_EMPLOYEE="INSERT INTO EMPLOYEE_DETAILS VALUES(EMP_DETAILS_NO.NEXTVAL,?,?,?,?,?,?)";
	private Connection getPolledConnection() throws Exception
	{
	  InitialContext ic=null;
	  DataSource ds=null;
	  Connection con=null;
	  
	  //get InitialContext object
	  ic=new InitialContext();
	  ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
	  con=ds.getConnection();
	  return con;
	}
	@Override
	public int insert(EmployeeBo bo) throws Exception {
		Connection con;
		PreparedStatement ps=null;
		int count=0;
		//get polled Connection
		con=getPolledConnection();
		//create prepared stmt
		
		ps=con.prepareStatement(INSERT_EMPLOYEE);
		//set Query param
		ps.setString(1, bo.geteName());
		ps.setString(2, bo.geteAddress());
		ps.setDate(3, bo.getDoj());
		ps.setFloat(4, bo.getbSal());
		ps.setFloat(5, bo.getnSal());
		ps.setFloat(6, bo.getgSal());
		
		//execute the query
		if(ps!=null)
		   count=ps.executeUpdate();
		//close the jdbc object
		ps.close();
		con.close();
		return count;
	}

}
