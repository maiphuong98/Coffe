package fpt.model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fpt.model.bean.ThietBi;


public class ThietBiDAO {

	_BaseDAO connect = new _BaseDAO();
	Statement stmt = null;
	ResultSet rs = null;
	
	private Date xuLyNgayThangNam(String str){
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		String[] temp = str.split("-");
		Date date = new Date(temp[1]+"/"+temp[2]+"/"+temp[0]);
		Date sqldate = java.sql.Date.valueOf(fm.format(date));
		return sqldate;
		
	}
	
	ArrayList<ThietBi> arrThietBi = new ArrayList<>();
	public ArrayList<ThietBi> getListThietBi() {
		try {
			stmt = connect.getConnection().createStatement();
			rs = stmt.executeQuery("Select * from ThietBi");
			while(rs.next()) {
				arrThietBi.add(new ThietBi(rs.getString("MaThietBi"), rs.getString("TenThietBi"), rs.getInt("SoLuong"), rs.getDate("NgayMua"), rs.getInt("DonGia")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrThietBi;
	}
	public static void main(String[] args) {
		ThietBiDAO t = new ThietBiDAO();
		ArrayList<ThietBi> arrThietBi = t.getListThietBi();
		
	}
	public void XoaThietBi(String maThietBi) {
		try {
			stmt = connect.getConnection().createStatement();
			stmt.executeUpdate("delete from ThietBi where MaThietBi='"+maThietBi+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void chinhsuathietbi(String maThietBi, String tenThietBi, int soLuong, String ngayNhap, int donGia) {
		try {
			stmt = connect.getConnection().createStatement();
			stmt.executeUpdate("update ThietBi set TenThietBi='"+tenThietBi+"',SoLuong='"+soLuong+"',NgayMua='"+xuLyNgayThangNam(ngayNhap)+"',DonGia='"+donGia+"'where MaThietBi='"+maThietBi+"' ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void Themthietbi(String maThietBi, String tenThietBi, int soLuong, String ngayNhap, int donGia) {
		try {
			String sqlAdd = "insert into ThietBi values('"+maThietBi+"',N'"+tenThietBi+"','"+soLuong+"','"+xuLyNgayThangNam(ngayNhap)+"','"+donGia+"')";
			stmt = connect.getConnection().createStatement();
			stmt.executeUpdate(sqlAdd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ThietBi getThietBi(String maThietBi) {
		try {
			stmt = connect.getConnection().createStatement();
			rs = stmt.executeQuery("Select * from ThietBi where MaThietBi='"+maThietBi+"'");
			while(rs.next()) {
				return new ThietBi(rs.getString("MaThietBi"), rs.getString("TenThietBi"), rs.getInt("SoLuong"), rs.getDate("NgayMua"), rs.getInt("DonGia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
