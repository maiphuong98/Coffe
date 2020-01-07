package fpt.model.bo;

import java.util.ArrayList;
import fpt.model.bean.NhanVien;
import fpt.model.dao.NhanVienDao;


/**
 * NhanVienDao
 * 
 * Version 1.0
 * 
 * Date 03-03-2018 
 * 
 * Copyright
 * 
 * Modification Logs
 * DATE       AUTHOR      DESCRIPTION
 * ---------------------------------------
 * 03-03-2018    NhatNV      Create
 */
public class NhanVienBO {
  
  NhanVienDao nhanVienDao = new NhanVienDao();
  
  public ArrayList<NhanVien> getNhanVienBO(){
    return nhanVienDao.getNhanVien();
    
  }
  public NhanVien selectTenDangNhap(String tenDangNhap) {
	  return nhanVienDao.selectTenDangNhap(tenDangNhap);
  }
  
  public int addNhanVienBO(String maNhanVien, String hoTen, String diaChi, String chucVu, long luong, 
      String sdt, String anh, String matKhau, String tenDangNhap) {
    if("".equals(maNhanVien))
      return 0;
    else 
      return nhanVienDao.addNhanVien(maNhanVien, hoTen, diaChi, chucVu, 
          luong, sdt, anh, matKhau, tenDangNhap);
  }
  
  public NhanVien selectBO(String maNV) {
    return nhanVienDao.select(maNV);
  }
  
  public int suaNhanVienBO(String maNhanVien, String tenNhanVien, String diaChi, String chucVu, long luong, String sdt) {
    return nhanVienDao.suaNhanVien(maNhanVien, tenNhanVien, diaChi, chucVu, luong, sdt);
    
  }
  
  public void xoaNhanVien(String maNV) {
    nhanVienDao.xoaNhanVien(maNV);
  }
  
  public ArrayList<NhanVien> searchNhanVienBO(String key) {
    return nhanVienDao.searchNhanVien(key);
  }
  
  public NhanVien TrangCaNhanBO(String tenDangNhap) {
    return nhanVienDao.trangCaNhan(tenDangNhap);
  }
  
  public int suaAnhBO(String anh, String tenDangNhap) {
	    return nhanVienDao.suaAnh(anh, tenDangNhap);
	  }
}
