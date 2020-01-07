package fpt.model.bean;

import java.util.Date;

public class ThietBi {
	private String MaThietBi;
	private String TenThietBi;
	private int SoLuong;
	private Date NgayMua;
	private int DonGia;
	public String getMaThietBi() {
		return MaThietBi;
	}
	public void setMaThietBi(String maThietBi) {
		this.MaThietBi = maThietBi;
	}
	public String getTenThietBi() {
		return TenThietBi;
	}
	public void setTenThietBi(String tenThietBi) {
		this.TenThietBi = tenThietBi;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		this.SoLuong = soLuong;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		this.NgayMua = ngayMua;
	}
	public int getDonGia() {
		return DonGia;
	}
	public void setDonGia(int donGia) {
		this.DonGia = donGia;
	}
	
	public ThietBi(String maThietBi, String tenThietBi, int soLuong, Date ngayMua, int donGia) {
		super();
		this.MaThietBi = maThietBi;
		this.TenThietBi = tenThietBi;
		this.SoLuong = soLuong;
		this.NgayMua = ngayMua;
		this.DonGia = donGia;
	}
	public ThietBi() {
		super();
	}

}
