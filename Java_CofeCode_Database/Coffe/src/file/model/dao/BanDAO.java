package fpt.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import fpt.model.bean.Ban;

/***
 * 
 * @author vTr
 *
 */
public class BanDAO extends _BaseDAO{
	
	/**
	 * 
	 * @param maMon
	 * @return
	 */
	public boolean checkID(String maBan){
		rs = getQuery("Select * from BAN Where MaBan='" + maBan +"'" );

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
	 * @param maBan
	 * @return
	 */
	public Ban getBan(String maBan) {
		try {
			rs = getQuery("SELECT * FROM BAN WHERE MaBan = '" + maBan + "'");
			if(rs.next()){
				return new Ban(rs.getString("MaBan"), rs.getString("TenBan"), rs.getString("TrangThai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/***
	 * getList Bàn
	 * @return
	 */
	public ArrayList<Ban> getListBan() {
		ArrayList<Ban> arrBan = new ArrayList<>();
		try {
			rs = getTable("Ban");
			while(rs.next()){
				String maBan = rs.getString("MaBan");
				String tenBan = rs.getString("TenBan");
				String trangThai = rs.getString("TrangThai");
				arrBan.add(new Ban(maBan, tenBan, trangThai));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrBan;
	}
	/**
	 * 
	 * @param status
	 * @param maBan
	 * @return
	 */
	public int updateStatus(String status, String maBan){
		return updateQuery("UPDATE dbo.Ban SET TrangThai = N'"+ status + "' WHERE MaBan ='" + maBan +"'");
	}
	
	/**
	 * 
	 * @param ban
	 * @return
	 */
	public int addBan(Ban ban){
		String sql = "INSERT INTO dbo.Ban (MaBan, TenBan, TrangThai) VALUES  (?,?,?)";
		
		try {
			pstm = getConnection().prepareStatement(sql);
			pstm.setString(1, ban.getMaBan());
			pstm.setString(2, ban.getTenBan());
			pstm.setString(3, ban.getTrangThai());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 
	 * @param ban
	 * @return
	 */
	public int updateBan(Ban ban){
		return updateQuery("UPDATE dbo.Ban SET TenBan = N'"+ban.getTenBan()+"' WHERE MaBan = '"+ ban.getMaBan()+"'");
	}
}
