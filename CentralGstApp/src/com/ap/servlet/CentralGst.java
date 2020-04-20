package com.ap.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/centralurl")
public class CentralGst extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		
		String projectType=null;
		float cost=0.0f;
		float cGst=0.0f;
		pw=res.getWriter();
		//set Content type
		res.setContentType("text/html");
		//read form data
		cost=Float.parseFloat(req.getParameter("cost"));
		projectType=req.getParameter("type");
		
		//calculate central gst
		if(projectType.equalsIgnoreCase("product"))
			cGst=cost*0.18f;
		else if(projectType.equalsIgnoreCase("service"))
			cGst=cost*0.2f;
		else if(projectType.equalsIgnoreCase("startup"))
			cGst=cost*0.1f;
		
		pw.println("<h2>State Gst::::"+cGst+"</h2>");
		
		
		//dont close stream here
		//pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
