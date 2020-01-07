package fpt.model.bo;

import java.util.ArrayList;

import fpt.model.bean.HangBanChay;
import fpt.model.bean.HoaDon;
import fpt.model.bean.NhapXuat;
import fpt.model.dao.ThongKeBaoCaoDAO;

public class ThongKeBaoCaoBO {

	ThongKeBaoCaoDAO thongKeBaoCaoDAO = new ThongKeBaoCaoDAO();

	public ArrayList<NhapXuat> xemThongKeBaoCaoNhapXuat(String ngayBatDau,
			String ngayKetThuc) {
		return thongKeBaoCaoDAO.xemThongKeBaoCaoNhapXuat(ngayBatDau,ngayKetThuc);
	}

	public ArrayList<HoaDon> xemThongKeBaoCaoHoaDon(String ngayBatDau,
			String ngayKetThuc) {
		return thongKeBaoCaoDAO.xemThongKeBaoCaoHoaDon(ngayBatDau,ngayKetThuc);
	}

	public int tongthu(String ngayBatDau, String ngayKetThuc) {
		return thongKeBaoCaoDAO.tongthu(ngayBatDau,ngayKetThuc);
	}

	public int tongchi(String ngayBatDau, String ngayKetThuc) {
		return thongKeBaoCaoDAO.tongchi(ngayBatDau,ngayKetThuc);
	}

	public void xuatFileExcel(String string, ArrayList<HoaDon> arrHoaDon) {
		thongKeBaoCaoDAO.xuatFileExcel(string, arrHoaDon);
		
	}

	public ArrayList<HangBanChay> xemThongKeBaoCaoHangBanChay(
			String ngayBatDau, String ngayKetThuc) {
		return thongKeBaoCaoDAO.xemThongKeBaoCaoHangBanChay(ngayBatDau,ngayKetThuc);
	}


}
