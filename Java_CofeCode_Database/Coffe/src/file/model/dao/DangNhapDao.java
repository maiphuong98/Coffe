package fpt.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DangNhapDao
 * 
 * Version 1.0
 * 
 * Date 02-03-2018
 * 
 * Copyright
 * 
 * Modification Logs
 * DATE       AUTHOR      DESCRIPTION
 * ---------------------------------------
 * 02-03-2018   NhatNV      Create
 */

public class DangNhapDao {
  
  CoSo connection = new CoSo();
  
 // kiểm tra đăng nhập
  
  public boolean dangNhap(String tenDangNhap, String matKhau) {
    connection.KetNoi();
    String ketNoi = "SELECT * FROM NhanVien WHERE TenDangNhap = ? AND MatKhau = ?";
    try {
      PreparedStatement cmd = connection.cn.prepareStatement(ketNoi);
      cmd.setString(1, tenDangNhap);
      cmd.setString(2, matKhau);
      ResultSet rs = cmd.executeQuery();
      
      boolean ketQua = rs.next();
      connection.cn.close();
      return ketQua;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
    }
    
  }
}
