package webPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/AddNewUser")
public class AddNewUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking_System","root","Hema2728@2024");
			String sql = "insert into userDetails (name, password) values(?, ?)" ;
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userName);
			stmt.setString(2, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}

}
