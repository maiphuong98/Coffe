package fpt.model.bo;

import fpt.model.dao.DangNhapDao;

/**
 * DangNhapBO
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
public class DangNhapBO {
  DangNhapDao dangNhapDao = new DangNhapDao();
  public boolean dangNhapDao(String tenDangNhap, String matKhau) {
    return dangNhapDao.dangNhap(tenDangNhap, matKhau);
  }
}
