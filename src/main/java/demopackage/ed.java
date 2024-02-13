package demopackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ed")
public class ed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\r\n"
				);
//		out.print("<marquee width='100%' style='color:red; '>" + "UPDATE DATA" +"</marquee>");
		String sid = request.getParameter("id");
		int iid = Integer.parseInt(sid);
//		out.print(iid);
		try {
			Employee e = Connectionsql.getEmpByname(iid);
			out.print("<div style='position: absolute;"
					+ "top: 50%;"
					+ "left: 50%;"
					+ "transform: translate(-50%, -50%);"
					+ "height: 500px;"
					+ "width: 500px;'>");
			out.print("<marquee width='100%' behavior='alternate' style='color:red;font-weight:bold;'>" + "UPDATE DATA" +"</marquee>");
			out.print("<form action='ed2' method='post'>");
				out.print("<input type='hidden' name='id' value='"+e.getId()+"'>" + "<br>");
				out.print("Enter your name : " + "<input type='text' class='form-control' name='name' value='"+e.getName()+"'>" + "<br>");
				out.print("Enter your pwd :" + "<input type='password' class='form-control' name='pwd' value='"+e.getPassword()+"'>" + "<br>");
				out.print("Enter your email :" + "<input type='email' class='form-control' name='email' value='"+e.getEmailid()+"'>" + "<br>");
				out.print("Enter your country :" + "<input type='text' class='form-control' name='cnty' value='"+e.getCountry()+"'>" + "<br>");
				out.print("<button type='submit' class='btn btn-primary'>" + "UPDATE" +"</button>");
			out.print("</form>");
			out.print("</div>");
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
