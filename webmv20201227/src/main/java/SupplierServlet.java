
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/SupplierServlet")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SupplierServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = null;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/classicmodels?serverTimezone=CST&useUnicode=true&characterEncoding=utf8", "root", "1234");
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet SelectSupplier</title>");
			out.println("</head>");
			out.println("<body>");
			viewTable(conn, out);
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			out.close();
		}
	}

	public void viewTable(Connection con, PrintWriter out) throws SQLException {
		Statement stmt = null;
		String query = "select SUP_ID, SUP_NAME, STREET, CITY, STATE, ZIP from coffeedb.SUPPLIERS";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			out.println("<table border='1'>");
			while (rs.next()) {
				out.println("<tr><td>");
				int supplierID = rs.getInt("SUP_ID");
				out.println("" + supplierID);
				out.println("</td><td>");
				String supplierName = rs.getString("SUP_NAME");
				out.println("" + supplierName);
				out.println("</td><td>");
				String street = rs.getString("STREET");
				out.println("" + street);
				out.println("</td><td>");
				String city = rs.getString("CITY");
				out.println("" + city);
				out.println("</td><td>");
				String state = rs.getString("STATE");
				out.println("" + state);
				out.println("</td><td>");
				String zip = rs.getString("ZIP");
				out.println("" + zip);
				out.println("</td></tr>");
			}
			out.println("</table>");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
