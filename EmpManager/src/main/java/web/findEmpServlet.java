package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EmpDao;
import Entity.Emp;

public class findEmpServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao dao=new EmpDao();
		List<Emp> list=dao.findAll();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter p=response.getWriter();
		p.println("<table border='1' cellspacing='0' width='30%'>");
		p.println("<tr>");
		p.println("   <td>编号</td>");
		p.println("   <td>姓名</td>");
		p.println("   <td>工作</td>");
		p.println("   <td>工资</td>");
		p.println("</tr>");
		if(list!=null){
			for(Emp e:list){
				p.println("<tr>");
				p.println("   <td>"+e.getEmpno()+"</td>");
				p.println("   <td>"+e.getName()+"</td>");
				p.println("   <td>"+e.getJob()+"</td>");
				p.println("   <td>"+e.getSal()+"</td>");
				p.println("</tr>");
			}
		}
		p.println("</table>");
		p.close();
		
		
	}

}
