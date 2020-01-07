package fpt.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import fpt.model.bean.NhanVien;

/**
 * NhanVienDao
 * 
 * Version 1.0
 * 
 * Date 03-03-2018
 * 
 * Copyright
 * 
 * Modification Logs DATE AUTHOR DESCRIPTION
 * --------------------------------------- 03-03-2018 NhatNV Create
 */
public class NhanVienDao {

  CoSo connection = new CoSo();

  public ArrayList<NhanVien> getNhanVien() {
    try {
      connection.KetNoi();
      String sql = "SELECT MANV, HOTEN, CHUCVU, LUONG FROM NHANVIEN";
      PreparedStatement cmd = connection.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      ArrayList<NhanVien> listNhanVien = new ArrayList<NhanVien>();
      while (rs.next()) {
        NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2),
            rs.getString(3), rs.getLong(4));
        listNhanVien.add(nv);
      }
      rs.close();
      connection.cn.close();
      return listNhanVien;
    } catch (Exception tt) {
      tt.printStackTrace();
      return null;
    }
  }

  public int addNhanVien(String maNhanVien, String hoTen, String diaChi,
      String chucVu, long luong, String sdt, String anh, String matKhau,
      String tenDangNhap) {
    try {
      connection.KetNoi();
      String sql = "INSERT INTO NHANVIEN VALUES (?,?,?,?,?,?,?,?,?)";
      PreparedStatement cmd = connection.cn.prepareStatement(sql);
      cmd.setString(1, maNhanVien);
      cmd.setString(2, hoTen);
      cmd.setString(3, diaChi);
      cmd.setString(4, chucVu);
      cmd.setLong(5, luong);
      cmd.setString(6, sdt);
      cmd.setString(7, anh);
      cmd.setString(8, matKhau);
      cmd.setString(9, tenDangNhap);
      int kq = cmd.executeUpdate();
      connection.cn.close();
      return kq;
    } catch (Exception tt) {
      tt.printStackTrace();
      return 0;
    }
  }

  public NhanVien select(String maNV) {
    try {
      connection.KetNoi();
      String sql = "SELECT MANV, HOTEN, DIACHI, CHUCVU, LUONG, SODIENTHOAI FROM NHANVIEN WHERE MaNV = ?";
      PreparedStatement cmd = connection.cn.prepareStatement(sql);
      cmd.setString(1, maNV);
      ResultSet rs = cmd.executeQuery();
      if (rs.next()) {
        NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2),
            rs.getString(3), rs.getString(4), rs.getLong(5), rs.getString(6));
        return nv;
      }
      rs.close();
      connection.cn.close();
      return null;
    } catch (Exception tt) {
      tt.printStackTrace();
      return null;
    }
  }
  
  public NhanVien selectTenDangNhap(String tenDangNhap) {
	    try {
	      connection.KetNoi();
	      String sql = "SELECT MANV, HOTEN, DIACHI, CHUCVU, LUONG, SODIENTHOAI FROM NHANVIEN WHERE TenDangNhap = ?";
	      PreparedStatement cmd = connection.cn.prepareStatement(sql);
	      cmd.setString(1, tenDangNhap);
	      ResultSet rs = cmd.executeQuery();
	      if (rs.next()) {
	        NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2),
	            rs.getString(3), rs.getString(4), rs.getLong(5), rs.getString(6));
	        return nv;
	      }
	      rs.close();
	      connection.cn.close();
	      return null;
	    } catch (Exception tt) {
	      tt.printStackTrace();
	      return null;
	    }
	  }

  public int suaNhanVien(String maNhanVien, String tenNhanVien, String diaChi,
      String chucVu, long luong, String sdt) {
    try {
      connection.KetNoi();
      String sql = "UPDATE NHANVIEN SET HOTEN = ?, DIACHI = ?,CHUCVU = ?,LUONG=?,SODIENTHOAI=? WHERE MANV = ?";
      PreparedStatement cmd = connection.cn.prepareStatement(sql);

      cmd.setString(1, tenNhanVien);
      cmd.setString(2, diaChi);
      cmd.setString(3, chucVu);
      cmd.setLong(4, luong);
      cmd.setString(5, sdt);
      cmd.setString(6, maNhanVien);

      int kq = cmd.executeUpdate();
      connection.cn.close();
      return kq;
    } catch (Exception tt) {
      tt.printStackTrace();
      return 0;
    }
  }

  public void xoaNhanVien(String maNV) {
    try {
      connection.KetNoi();
      String sql = "DELETE FROM NHANVIEN WHERE MANV = ?";
      PreparedStatement cmd = connection.cn.prepareStatement(sql);
      cmd.setString(1, maNV);
      cmd.executeUpdate();
      connection.cn.close();
    } catch (Exception tt) {
      tt.printStackTrace();
    }
  }

  public ArrayList<NhanVien> searchNhanVien(String key) {
    try {
      connection.KetNoi();
      String sql = "SELECT * FROM NHANVIEN WHERE MANV LIKE ? OR HOTEN LIKE  ? OR SODIENTHOAI LIKE ? OR DIACHI LIKE ?";
      PreparedStatement cmd = connection.cn.prepareStatement(sql);
      cmd.setString(1, "%" + key + "%");
      cmd.setString(2, "%" + key + "%");
      cmd.setString(3, "%" + key + "%");
      cmd.setString(4, "%" + key + "%");
      ResultSet rs = cmd.executeQuery();
      ArrayList<NhanVien> listNhanVien = new ArrayList<NhanVien>();
      while (rs.next()) {
        NhanVien nv = new NhanVien(rs.getString("MaNV"), rs.getString("HoTen"),
            rs.getString("ChucVu"), rs.getLong("Luong"));
        listNhanVien.add(nv);
      }
      rs.close();
      connection.cn.close();
      return listNhanVien;
    } catch (Exception tt) {
      tt.printStackTrace();
      return null;
    }
  }
  
  public NhanVien trangCaNhan(String tenDangNhap) {
    try {
      connection.KetNoi();
      String sql = "SELECT * FROM NHANVIEN WHERE TENDANGNHAP = ?";
      PreparedStatement cmd = connection.cn.prepareStatement(sql);
      cmd.setString(1, tenDangNhap);
      ResultSet rs = cmd.executeQuery();
      if (rs.next()) {
        NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2),
            rs.getString(3), rs.getString(4), rs.getLong(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
        return nv;
      }
      rs.close();
      connection.cn.close();
      return null;
    } catch (Exception tt) {
      tt.printStackTrace();
      return null;
    }
  }
  
  public int suaAnh(String anh, String tenDangNhap) {
	    try {
	      connection.KetNoi();
	      String sql = "UPDATE NHANVIEN SET ANH = ? WHERE TENDANGNHAP = ?";
	      PreparedStatement cmd = connection.cn.prepareStatement(sql);

	      cmd.setString(1, anh);
	      cmd.setString(2, tenDangNhap);

	      int kq = cmd.executeUpdate();
	      connection.cn.close();
	      return kq;
	    } catch (Exception tt) {
	      tt.printStackTrace();
	      return 0;
	    }
	  }
}
