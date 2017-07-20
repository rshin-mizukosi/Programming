package br.com.ecommerce.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String conURL = "jdbc:sqlserver://localhost:1433;databaseName=ECommerce;integratedSecurity=true;";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			   con = DriverManager.getConnection(conURL);
			   String sql = "SELECT * FROM Produtos";
			   stmt = con.createStatement();
			   rs = stmt.executeQuery(sql);
			   
			   while(rs.next()) {
				   System.out.println(rs.getString(2));
			   }
		} catch (Exception ex){ }
	}

}
