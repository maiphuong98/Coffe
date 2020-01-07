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
 * SuaNhanVienServlet
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
 * Servlet implementation class SuaNhanVienServlet
 */
@WebServlet("/SuaNhanVienServlet")
public class SuaNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaNhanVienServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//Check
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

				String maNV = request.getParameter("maNV");
				request.setAttribute("suaNhanVien", nhanVienBO.selectBO(maNV));
				if (request.getParameter("btnSua") != null) {

					String maNhanVien = request.getParameter("txtMaNhanVien");
					String tenNhanVien = request.getParameter("txtTenNhanVien");
					String diaChi = request.getParameter("txtDiaChi");
					String chucVu = request.getParameter("txtChucVu");
					long luong = Long.parseLong(request.getParameter("txtLuong"));
					String sdt = request.getParameter("txtSoDienThaoi");

					nhanVienBO.suaNhanVienBO(maNhanVien, tenNhanVien, diaChi, chucVu, luong, sdt);
					request.setAttribute("listNhanvien", nhanVienBO.getNhanVienBO());

					RequestDispatcher rs = request.getRequestDispatcher("NhanVienServlet");
					rs.forward(request, response);
				}else {
					RequestDispatcher rs = request.getRequestDispatcher("SuaNhanVien.jsp");
					rs.forward(request, response);
				}
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
