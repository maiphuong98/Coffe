package fpt.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * CoSo
 * 
 * Version 1.0
 * 
 * Date 02-03-2018
 * 
 * Copyright
 * 
 * Modification Logs
 * DATE				AUTHOR			DESCRIPTION
 * ---------------------------------------
 * 02-03-2018		NhatNV			Create
 */
public class CoSo {
	public Connection cn;

	public void KetNoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager
					.getConnection("jdbc:sqlserver://DESKTOP-K4AMI6P\\VTR;databaseName=QLCafe_FPT;user=sa; password=123");
//			System.out.println("Connected to SQL Server!");
		} catch (Exception tt) {
			tt.printStackTrace();
		}
	}
}
