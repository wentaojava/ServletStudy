package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EmpDao;
import Entity.Emp;

public class AddEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String empName=req.getParameter("empName");
		String empJob=req.getParameter("empJob");
		float empSal=new Integer(req.getParameter("empSal"));
		Emp emp=new Emp();
		emp.setName(empName);;
		emp.setJob(empJob);
		emp.setSal(empSal);
		EmpDao e=new EmpDao();
		e.saveEmp(emp);
		//÷ÿ∂®œÚ
		res.sendRedirect("findEmpServlet");
	}
}
