package com.ap.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newurl")
public class ErrorServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet.doGet()");
		PrintWriter pw=null;
		//create printWriter object
		pw=res.getWriter();
		//set Content type
		res.setContentType("text/html");
		
		//printing the error message into browser through main servlet
		pw.println("<h1 style='color:red;text-align:center'>Internal DB problem</h1>");
		pw.println("<br>click here <a href='input.html'>Home</a> ");
		
		pw.close();
	}//doGet(-,-)

     public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet.doPost()");
		doGet(req, res);
	}//doPost(-,-)

}
