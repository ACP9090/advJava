package com.ap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ap.DTO.EmployeeDto;
import com.ap.VO.EmployeeVo;
import com.ap.service.EmployeeMgmtService;
import com.ap.service.EmployeeMgmtServiceImpl;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	EmployeeMgmtService serv=null;
	public ControllerServlet()
	{
		serv=new EmployeeMgmtServiceImpl();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=null;
	EmployeeVo vo=null;
	EmployeeDto dto=null;
	String result=null;
	
	//create printWriter object
	pw=res.getWriter();
	//set content type
	res.setContentType("text/html");
	
	//read input and set into vo 
	vo=new EmployeeVo();
	vo.seteName(req.getParameter("eName"));
	vo.seteAddress(req.getParameter("eAddress"));
	vo.seteDoj(req.getParameter("eDoj"));
	System.out.println(req.getParameter("eDoj"));
	vo.seteSal(req.getParameter("eSal"));
	
	//set the vo object data into dto object
	dto=new EmployeeDto();
	dto.seteName(vo.geteName());
	dto.setEAddress(vo.geteAddress());
	dto.setbSal(Float.parseFloat(vo.geteSal()));
	dto.setDoj(java.sql.Date.valueOf(vo.geteDoj()));
	
	//pass dto object tos service class
	try
	{
	result=serv.registerEmployee(dto);
	pw.println("<h1 style='color:green;text-align:center'>Result is"+result+"</h1>");
	}
	catch(Exception e)
	{
		pw.println("<h1 style='color:green;text-align:center'>========Internal DB Problem======</h1>");
	    e.printStackTrace();
	}
	
	
	//closing pw
	pw.println("click here to go <a href='emp-registration.html'>Home</a>");
	pw.close();
	
	}//doPost(-,-)
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}//doGet(-,-)

}
