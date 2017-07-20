package br.com.ecommerce.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException{
		try {
			   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} 
		catch (ClassNotFoundException ex){ }
		
		String server = "localhost";
		String database = "test";
				
		String url = "jdbc:mysql://" + server + "/" + database;
		String user = "root";
		String senha = "fiap";

		Connection conn = DriverManager.getConnection(url, user, senha);

		return conn;
	}
}
