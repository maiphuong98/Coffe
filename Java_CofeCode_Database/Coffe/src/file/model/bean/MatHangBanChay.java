package fpt.model.bean;

public class MatHangBanChay {
	private String maMon;
	private String tenMon;
	private long tongTien;
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public long getTongTien() {
		return tongTien;
	}
	public void setTongTien(long tongTien) {
		this.tongTien = tongTien;
	}
	public MatHangBanChay(String maMon, String tenMon, long tongTien) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.tongTien = tongTien;
	}
}
