package RentalMan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registercaddr")
public class Register extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carrental", "postgres",
					"root");
			int carid = Integer.parseInt(req.getParameter("carid"));
			String carname = req.getParameter("carname");
			String carmodel = req.getParameter("carmodel");
			int carnumber = Integer.parseInt(req.getParameter("carnumber"));
			String ownername = req.getParameter("ownername");
			String status = "available";

			PreparedStatement pstmt = con.prepareStatement("Insert into car (carid,carmodel,carname,carnumber,ownername,status) values (?,?,?,?,?,?)");
			pstmt.setInt(1, carid);
			pstmt.setString(2, carmodel);
			pstmt.setString(3, carname);
			pstmt.setInt(4, carnumber);
			pstmt.setString(5, ownername);
			pstmt.setString(6, status);
			
			int upRows = pstmt.executeUpdate();
			
			System.out.println(upRows);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
