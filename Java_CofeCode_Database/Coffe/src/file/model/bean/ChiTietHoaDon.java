package fpt.model.bean;

/**
 * Chi Tiet Hoa Đơn bean
 * @author vTr
 *
 */
public class ChiTietHoaDon {
	private long maCTHD;
	private long soLuongMua;
	private long maHD;
	private String maMon;
	private String tenMon;
	private long gia;
	

	
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public long getMaCTHD() {
		return maCTHD;
	}
	public void setMaCTHD(long maCTHD) {
		this.maCTHD = maCTHD;
	}
	public long getSoLuongMua() {
		return soLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	public long getMaHD() {
		return maHD;
	}
	public void setMaHD(long maHD) {
		this.maHD = maHD;
	}
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	/**
	 * 
	 * @param soLuongMua
	 * @param maHD
	 * @param maMon
	 */
	public ChiTietHoaDon(long soLuongMua, long maHD, String maMon) {
		super();
		this.soLuongMua = soLuongMua;
		this.maHD = maHD;
		this.maMon = maMon;
	}
	/**
	 * 
	 * @param maCTHD
	 * @param soLuongMua
	 * @param maHD
	 * @param maMon
	 */
	public ChiTietHoaDon(long maCTHD, long soLuongMua, long maHD, String maMon) {
		super();
		this.maCTHD = maCTHD;
		this.soLuongMua = soLuongMua;
		this.maHD = maHD;
		this.maMon = maMon;
	}
	
	/***
	 * 
	 * @param maCTHD
	 * @param soLuongMua
	 * @param maHD
	 * @param maMon
	 * @param tenMon
	 */
	public ChiTietHoaDon(long maCTHD, long soLuongMua, long maHD, String maMon, String tenMon) {
		super();
		this.maCTHD = maCTHD;
		this.soLuongMua = soLuongMua;
		this.maHD = maHD;
		this.maMon = maMon;
		this.tenMon = tenMon;
	}
	public ChiTietHoaDon() {
		super();
	}
	/***
	 * 
	 * @param maCTHD
	 * @param soLuongMua
	 * @param maHD
	 * @param maMon
	 * @param tenMon
	 * @param gia
	 */
	public ChiTietHoaDon(long maCTHD, long soLuongMua, long maHD, String maMon, String tenMon, long gia) {
		super();
		this.maCTHD = maCTHD;
		this.soLuongMua = soLuongMua;
		this.maHD = maHD;
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.gia = gia;
	}
}
