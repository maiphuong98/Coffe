package fpt.model.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import fpt.model.bean.HangBanChay;
import fpt.model.bean.HoaDon;
import fpt.model.bean.NhapXuat;

public class ThongKeBaoCaoDAO {

	ConnectDB connect = new ConnectDB();
	Statement stmt = null;
	ResultSet rs = null;
	
	ArrayList<NhapXuat> arrNhapXuat = new ArrayList<>();
	ArrayList<HoaDon> arrHoaDon = new ArrayList<>();
	ArrayList<HangBanChay> arrHangBanChay = new ArrayList<>();
	
	private Date xuLyNgayThangNam(String str){
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		String[] temp = str.split("-");
		Date date = new Date(temp[1]+"/"+temp[2]+"/"+temp[0]);
		Date sqldate = java.sql.Date.valueOf(fm.format(date));
		return sqldate;
		
	}
	
	
	
	public ArrayList<NhapXuat> xemThongKeBaoCaoNhapXuat(String ngayBatDau,
			String ngayKetThuc) {
		try {
			stmt = connect.getConnect().createStatement();
			rs = stmt.executeQuery("Select * from XuatNhap where NgayNhap >= '"+xuLyNgayThangNam(ngayBatDau)+"' and NgayNhap <= '"+xuLyNgayThangNam(ngayKetThuc)+"'");
			while(rs.next()){
				arrNhapXuat.add(new NhapXuat(rs.getInt("MaXuatNhap"), rs.getDate("NgayNhap"), rs.getDate("NgayXuat"), rs.getInt("SoLuong"), rs.getInt("DonGia"), rs.getString("MaNguyenLieu")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrNhapXuat;
	}

	public ArrayList<HoaDon> xemThongKeBaoCaoHoaDon(String ngayBatDau,
			String ngayKetThuc) {
		try {
			stmt = connect.getConnect().createStatement();
			rs = stmt.executeQuery("Select * from HoaDon where NgayBan >= '"+xuLyNgayThangNam(ngayBatDau)+"' and NgayBan <= '"+xuLyNgayThangNam(ngayKetThuc)+"' and DaTraTien = 1");
			while(rs.next()){
				arrHoaDon.add(new HoaDon(rs.getLong("maHD"), rs.getString("maNV"), rs.getString("maBan"), 
						rs.getTimestamp("ngayBan"), rs.getBoolean("daTraTien"), rs.getLong("thanhTien")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrHoaDon;
	}
	
	public int tongthu(String ngayBatDau, String ngayKetThuc) {
		int tongthu = 0;
		try {
			stmt = connect.getConnect().createStatement();
			rs = stmt.executeQuery("Select SUM(ThanhTien) as ThanhTien from HoaDon where NgayBan >= '"+xuLyNgayThangNam(ngayBatDau)+"' and NgayBan <= '"+xuLyNgayThangNam(ngayKetThuc)+"'");
			while(rs.next()){
				tongthu = rs.getInt("ThanhTien");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tongthu;
	}
	
	public int tongchi(String ngayBatDau, String ngayKetThuc) {
		int tongchi = 0;
		try {
			stmt = connect.getConnect().createStatement();
			rs = stmt.executeQuery("Select SUM(SoLuong*DonGia) as ThanhTien from XuatNhap where NgayNhap >= '"+xuLyNgayThangNam(ngayBatDau)+"' and NgayNhap <= '"+xuLyNgayThangNam(ngayKetThuc)+"'");
			while(rs.next()){
				tongchi = rs.getInt("ThanhTien");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tongchi;
	}
	
	public void xuatFileExcel(String string, ArrayList<HoaDon> arrHoaDon2) {
		if("excel".equals(string)){
			try {
				FileWriter out = new FileWriter("ThongKeHoaDon.csv");
				for(int i = 0; i < arrHoaDon2.size(); i++){
					String line = arrHoaDon2.get(i).getMaHD()+","+arrHoaDon2.get(i).getMaNV()+","+arrHoaDon2.get(i).getMaBan()+","+arrHoaDon2.get(i).getNgayBan()+","+arrHoaDon2.get(i).getThanhTien();
					out.write(line);
					out.write("\n");
				}
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
//	public static void main(String[] args) {
//		ThongKeBaoCaoDAO t = new ThongKeBaoCaoDAO();
//		ArrayList<HoaDon> arrHoaDon2 = new ArrayList<>();
//		arrHoaDon2.add(new HoaDon(1, "NV1", "MB1", new Date("8/20/2014"), 30000));
//		arrHoaDon2.add(new HoaDon(2, "NV2", "MB2", new Date("8/22/2014"), 32000));
//		t.xuatFileExcel("excel", arrHoaDon2);
//		ArrayList<HangBanChay> arrHangBanChay = t.xemThongKeBaoCaoHangBanChay("1-1-2016", "1-1-2018");
//		for(int i =0; i< arrHangBanChay.size();i++){
//			System.out.println(arrHangBanChay.get(i).getTenMon());
//		}
//		
//		System.out.println(t.xuLyNgayThangNam("2017-01-23"));
//	}
	public ArrayList<HangBanChay> xemThongKeBaoCaoHangBanChay(
			String ngayBatDau, String ngayKetThuc) {
		try {
			String sqlSelect = "select ThucDon.TenMon,HoaDon.NgayBan, SUM(ChiTietHoaDon.SoLuongMua) as SoLuongMua "
								+"from HoaDon left join ChiTietHoaDon "
												+"on HoaDon.MaHD = ChiTietHoaDon.MaHD "
												+"left join ThucDon "
												+"on ChiTietHoaDon.MaMon = ThucDon.MaMon "
								+"group by ThucDon.TenMon, HoaDon.NgayBan "
								+"having HoaDon.NgayBan >= '"+xuLyNgayThangNam(ngayBatDau)+"' and HoaDon.NgayBan <= '"+xuLyNgayThangNam(ngayKetThuc)+"'";
			stmt = connect.getConnect().createStatement();
			rs = stmt.executeQuery(sqlSelect);
			while(rs.next()){
				arrHangBanChay.add(new HangBanChay(rs.getString("TenMon"), rs.getDate("NgayBan"), rs.getInt("SoLuongMua")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrHangBanChay;
	}
	
}
