package demopackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ed2")
public class ed2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print("yes come");
		
		String sid = request.getParameter("id");
		int iid = Integer.parseInt(sid);
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String cnty = request.getParameter("cnty");
		
//		out.println(iid);
//		out.println(name);
//		out.println(pwd);
//		out.println(email);
//		out.println(cnty);
//		
		Employee e = new Employee();
		e.setId(iid);
		e.setName(name);
		e.setPassword(pwd);
		e.setEmailid(email);
		e.setCountry(cnty);
		
		try {
			int y = Connectionsql.update(e);
			if(y>0) {
//				RequestDispatcher rd = request.getRequestDispatcher("home");
//				rd.include(request, response);
				response.sendRedirect("home");
			}
			else {
				out.print("Sorry unable to update record......");
				
			}
		} 
		catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

}
