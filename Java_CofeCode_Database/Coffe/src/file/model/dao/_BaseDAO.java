package fpt.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author vTr
 *
 */
public class _BaseDAO {
	private final String DB_URL = "jdbc:sqlserver://DESKTOP-K4AMI6P\\VTR;databaseName=QLCafe_FPT;user=sa; password=123";
	//public Connection connection = null;
	public static PreparedStatement pstm = null;
	public static ResultSet rs = null;

	/**
	 * 
	 * @return
	 */
	protected Connection getConnection(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection(DB_URL);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param table
	 * @return
	 */
	protected ResultSet getTable(String table) {
		try {
			return getConnection().prepareStatement( "SELECT * FROM " + table).executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param query
	 * @return
	 */
	protected ResultSet getQuery(String query) {
		try {
			return getConnection().prepareStatement(query).executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param query
	 * @return
	 */
	protected int updateQuery(String query) {
		try {
			return getConnection().prepareStatement(query).executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
//	public static void main(String[] args) {
//		_BaseDAO b = new _BaseDAO();
//		if (b.getConnection()!=null) {
//			System.out.println("OK");
//		};
//		if (b.getTable("hoadon")!=null) {
//			System.out.println("OK");
//		};
//	}
}
