package fpt.model.bean;

import java.util.Date;

/**
 * Khuyến mãi bean
 * @author vTr
 *
 */
public class KhuyenMai {
	 private String maKhuyenMai;
	 private String tenKhuyenMai;
	 private Date ngayBatDau;
	 private Date ngayKetThuc;
	 private int giamGia;
	 private long maHD;
	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}
	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public int getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}
	public long getMaHD() {
		return maHD;
	}
	public void setMaHD(long maHD) {
		this.maHD = maHD;
	}
	/**
	 * 
	 * @param maKhuyenMai
	 * @param tenKhuyenMai
	 * @param ngayBatDau
	 * @param ngayKetThuc
	 * @param giamGia
	 * @param maHD
	 */
	public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, Date ngayBatDau, Date ngayKetThuc, int giamGia,
			long maHD) {
		super();
		this.maKhuyenMai = maKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.giamGia = giamGia;
		this.maHD = maHD;
	}
	public KhuyenMai() {
		super();
	}
	 
}
