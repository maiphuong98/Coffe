package fpt.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import fpt.model.bean.ThucDon;
/***
 * 
 * @author vTr
 *
 */
public class ThucDonDAO extends _BaseDAO{

	/**
	 * Nếu trùng mã
	 * @param maMon
	 * @return true
	 */
	public boolean checkID(String maMon){
		rs = getQuery("Select * from ThucDon Where MaMon='" + maMon +"'" );

		try {
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 
	 * @param maMon
	 * @return
	 */
	public ThucDon getThucDon(String maMon){
		rs = getQuery("Select * from ThucDon Where MaMon='" + maMon +"'" );

		try {
			if(rs.next())
				return new ThucDon(rs.getString("maMon"), rs.getString("tenMon"), rs.getLong("gia"), rs.getString("donViTinh"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param thucDon
	 * @return
	 */
	public int updateThucDon(ThucDon thucDon){
		return updateQuery("Update from ThucDon set TenMon = '" 
				+ thucDon.getTenMon() + "',Gia = " +thucDon.getGia()+ ",DonViTinh = '"
				+ thucDon.getDonViTinh() +"' where MaMon = '"+thucDon.getMaMon()+"'");
	}
	/**
	 * 
	 * @param maMon
	 * @return
	 */
	public int deleteThucDon(String maMon){
		return updateQuery("DELETE FROM THUCDON WHERE MaMon = '" + maMon +"'");
	}
	/**
	 * 
	 * @param thucDon
	 * @return
	 */
	public int addThucDon(ThucDon thucDon){
		String sql = "INSERT INTO dbo.ThucDon (MaMon, TenMon, Gia, DonViTinh) VALUES  (?,?,?,?)";

		try {
			pstm = getConnection().prepareStatement(sql);
			pstm.setString(1, thucDon.getMaMon());
			pstm.setString(2, thucDon.getTenMon());
			pstm.setLong(3, thucDon.getGia());
			pstm.setString(4, thucDon.getDonViTinh());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	/***
	 * 
	 * @return
	 */
	public ArrayList<ThucDon> getListThucDon() {
		ArrayList<ThucDon> arrBan = new ArrayList<>();
		try {
			rs = getTable("ThucDon");
			while(rs.next()){
				String maMon = rs.getString("MaMon");
				String tenMon = rs.getString("TenMon");
				long gia = Long.parseLong(rs.getString("Gia"));
				String donViTinh = rs.getString("DonViTinh");
				arrBan.add(new ThucDon(maMon, tenMon, gia, donViTinh));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrBan;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public ArrayList<ThucDon> getListThucDon(String key) {
		ArrayList<ThucDon> arrBan = new ArrayList<>();
		try {
			rs = getQuery("SELECT * FROM dbo.ThucDon WHERE TenMon LIKE N'%"+ key +"%'");
			while(rs.next()){
				String maMon = rs.getString("MaMon");
				String tenMon = rs.getString("TenMon");
				long gia = Long.parseLong(rs.getString("Gia"));
				String donViTinh = rs.getString("DonViTinh");
				arrBan.add(new ThucDon(maMon, tenMon, gia, donViTinh));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrBan;
	}
	//	public static void main(String[] args) {
	//		for(ThucDon thucDon : new ThucDonDAO().getListThucDon())
	//			System.out.println(thucDon.getTenMon());
	//	}
}
