package fpt.model.bean;

import java.util.Date;

public class NhapXuat {
	private int maNhapXuat;
	private Date ngayNhap;
	private Date ngayXuat;
	private int soLuong;
	private int donGia;
	private String maNguyenLieu;
	public NhapXuat(int maNhapXuat, Date ngayNhap, Date ngayXuat, int soLuong,
			int donGia, String maNguyenLieu) {
		super();
		this.maNhapXuat = maNhapXuat;
		this.ngayNhap = ngayNhap;
		this.ngayXuat = ngayXuat;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.maNguyenLieu = maNguyenLieu;
	}
	public int getMaNhapXuat() {
		return maNhapXuat;
	}
	public void setMaNhapXuat(int maNhapXuat) {
		this.maNhapXuat = maNhapXuat;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public Date getNgayXuat() {
		return ngayXuat;
	}
	public void setNgayXuat(Date ngayXuat) {
		this.ngayXuat = ngayXuat;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public String getMaNguyenLieu() {
		return maNguyenLieu;
	}
	public void setMaNguyenLieu(String maNguyenLieu) {
		this.maNguyenLieu = maNguyenLieu;
	}
	
}
