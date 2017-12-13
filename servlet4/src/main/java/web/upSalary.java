package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class upSalary extends HttpServlet {
	
	private Double salary=2000.0;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//加锁解决并发问题
		synchronized(this) {
			salary+=100.0;
			//假设延迟
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		res.setContentType("text/html");
		PrintWriter w=res.getWriter();
		w.print(salary);
		w.close();
		}
		
		
		
	}

}
