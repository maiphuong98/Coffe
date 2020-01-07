package fpt.model.bean;

import java.util.Date;

public class HangBanChay {
	private String tenMon;
	private Date ngayBan;
	private int soLuongMua;
	public HangBanChay(String tenMon, Date ngayBan, int soLuongMua) {
		super();
		this.tenMon = tenMon;
		this.ngayBan = ngayBan;
		this.soLuongMua = soLuongMua;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public Date getNgayBan() {
		return ngayBan;
	}
	public void setNgayBan(Date ngayBan) {
		this.ngayBan = ngayBan;
	}
	public int getSoLuongMua() {
		return soLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	
}
