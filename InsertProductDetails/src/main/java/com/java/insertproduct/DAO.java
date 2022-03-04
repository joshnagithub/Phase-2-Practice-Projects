package com.java.insertproduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.simplilearn.workshop.util.StringUtil;

public class DAO {
	public Connection con = null;
	public Statement st = null;

	public DAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "12345678");
		System.out.println("connection established with database");
		st = con.createStatement();
	}

	public boolean insertProducts(HashMap<String, String> product) throws SQLException {

		String query1 = "INSERT INTO product ( name, price, qty ) VALUES" + " ('"
				+ StringUtil.fixSqlFieldValue(product.get("name")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(product.get("price")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(product.get("qty")) + "')";


		try {
			st.execute(query1);
			return true;
		} catch (SQLException e) {
			System.out.print("Error in inserting");
			e.printStackTrace();
		}
		return false;
	}
}

