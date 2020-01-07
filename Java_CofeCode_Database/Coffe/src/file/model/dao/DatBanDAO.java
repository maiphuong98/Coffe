package fpt.model.dao;

import java.sql.SQLException;

import fpt.model.bean.ThongTinDatBan;


public class DatBanDAO extends _BaseDAO{
	
	/**
	 * Chuyển thông tin đặt bàn sang bàn khác
	 * @return
	 */
	public int chuyenThongTinDatBan(long maTTDB, String maBan){
		return updateQuery("UPDATE dbo.ThongTinDatBan SET MaBan = '"+ maBan +"' WHERE MaThongTinDatBan =" + maTTDB);
	}
	/**
	 * 
	 * @param thongTinDatBan
	 * @return
	 */
	public int addThongTinDatBan(ThongTinDatBan thongTinDatBan){
		String sql = "INSERT INTO dbo.ThongTinDatBan (TenKH, SDT, Ngay, Gio, MaBan) VALUES  (?,?,?,?,?)";
		
		try {
			pstm = getConnection().prepareStatement(sql);
			pstm.setString(1, thongTinDatBan.getTenKH());
			pstm.setString(2, thongTinDatBan.getSDT());
			pstm.setString(3, thongTinDatBan.getNgay());
			pstm.setString(4, thongTinDatBan.getGio());
			pstm.setString(5, thongTinDatBan.getMaBan());
			
			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 
	 * @param maBan
	 * @return
	 */
	public ThongTinDatBan getThongTinDatBan(String maBan){
		rs = getQuery("SELECT * FROM dbo.ThongTinDatBan WHERE MaBan = '" + maBan + "'");
		
		try {
			if(rs.next())
				return new ThongTinDatBan(rs.getLong("MaThongTinDatBan"), rs.getString("TenKH")
						, rs.getString("SDT"), rs.getString("Ngay"), rs.getString("Gio"), rs.getString("MaBan"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param maBan
	 * @return
	 */
	public int deleteThongTinDatBan(String maBan){
		return updateQuery("DELETE FROM dbo.ThongTinDatBan WHERE MaBan = '" + maBan + "'");
	}
	
}
