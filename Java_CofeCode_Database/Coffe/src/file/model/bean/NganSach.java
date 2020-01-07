package fpt.model.bean;


/**
 * Ngân sách bean
 * @author NhatNV
 *
 */
public class NganSach {
  private String maNganSach;
  private String ngayChi;
  private String tenKhoanChi;
  private long soTien;

  public String getMaNganSach() {
    return maNganSach;
  }

  public void setMaNganSach(String maNganSach) {
    this.maNganSach = maNganSach;
  }

  public String getNgayChi() {
    return ngayChi;
  }

  public void setNgayChi(String ngayChi) {
    this.ngayChi = ngayChi;
  }

  public String getTenKhoanChi() {
    return tenKhoanChi;
  }

  public void setTenKhoanChi(String tenKhoanChi) {
    this.tenKhoanChi = tenKhoanChi;
  }

  public long getSoTien() {
    return soTien;
  }

  public void setSoTien(long soTien) {
    this.soTien = soTien;
  }
  /**
   * @param maNganSach
   * @param ngayChi
   * @param tenKhoanChi
   * @param soTien
   */
  public NganSach(String maNganSach, String ngayChi, String tenKhoanChi,
      long soTien) {
    super();
    this.maNganSach = maNganSach;
    this.ngayChi = ngayChi;
    this.tenKhoanChi = tenKhoanChi;
    this.soTien = soTien;
  }

  public NganSach() {
    super();
  }
}
