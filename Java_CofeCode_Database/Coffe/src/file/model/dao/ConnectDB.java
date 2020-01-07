package fpt.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {//_BaseDAO
	Connection connect = null;
	public Connection getConnect(){
		try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String host = "jdbc:sqlserver://DESKTOP-K4AMI6P\\VTR;databaseName=QLCafe_FPT;";
		String user = "sa";
		String pass = "123";
		connect = DriverManager.getConnection(host, user, pass);
		} catch (ClassNotFoundException e) {
			System.err.println("classForname error: ");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Error Connect SQL");
			e.printStackTrace();
		}
		return connect; 
	}
}
