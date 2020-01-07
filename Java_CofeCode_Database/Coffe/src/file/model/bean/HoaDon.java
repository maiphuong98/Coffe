package fpt.model.bean;

import java.util.Date;

/**
 * Hóa đơn bean
 * @author vTr
 *
 */
public class HoaDon {
	private long maHD;
	private String maNV;
	private String maBan;
	private Date ngayBan;
	private Boolean daTraTien;
	private long thanhTien;
	
	public long getMaHD() {
		return maHD;
	}
	public void setMaHD(long maHD) {
		this.maHD = maHD;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getMaBan() {
		return maBan;
	}
	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}
	public Date getNgayBan() {
		return ngayBan;
	}
	public void setNgayBan(Date ngayBan) {
		this.ngayBan = ngayBan;
	}
	public Boolean getDaTraTien() {
		return daTraTien;
	}
	public void setDaTraTien(Boolean daTraTien) {
		this.daTraTien = daTraTien;
	}
	public long getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(long thanhTien) {
		this.thanhTien = thanhTien;
	}
	
	/***
	 * 
	 * @param maNV
	 * @param maBan
	 * @param ngayBan
	 * @param daTraTien
	 * @param thanhTien
	 */
	public HoaDon(String maNV, String maBan, Date ngayBan, Boolean daTraTien, long thanhTien) {
		super();
		this.maNV = maNV;
		this.maBan = maBan;
		this.ngayBan = ngayBan;
		this.daTraTien = daTraTien;
		this.thanhTien = thanhTien;
	}
	
	
	/***
	 * 
	 * @param maHD
	 * @param maNV
	 * @param maBan
	 * @param ngayBan
	 * @param daTraTien
	 * @param thanhTien
	 */
	public HoaDon(long maHD, String maNV, String maBan, Date ngayBan, Boolean daTraTien, long thanhTien) {
		super();
		this.maHD = maHD;
		this.maNV = maNV;
		this.maBan = maBan;
		this.ngayBan = ngayBan;
		this.daTraTien = daTraTien;
		this.thanhTien = thanhTien;
	}
	/***
	 * 
	 */
	public HoaDon() {
		super();
	}
}
