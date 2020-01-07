package fpt.model.bean;

/**
 * THực đơn bean
 * @author vTr
 *
 */
public class ThucDon {
	 private String maMon;
	 private String tenMon;
	 private long gia;
	 private String donViTinh;
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
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	/**
	 * 
	 * @param maMon
	 * @param tenMon
	 * @param gia
	 * @param donViTinh
	 */
	public ThucDon(String maMon, String tenMon, long gia, String donViTinh) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.gia = gia;
		this.donViTinh = donViTinh;
	}
	public ThucDon() {
		super();
	} 
}
