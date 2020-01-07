package fpt.model.bo;
import java.util.ArrayList;

import fpt.model.bean.ThietBi;
import fpt.model.dao.ThietBiDAO;

public class ThietBiBO {
	ThietBiDAO ThietbiDAO = new ThietBiDAO();

	public ArrayList<ThietBi> getListThietBi() {
		return ThietbiDAO.getListThietBi();
	}




	public void XoaThietBi(String maThietBi) {
		ThietbiDAO.XoaThietBi(maThietBi);
		
	}


	public void chinhsuathietbi(String maThietBi, String tenThietBi, int soLuong, String ngayNhap, int donGia) {
		ThietbiDAO.chinhsuathietbi(maThietBi,tenThietBi,soLuong,ngayNhap,donGia);
		
	}
	public void Themthietbi(String maThietBi, String tenThietBi, int soLuong, String ngayNhap, int donGia) {
		ThietbiDAO.Themthietbi(maThietBi,tenThietBi,soLuong,ngayNhap,donGia);
		
	}


	public ThietBi getThietBi(String maThietBi) {
		return ThietbiDAO.getThietBi(maThietBi);
	}




}
