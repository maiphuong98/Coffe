package fpt.model.bo;

import java.util.ArrayList;
import fpt.model.bean.NganSach;
import fpt.model.dao.NganSachDao;

/**
 * NganSachBO
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

public class NganSachBO {
  
  NganSachDao nganSachDao = new NganSachDao();

  public ArrayList<NganSach> getNganSachBO() {
    return nganSachDao.getNganSach();
  }
  
  public ArrayList<NganSach> searchNganSachBO(String ngayTruoc, String ngaySau) {
    return nganSachDao.searchNganSach(ngayTruoc, ngaySau);
  }
  
  public int addNganSach(String maNganSach, String ngayThuChi, String tenThuChi, long soTien) {
    if("".equals(maNganSach))
      return 0;
    else 
      return nganSachDao.addThuChi(maNganSach, ngayThuChi, tenThuChi, soTien);
  }
}
