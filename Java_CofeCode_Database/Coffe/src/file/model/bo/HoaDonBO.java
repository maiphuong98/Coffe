package fpt.model.bo;

import java.util.ArrayList;

import fpt.model.bean.ChiTietHoaDon;
import fpt.model.bean.HoaDon;
import fpt.model.bean.MatHangBanChay;
import fpt.model.dao.HoaDonDAO;

/***
 * 
 * @author vTr
 *
 */
public class HoaDonBO {
	HoaDonDAO hoaDonDAO = new HoaDonDAO();
	/**
	 * 
	 * @param maHD
	 * @param maBan
	 * @return
	 */
	public int chuyenBanHoaDon(long maHD, String maBan){
		return hoaDonDAO.chuyenBanHoaDon(maHD, maBan);
	}
	/***
	 * 
	 * @param hoaDon
	 * @return
	 */
	public int addHoaDon(HoaDon hoaDon){
		return hoaDonDAO.addHoaDon(hoaDon);
	}
	/***
	 * 
	 * @param chiTietHoaDon
	 * @return
	 */
	public int addCTHD(ChiTietHoaDon chiTietHoaDon){
		return hoaDonDAO.addCTHD(chiTietHoaDon);
	}

	public int updateCTHD(ChiTietHoaDon chiTietHoaDon){

		return hoaDonDAO.updateCTHD(chiTietHoaDon);
	}
	/**
	 * 
	 * @param chiTietHoaDon
	 * @return
	 */
	public int updateSoLuongChiTietHoaDon(long maChiTietHoaDon,long soLuong){
		return hoaDonDAO.updateSoLuongChiTietHoaDon(maChiTietHoaDon, soLuong);
	}

	/**
	 * Kiểm tra hóa đơn đó đã có chọn món đó hay chưa
	 * @param maHD
	 * @param maMon
	 * @return true nếu có rồi
	 */
	public ChiTietHoaDon getChiTietHoaDon(long maHD, String maMon){
		return hoaDonDAO.getChiTietHoaDon(maHD, maMon);
	}
	/**
	 * 
	 * @param maBan
	 * @return
	 */
	public HoaDon getHoaDon(String maBan){
		return hoaDonDAO.getHoaDon(maBan);
	}

	/**
	 * 
	 * @param maHD
	 * @return
	 */
	public ArrayList<ChiTietHoaDon> getListChiTietHoaDon(long maHD){
		return hoaDonDAO.getListChiTietHoaDon(maHD);
	}

	/**
	 * 
	 * @param maHD
	 * @return
	 */
	public int thanhToan(long maHD){
		return hoaDonDAO.thanhToan(maHD);
	}

	/**
	 * 
	 * @param maChiTietHoaDon
	 * @return
	 */
	public int deleteChiTietHoaDon(long maChiTietHoaDon){
		return hoaDonDAO.deleteChiTietHoaDon(maChiTietHoaDon);
	}

	/**
	 * 
	 * @param maHD
	 * @return
	 */
	public int deleteHoaDon(long maHD){
		return hoaDonDAO.deleteHoaDon(maHD);
	}
	/**
	 * 
	 * @param maCTHD
	 * @return
	 */
	public ChiTietHoaDon getChiTietHoaDonByID(long maCTHD) {
		return hoaDonDAO.getChiTietHoaDonByID(maCTHD);
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<HoaDon> selectTop10(){
		return hoaDonDAO.selectTop10();
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public ArrayList<HoaDon> selectHoaDonByDate(String date){
		return hoaDonDAO.selectHoaDonByDate(date);
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<MatHangBanChay> getTop10MatHang(int thang){
		return hoaDonDAO.getTop10MatHang(thang);
	}
	/**
	 * 
	 * @param thang
	 * @return
	 */
	public ArrayList<MatHangBanChay> getTop10MatHangTheoSoLuong(int thang){
		return hoaDonDAO.getTop10MatHangTheoSoLuong(thang);
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public ArrayList<HoaDon> selectHoaDonByMonth(String date){
		return hoaDonDAO.selectHoaDonByMonth(date);
	}
}

