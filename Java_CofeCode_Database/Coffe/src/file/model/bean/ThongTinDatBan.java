package fpt.model.bean;

/**
 * Thong tin đặt bàn
 * @author vTr
 *
 */
public class ThongTinDatBan {
	private long maThongTinDatBan;
	private String tenKH;
	private String SDT;
	private String ngay;
	private String gio;
	private String maBan;


	public long getMaThongTinDatBan() {
		return maThongTinDatBan;
	}
	public void setMaThongTinDatBan(long maThongTinDatBan) {
		this.maThongTinDatBan = maThongTinDatBan;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getNgay() {
		return ngay;
	}
	public void setNgay(String ngay) {
		this.ngay = ngay;
	}
	public String getGio() {
		return gio;
	}
	public void setGio(String gio) {
		this.gio = gio;
	}
	public String getMaBan() {
		return maBan;
	}
	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}
	/**
	 * 	
	 * @param tenKH
	 * @param sDT
	 * @param ngay
	 * @param gio
	 * @param maBan
	 */
	public ThongTinDatBan(String tenKH, String sDT, String ngay, String gio, String maBan) {
		super();
		this.tenKH = tenKH;
		SDT = sDT;
		this.ngay = ngay;
		this.gio = gio;
		this.maBan = maBan;
	}
	public ThongTinDatBan() {
		super();
	}
	/**
	 * 
	 * @param maThongTinDatBan
	 * @param tenKH
	 * @param sDT
	 * @param ngay
	 * @param gio
	 * @param maBan
	 */
	public ThongTinDatBan(long maThongTinDatBan, String tenKH, String sDT, String ngay, String gio, String maBan) {
		super();
		this.maThongTinDatBan = maThongTinDatBan;
		this.tenKH = tenKH;
		SDT = sDT;
		this.ngay = ngay;
		this.gio = gio;
		this.maBan = maBan;
	}
}
