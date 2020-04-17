package com.ap.servlet;
import java.io.IOException;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpDetails extends HttpServlet {
	private static final String SELECT_EMP_BY_ID="SELECT ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=null;
	int empId=0;
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String name=null,job=null;
	float sal=0.0f;
	int deptno=0;
	ServletConfig cg=null;
	String driver=null,user=null,url=null,pass=null;
	
	RequestDispatcher rd=null;
	
try{
	//get servlet config object and its value
	cg=getServletConfig();
	driver=cg.getInitParameter("driver");
	url=cg.getInitParameter("url");
	user=cg.getInitParameter("dbuser");
	pass=cg.getInitParameter("dbpwd");
	//get PrintWriter
	pw=res.getWriter();
	//set browser content type
	res.setContentType("text/html");
	
	System.out.println("EmpDetails.doGet()");
	
     //getting form element
	 empId=Integer.parseInt(req.getParameter("emp"));
     pw.println("<h1>Entered Employee id::"+empId+"</h1>");
	 
	 //persistense logic

	    //register driver
		Class.forName(driver);
		//establish connection
		con=DriverManager.getConnection(url,user,pass);
		//create ps
		if(con!=null)
			ps=con.prepareStatement(SELECT_EMP_BY_ID);
		//set query param
		if(ps!=null)
		{
		    ps.setInt(1,empId);
		    //execute sql query
		    rs=ps.executeQuery();
		}
		//process the result....
		if(rs.next())
		{
			name=rs.getString(1);
			job=rs.getString(2);
			sal=rs.getFloat(3);
			deptno=rs.getInt(4);
			//print the result....
			pw.println("<br><h2 style='color:green'><b>Employee name::"+name+"</b></h2>");
			pw.println("<br><h2 style='color:green'><b>Employee job::"+job+"</b></h2>");
			pw.println("<br><h2 style='color:green'><b>Employee sal::"+sal+"</b></h2>");
			pw.println("<br><h2 style='color:green'><b>Employee department no.::"+deptno+"</b></h2>");


		}//if
		else{
		pw.println("<h1 style='color:red;text-align:center'>employee id not present</h1>");
		}

	 
	}//try
	
		catch(Exception e)
		{
			rd=req.getRequestDispatcher("/newurl");
			System.out.println("before calling rd.forward");	
			rd.forward(req,res);
			/*ServletContext sc=getServletContext();
			rd=sc.getRequestDispatcher("/errorurl");*/
				
			System.out.println("after calling rd.forward()");
	    
		
		}//catch

		finally
		{
			//close jdbc object
			try{
				if(rs!=null)
					rs.close();
			   }catch(SQLException se)
			      {
				    se.printStackTrace();
			       }

		      try{
				if(ps!=null)
					ps.close();
			   }catch(SQLException se)
			      {
				    se.printStackTrace();
			       }
			 try{
				if(con!=null)
					con.close();
			   }catch(SQLException se)
			      {
				    se.printStackTrace();
			       }
		pw.println("<p><a href='input.html' >HOME</a></p>");

			try{
				if(pw!=null)
					pw.close();
			   }catch(Exception e)
			      {
				    e.printStackTrace();
			       }	  

		}//finally  
}//doGet(-,-)
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	System.out.println("EmpDetails.doPost()");	
	doGet(req, res);
	}
}
