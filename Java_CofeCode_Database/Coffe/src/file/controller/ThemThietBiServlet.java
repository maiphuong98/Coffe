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
import fpt.model.bean.ThietBi;
import fpt.model.bo.ThietBiBO;

/**
 * Servlet implementation class ThemThietBiServlet
 */
@WebServlet("/ThemThietBiServlet")
public class ThemThietBiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemThietBiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
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

				ThietBiBO thietBiBO =  new ThietBiBO();

				if("them".equals(request.getParameter("them")) && (request.getParameter("them") != null) ) {
					String maThietBi = request.getParameter("maThietBi");
					String tenThietBi = request.getParameter("tenThietBi");
					int soLuong = Integer.valueOf(request.getParameter("soLuong"));
					String ngayNhap = request.getParameter("ngaymua");
					int donGia = Integer.valueOf(request.getParameter("donGia"));
					thietBiBO.Themthietbi(maThietBi, tenThietBi, soLuong, ngayNhap, donGia);
					response.sendRedirect("DanhSachThietBiServlet");
					return;
				}
				rd = request.getRequestDispatcher("Themthietbi.jsp");
				rd.forward(request, response);
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
