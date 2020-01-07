package fpt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.common.common;
import fpt.model.bean.NhanVien;
import fpt.model.bo.DangNhapBO;
import fpt.model.bo.NhanVienBO;

/**
 * DangNhapServlet
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
/**
 * Servlet implementation class DangNhapServlet
 */
@WebServlet("/DangNhapServlet")
public class DangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhapServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	DangNhapBO dangNhapBO = new DangNhapBO();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	NhanVienBO nhanVienBO = new NhanVienBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String tenDangNhap = request.getParameter("txtTenDangNhap");
		String matKhau = request.getParameter("txtMatKhau");

		if (request.getParameter("btnDangNhap") != null) {
			if (dangNhapBO.dangNhapDao(tenDangNhap, matKhau)) {

				HttpSession session = request.getSession();
				session.setAttribute("txtTenDangNhap", tenDangNhap);
				
				NhanVien nhanVien = nhanVienBO.selectTenDangNhap(tenDangNhap);
				session.setAttribute("user", nhanVien);
				RequestDispatcher rs = null;
				if(common.QUAN_TRI_VIEN.equalsIgnoreCase(nhanVien.getChucVu())){
					rs = request.getRequestDispatcher("TrangChu");
				}else{
					rs = request.getRequestDispatcher("BanHang_Menu");
				}
				rs.forward(request, response);
			}else{
				request.setAttribute("resultLogin", "Tên đăng nhập hoặc mật khẩu sai!<br><br>");
				RequestDispatcher rs = request.getRequestDispatcher("DangNhap.jsp");
				rs.forward(request, response);
			}
		}else {
			RequestDispatcher rs = request.getRequestDispatcher("DangNhap.jsp");
			rs.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
