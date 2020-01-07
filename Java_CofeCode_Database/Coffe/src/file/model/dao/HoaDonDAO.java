package fpt.model.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import fpt.model.bean.ChiTietHoaDon;
import fpt.model.bean.HoaDon;
import fpt.model.bean.MatHangBanChay;

/**
 * Hóa ĐƠn DAO _ CTHD DAO
 * @author vTr
 *
 */
public class HoaDonDAO extends _BaseDAO{
	
	/**
	 * 
	 * @param maHD
	 * @param maBan
	 * @return
	 */
	public int chuyenBanHoaDon(long maHD, String maBan){
		return updateQuery("UPDATE dbo.HoaDon SET MaBan = '"+ maBan +"' WHERE MaHD =" + maHD);
	}
	/**
	 * Thêm mới một hóa đơn
	 * @param hoaDon
	 * @return true ? 1 : 0
	 */
	public int addHoaDon(HoaDon hoaDon){
		String sql = "INSERT INTO dbo.HoaDon (MaNV, MaBan, NgayBan, DaTraTien, ThanhTien) VALUES  (?,?,?,?,?)";
		
		try {
			pstm = getConnection().prepareStatement(sql);
			pstm.setString(1, hoaDon.getMaNV());
			pstm.setString(2, hoaDon.getMaBan());
			
			pstm.setTimestamp(3, new Timestamp(hoaDon.getNgayBan().getTime()));
			pstm.setBoolean(4, hoaDon.getDaTraTien());
			pstm.setLong(5, hoaDon.getThanhTien());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	/***
	 * Thêm mới 1 chi tiết hóa đơn
	 * @param chiTietHoaDon
	 * @return
	 */
	public int addCTHD(ChiTietHoaDon chiTietHoaDon){
		String sql = "INSERT INTO dbo.ChiTietHoaDon (SoLuongMua, MaHD, MaMon) VALUES  (?,?,?)";
		
		try {
			pstm = getConnection().prepareStatement(sql);
			pstm.setLong(1, chiTietHoaDon.getSoLuongMua());
			pstm.setLong(2, chiTietHoaDon.getMaHD());
			pstm.setString(3, chiTietHoaDon.getMaMon());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Lấy 1 cái hóa đơn theo mã bàn (chưa trả tiền)
	 * @param maBan
	 * @return
	 */
	public HoaDon getHoaDon(String maBan){
		rs = getQuery("Select * from HoaDon Where MaBan='" + maBan +"' AND daTraTien = 0" );
		
		try {
			if(rs.next())
				return new HoaDon(rs.getLong("maHD"), rs.getString("maNV"), rs.getString("maBan"), 
						rs.getTimestamp("ngayBan"), rs.getBoolean("daTraTien"), rs.getLong("thanhTien"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	
	/**
	 * Lấy list chi tiết hóa đơn theo maHD(có tên món)
	 * @param maHD
	 * @return
	 */
	public ArrayList<ChiTietHoaDon> getListChiTietHoaDon(long maHD){
		rs = getQuery("SELECT MaCTHD,SoLuongMua,MaHD,ChiTietHoaDon.MaMon,TenMon,Gia FROM dbo.ChiTietHoaDon "
				+ "JOIN dbo.ThucDon ON ThucDon.MaMon = ChiTietHoaDon.MaMon WHERE MaHD = "+ maHD);
		ArrayList<ChiTietHoaDon> lst = new ArrayList<ChiTietHoaDon>();
		try {
			while(rs.next())
				lst.add(new ChiTietHoaDon(rs.getLong("maCTHD"), rs.getLong("soLuongMua"), rs.getLong("maHD"), rs.getString("maMon"), rs.getString("tenMon"), rs.getLong("Gia")));
			return lst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Chuyển daTraTien sang 1 cho hóa đơn
	 * @param maHD
	 * @return
	 */
	public int thanhToan(long maHD){
		ArrayList<ChiTietHoaDon> arr = getListChiTietHoaDon(maHD);
		long tongTien = 0;
		for(ChiTietHoaDon chiTietHoaDon : arr)
			tongTien += (chiTietHoaDon.getGia()*chiTietHoaDon.getSoLuongMua());
		return updateQuery("UPDATE dbo.HoaDon SET DaTraTien = 1, NgayBan = '"+ new Timestamp(new Date().getTime()) +"', ThanhTien = " + tongTien + " WHERE MaHD =" + maHD);
	}
	
	/**
	 * 
	 * @param maChiTietHoaDon
	 * @param soLuong
	 * @return
	 */
	public int updateSoLuongChiTietHoaDon(long maChiTietHoaDon,long soLuong){
		return updateQuery(" UPDATE dbo.ChiTietHoaDon SET SoLuongMua = " + soLuong +  " WHERE MaCTHD = " + maChiTietHoaDon);
	}
	
	/**
	 * 
	 * @param chiTietHoaDon
	 * @return
	 */
	public int updateCTHD(ChiTietHoaDon chiTietHoaDon){
		return updateQuery(" UPDATE dbo.ChiTietHoaDon SET SoLuongMua = " + chiTietHoaDon.getSoLuongMua() + ", MaHD = " + chiTietHoaDon.getMaHD() +
				 " WHERE MaCTHD = " + chiTietHoaDon.getMaCTHD());
	}
	
	/***
	 * Kiểm trA hoa đơn bàn đó đã chọn món đo chưa
	 * 
	 * @param maHD
	 * @param maMon
	 * @return ChiTietHoaDon
	 */
	public ChiTietHoaDon getChiTietHoaDon(long maHD, String maMon) {
		rs = getQuery("SELECT MaCTHD,SoLuongMua,MaHD,ChiTietHoaDon.MaMon,TenMon,Gia FROM dbo.ChiTietHoaDon "
				+ "JOIN dbo.ThucDon ON ThucDon.MaMon = ChiTietHoaDon.MaMon WHERE MaHD = "+ maHD + "MaMon = '" + maMon +"'");
		try {
			if(rs.next())
				return new ChiTietHoaDon(rs.getLong("maCTHD"), rs.getLong("soLuongMua"), rs.getLong("maHD"), rs.getString("maMon"), rs.getString("tenMon"), rs.getLong("Gia"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param maCTHD
	 * @return
	 */
	public ChiTietHoaDon getChiTietHoaDonByID(long maCTHD) {
		rs = getQuery("SELECT MaCTHD,SoLuongMua,MaHD,ChiTietHoaDon.MaMon,TenMon,Gia FROM dbo.ChiTietHoaDon "
				+ "JOIN dbo.ThucDon ON ThucDon.MaMon = ChiTietHoaDon.MaMon WHERE MaCTHD = "+ maCTHD);
		try {
			if(rs.next())
				return new ChiTietHoaDon(rs.getLong("maCTHD"), rs.getLong("soLuongMua"), rs.getLong("maHD"), rs.getString("maMon"), rs.getString("tenMon"), rs.getLong("Gia"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Xóa 1 chi tiết hóa đơn
	 * @param maChiTietHoaDon
	 * @return
	 */
	public int deleteChiTietHoaDon(long maChiTietHoaDon){
		return updateQuery("DELETE FROM dbo.ChiTietHoaDon WHERE MaCTHD = " + maChiTietHoaDon);
	}
	
	/**
	 * 
	 * @param maHD
	 * @return
	 */
	public int deleteHoaDon(long maHD){
		return updateQuery("DELETE FROM dbo.HoaDon WHERE MaHD = " + maHD);
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<HoaDon> selectTop10(){
		rs = getQuery("SELECT TOP 10 * FROM dbo.HoaDon WHERE DaTraTien = 1 ORDER BY NgayBan DESC");
		ArrayList<HoaDon> lst = new ArrayList<HoaDon>();
		try {
			while(rs.next())
				lst.add(new HoaDon(rs.getLong("maHD"), rs.getString("maNV"), rs.getString("maBan"), 
						rs.getTimestamp("ngayBan"), rs.getBoolean("daTraTien"), rs.getLong("thanhTien")));
			return lst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public ArrayList<HoaDon> selectHoaDonByDate(String date){
		rs = getQuery("SELECT * FROM dbo.HoaDon WHERE DaTraTien = 1 AND DAY(NgayBan)=DAY('"
					+ date +"') AND MONTH(NgayBan) = MONTH('"
					+ date +"') AND YEAR(NgayBan) = YEAR('"+date+"')");
		ArrayList<HoaDon> lst = new ArrayList<HoaDon>();
		try {
			while(rs.next())
				lst.add(new HoaDon(rs.getLong("maHD"), rs.getString("maNV"), rs.getString("maBan"), 
						rs.getTimestamp("ngayBan"), rs.getBoolean("daTraTien"), rs.getLong("thanhTien")));
			return lst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param date
	 * @return
	 */
	public ArrayList<HoaDon> selectHoaDonByMonth(String date){
		rs = getQuery("SELECT * FROM dbo.HoaDon WHERE DaTraTien = 1 AND MONTH(NgayBan) = MONTH('"
					+ date +"') AND YEAR(NgayBan) = YEAR('"+date+"')");
		ArrayList<HoaDon> lst = new ArrayList<HoaDon>();
		try {
			while(rs.next())
				lst.add(new HoaDon(rs.getLong("maHD"), rs.getString("maNV"), rs.getString("maBan"), 
						rs.getTimestamp("ngayBan"), rs.getBoolean("daTraTien"), rs.getLong("thanhTien")));
			return lst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Lấy 10 mặt hàng bán chạy trong tháng, theo doanh thu
	 * @return
	 */
	public ArrayList<MatHangBanChay> getTop10MatHang(int thang){
		rs = getQuery("SELECT  TOP 10 ChiTietHoaDon.MaMon,TenMon, SUM(SoLuongMua*Gia) AS TongTien FROM dbo.ThucDon "
				+ "JOIN dbo.ChiTietHoaDon ON ChiTietHoaDon.MaMon = ThucDon.MaMon "
				+ "JOIN dbo.HoaDon ON HoaDon.MaHD = ChiTietHoaDon.MaHD WHERE DaTraTien = 1 "
				+ "AND MONTH(NgayBan) = " + thang +" GROUP BY dbo.ChiTietHoaDon.MaMon,TenMon ORDER BY TongTien DESC");
		ArrayList<MatHangBanChay> lst = new ArrayList<MatHangBanChay>();
		try {
			while(rs.next())
				lst.add(new MatHangBanChay(rs.getString("maMon"), rs.getString("tenMon"), rs.getLong("tongTien")));
			return lst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Lấy 10 mặt hàng bán chạy trong tháng, theo số lượng
	 * 
	 * cột tổng tiền là tổng số lượng
	 * @return ArrayList<MatHangBanChay>  
	 */
	public ArrayList<MatHangBanChay> getTop10MatHangTheoSoLuong(int thang){
		rs = getQuery("SELECT  TOP 10 ChiTietHoaDon.MaMon,TenMon, SUM(SoLuongMua) AS TongTien FROM dbo.ThucDon "
				+ "JOIN dbo.ChiTietHoaDon ON ChiTietHoaDon.MaMon = ThucDon.MaMon "
				+ "JOIN dbo.HoaDon ON HoaDon.MaHD = ChiTietHoaDon.MaHD WHERE DaTraTien = 1 "
				+ "AND MONTH(NgayBan) = " + thang +" GROUP BY dbo.ChiTietHoaDon.MaMon,TenMon ORDER BY TongTien DESC");
		ArrayList<MatHangBanChay> lst = new ArrayList<MatHangBanChay>();
		try {
			while(rs.next())
				lst.add(new MatHangBanChay(rs.getString("maMon"), rs.getString("tenMon"), rs.getLong("tongTien")));
			return lst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

