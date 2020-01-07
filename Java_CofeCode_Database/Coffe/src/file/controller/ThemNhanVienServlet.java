package fpt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.common.common;
import fpt.model.bean.NhanVien;
import fpt.model.bo.NhanVienBO;

/**
 * ThemNhanVienServlet
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
/**
 * Servlet implementation class ThemNhanVienServlet
 */
@WebServlet("/ThemNhanVienServlet")
public class ThemNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemNhanVienServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;

		if(session.getAttribute("user") == null){
			PrintWriter out = response.getWriter();
			 out.println("<html>"
			 		+ "<head>"
			 		+ "<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>"
			 		+ "<title>ERROR</title>"
			 		+ "</head>"
			 		+ "<body>"
			 		+ "<div align='center'><b>Bạn chưa đăng nhập hoặc phiên làm việc đã hết hạn. </b> <a href='./DangNhap.jsp'>Chuyển đến đăng nhập.</a> "
			 		+ "</div>"
			 		+ "</body>"
			 		+ "</html>");
			 return;
		}else{
			NhanVien nhanVien = (NhanVien)session.getAttribute("user");
			if(common.NHAN_VIEN.equals(nhanVien.getChucVu())){
				rd = request.getRequestDispatcher("BanHang_Menu");
				rd.forward(request, response);
			}else if(common.QUAN_TRI_VIEN.equals(nhanVien.getChucVu())){
				NhanVienBO nhanVienBO = new NhanVienBO();
				if (request.getParameter("btnThem") != null) {

					String maNhanVien = request.getParameter("txtMaNhanVien");
					String tenNhanVien = request.getParameter("txtTenNhanVien");
					String chucVu = request.getParameter("txtChucVu");
					long luong = Long.parseLong(request.getParameter("txtLuong"));
					String diaChi = request.getParameter("txtDiaChi");
					String sdt = request.getParameter("txtSdt");
					String anh = request.getParameter("txtAnh");
					String matKhau = request.getParameter("txtMatKhau");
					String tenDangNhap = request.getParameter("txtTenDangNhap");
					String tam = "";

					if (nhanVienBO.addNhanVienBO(maNhanVien, tenNhanVien, diaChi, chucVu, luong, 
							sdt, anh, matKhau, tenDangNhap) == 1) {
						tam = "Thêm thành công!";
					} else
						tam = "Thêm thất bại!";
					request.setAttribute("tam", tam);
				}
				RequestDispatcher rs = request.getRequestDispatcher("NhanVienServlet");
				rs.forward(request, response); 
			}
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
