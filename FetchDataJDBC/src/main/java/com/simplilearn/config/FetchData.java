package com.simplilearn.config;

import java.sql.Statement;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchData
 */
@WebServlet("/fetch")
public class FetchData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Properties props=new Properties();
		InputStream in= getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		props.load(in);
		Connection conn= DBConfig.getConnect(props);
		
		if(conn!=null)
		{
			try {
				Statement stmt= conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from eproduct");
				out.print("<h1>Product List</h1><hr>");
				while(rs.next())
				{
					out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getBigDecimal(3)+" "+rs.getTimestamp(4)+"<br><br>");
				}	
			} catch (SQLException e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			out.print("Error while connecting with DB");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
