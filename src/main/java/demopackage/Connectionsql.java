package demopackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Connectionsql {
	public static Connection con() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/everyady","root","mgrs");
		return con;
	}
	
	public static int save(Employee e) throws ClassNotFoundException, SQLException {
		int x = 0;
		Connection con = Connectionsql.con();
		PreparedStatement ps = con.prepareStatement("insert into Employee(emp_name, emp_pwd, emp_email, emp_country) values(?, ?, ?, ?)");
		
		ps.setString(1, e.getName());
		ps.setString(2, e.getPassword());
		ps.setString(3, e.getEmailid());
		ps.setString(4, e.getCountry());
		
		x = ps.executeUpdate();
		
		return x;
	}
	
	public static Employee getEmpByname(int id) throws ClassNotFoundException, SQLException {
		Employee e = new Employee();
		
		Connection con = Connectionsql.con();
		PreparedStatement ps = con.prepareStatement("select * from employee where emp_id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPassword(rs.getString(3));
			e.setEmailid(rs.getString(4));
			e.setCountry(rs.getString(5));  
		}
		
		return e;
	}
	
	public static int update(Employee e) throws ClassNotFoundException, SQLException {
		int m = 0;
		Connection con = Connectionsql.con();
		PreparedStatement ps = con.prepareStatement("update employee set emp_name=?, emp_pwd=?, emp_email=?, emp_country=? where emp_id=?");
		ps.setString(1, e.getName());
		ps.setString(2, e.getPassword());
		ps.setString(3, e.getEmailid());
		ps.setString(4, e.getCountry());
		ps.setInt(5, e.getId());
		
		m = ps.executeUpdate();   
		return m;
	}
	
	public static int delete(int d) throws ClassNotFoundException, SQLException {
		int c = 0;
		Connection con = Connectionsql.con();
		PreparedStatement ps = con.prepareStatement("delete from employee where emp_id=?");
		ps.setInt(1, d);
		c = ps.executeUpdate();
		
		return c;
	}
	
	public static List<Employee> allEmp() throws ClassNotFoundException, SQLException{
		
		List<Employee> list = new ArrayList<>();
		
		Connection con = Connectionsql.con();
		PreparedStatement ps = con.prepareStatement("select * from Employee");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Employee emp = new Employee();
			emp.setId(rs.getInt("emp_id"));
			emp.setName(rs.getString("emp_name"));
			emp.setPassword(rs.getString("emp_pwd"));
			emp.setEmailid(rs.getString("emp_email"));
			emp.setCountry(rs.getString("emp_country"));
			list.add(emp);
		}
		
		return list;
	}


}
