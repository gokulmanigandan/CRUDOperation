package demopackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/de")
public class de extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	String sid = request.getParameter("id");
    	int iid = Integer.parseInt(sid);
    	
    	try {
			int con = Connectionsql.delete(iid);
			response.sendRedirect("home");
		} 
    	catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}



}
