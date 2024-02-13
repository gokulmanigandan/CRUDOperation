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


@WebServlet("/addemp")
public class addemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String cnt = request.getParameter("cnt");
		
		Employee e = new Employee();
		e.setName(name);
		e.setPassword(pwd);
		e.setEmailid(email);
		e.setCountry(cnt);
		
		try {
			int a = Connectionsql.save(e);
			if(a>0) {
//				out.println("<script type='text/javascript'>" + "alert('Data Inserted Successfully')" + "</script");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
			else {
				out.print("invalid details...");
			}
		} 
		catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

}
