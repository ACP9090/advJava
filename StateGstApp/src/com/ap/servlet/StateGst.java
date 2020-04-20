package com.ap.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/stateurl")
public class StateGst extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("StateGst.doGet()");
		PrintWriter pw=null;
		String company=null;
		String project=null;
		String projectType=null;
		float cost=0.0f;
		float sGst=0.0f;
		
		ServletContext sc1=null,sc2=null;
		RequestDispatcher rd=null;
		
		pw=res.getWriter();
		//set Content type
		res.setContentType("text/html");
		//read form data
		company=req.getParameter("company");
		project=req.getParameter("project");
		projectType=req.getParameter("type");
		cost=Float.parseFloat(req.getParameter("cost"));
		
		//display the Output
		pw.println("<h1 style='color:red ;text-align:center'>Gst Calculation</h1>");
		pw.println("<h2>Company Name::::"+company+"</h2>");
		pw.println("<h2>Project Name::::"+project+"</h2>");
		pw.println("<h2>Product Type::::"+projectType+"</h2>");
		pw.println("<h2>Project Cost::::"+cost+"</h2>");
		
		//calculate state Gst
		if(projectType.equalsIgnoreCase("product"))
			sGst=cost*0.12f;
		else if(projectType.equalsIgnoreCase("service"))
			sGst=cost*0.15f;
		else if(projectType.equalsIgnoreCase("startup"))
			sGst=cost*0.05f;
		
		pw.println("<h2>State Gst::::"+sGst+"</h2>");
		
		//communicate wth central Gst web app which is in same server
		//get servelt Context object of currest application
			sc1=getServletContext();
			//get Foreign context
			sc2=sc1.getContext("/CentralGstApp");
			rd=sc2.getRequestDispatcher("/centralurl");
			rd.include(req, res);
		
		
		
		pw.println("<a href='input.html'>HOME</a>");
		
		//closing printwriter
		pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
