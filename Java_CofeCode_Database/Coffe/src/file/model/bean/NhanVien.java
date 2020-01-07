package fpt.model.bean;

/**
 * 
 * @author vTr
 *
 */
public class NhanVien {
	private String maNV;
	private String hoTen;
	private String diaChi;
	private String chucVu;
	private long luong;
	private String soDienThoai;
	private String anh;
	private String matKhau;
	private String tenDangNhap;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public long getLuong() {
		return luong;
	}
	public void setLuong(long luong) {
		this.luong = luong;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getTenDangNhap() {
    return tenDangNhap;
  }
  public void setTenDangNhap(String tenDangNhap) {
    this.tenDangNhap = tenDangNhap;
  }
  /**
	 * Constructer
	 * @param maNV
	 * @param hoTen
	 * @param diaChi
	 * @param chucVu
	 * @param luong
	 * @param soDienThoai
	 * @param anh
	 * @param matKhau
	 */
	public NhanVien(String maNV, String hoTen, String diaChi, String chucVu, long luong, String soDienThoai, String anh,
			String matKhau, String tenDangNhap) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
		this.luong = luong;
		this.soDienThoai = soDienThoai;
		this.anh = anh;
		this.matKhau = matKhau;
	  this.tenDangNhap = tenDangNhap;
	}
	public NhanVien(String maNV, String hoTen, String chucVu, long luong) {
    super();
    this.maNV = maNV;
    this.hoTen = hoTen;
    this.chucVu = chucVu;
    this.luong = luong;
  }
	public NhanVien(String maNV, String hoTen, String diaChi, String chucVu, long luong, String soDienThoai) {
    super();
    this.maNV = maNV;
    this.hoTen = hoTen;
    this.diaChi = diaChi;
    this.chucVu = chucVu;
    this.luong = luong;
    this.soDienThoai = soDienThoai;
  }
	public NhanVien() {
		super();
	}
}
