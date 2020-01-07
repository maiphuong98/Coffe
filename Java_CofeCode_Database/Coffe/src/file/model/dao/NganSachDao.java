package fpt.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import fpt.model.bean.NganSach;

/**
 * NganSachDao
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
public class NganSachDao {

  CoSo connection = new CoSo();

  public ArrayList<NganSach> getNganSach() {
    try {
      connection.KetNoi();
      String sql = "SELECT * FROM NGANSACH";
      PreparedStatement cmd = connection.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      ArrayList<NganSach> listNganSach = new ArrayList<NganSach>();
      while (rs.next()) {
        NganSach ns = new NganSach(rs.getString(1), rs.getString(2),
            rs.getString(3), rs.getLong(4));
        listNganSach.add(ns);
      }
      rs.close();
      connection.cn.close();
      return listNganSach;
    } catch (Exception tt) {
      tt.printStackTrace();
      return null;
    }
  }
  
  public ArrayList<NganSach> searchNganSach(String ngayTruoc, String ngaySau) {
    try {
      connection.KetNoi();
      String sql = "SELECT * FROM NGANSACH WHERE NGAYTHUCHI BETWEEN  ? AND ?";
      PreparedStatement cmd = connection.cn.prepareStatement(sql);
      cmd.setString(1, ngayTruoc);
      cmd.setString(2, ngaySau);
      ResultSet rs = cmd.executeQuery();
      ArrayList<NganSach> listNganSach = new ArrayList<NganSach>();
      
      while (rs.next()) {
        NganSach ns = new NganSach(rs.getString(1), rs.getString(2),
            rs.getString(3), rs.getLong(4));
        listNganSach.add(ns);
      }
      rs.close();
      connection.cn.close();
      return listNganSach;
    } catch (Exception tt) {
      tt.printStackTrace();
      return null;
    }
  }

  public int addThuChi(String maThuChi, String ngayThuChi, String tenThuChi, long soTien) {
    try {
      connection.KetNoi();
      String sql = "INSERT INTO NGANSACH VALUES (?,?,?,?)";
      PreparedStatement cmd = connection.cn.prepareStatement(sql);
      cmd.setString(1, maThuChi);
      cmd.setString(2, ngayThuChi);
      cmd.setString(3, tenThuChi);
      cmd.setLong(4, soTien);
      int kq = cmd.executeUpdate();
      connection.cn.close();
      return kq;
    } catch (Exception tt) {
      tt.printStackTrace();
      return 0;
    }
  }
}
