package demopackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<a href='index.jsp'>Add new employees...</a>");
		out.print("<hr>");
		out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\r\n"
				);
		try {
			List<Employee> l = Connectionsql.allEmp();
			
			out.print("<table class='table table-bordered'>");
			out.print("<thead>");
			out.print("<tr>");
			out.print("<th style>" + "ID" +"</th>");
			out.print("<th>" + "NAME" +"</th>");
			out.print("<th>" + "PASSWORD" +"</th>");
			out.print("<th>" + "EMAIL" +"</th>");
			out.print("<th>" + "COUNTRY" +"</th>");
			out.print("<th  colspan='2'>" + "ACTION" +"</th>");
			out.print("</tr>");
			out.print("</thead>");
			for(Employee i: l) {
				out.print("<tr>");
					out.print("<td>"+i.getId()+"</td>");
					out.print("<td>"+i.getName()+"</td>");
					out.print("<td>"+i.getPassword()+"</td>");
					out.print("<td>"+i.getEmailid()+"</td>");
					out.print("<td>"+i.getCountry()+"</td>");
					out.print("<td>"+"<a href='ed?id="+i.getId()+"'>Edit</a>"+"</td>");
					out.print("<td>"+"<a href='de?id="+i.getId()+"'>Delete</a>"+"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
