package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		
		super.init();
		ServletContext ctx=getServletContext();
		ctx.setAttribute("count", 0);
	}

}
