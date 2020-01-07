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
 * Servlet implementation class SuaTrangCaNhanServlet
 */
@WebServlet("/SuaTrangCaNhanServlet")
public class SuaTrangCaNhanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaTrangCaNhanServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		NhanVienBO nhanVienBO = new NhanVienBO();

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
			String tenDangNhap = (String) session.getAttribute("txtTenDangNhap");

			request.setAttribute("nhanVien", nhanVienBO.TrangCaNhanBO(tenDangNhap));

			if (request.getParameter("btnSua") != null) {

				String maNhanVien = request.getParameter("txtMaNhanVien");
				String tenNhanVien = request.getParameter("txtTenNhanVien");
				String diaChi = request.getParameter("txtDiaChi");
				String chucVu = "";
				if(request.getParameter("txtChucVu") == null)
					chucVu = common.NHAN_VIEN;
				else
					chucVu = request.getParameter("txtChucVu");
				long luong = Long.parseLong(request.getParameter("txtLuong"));
				String sdt = request.getParameter("txtSoDienThaoi");

				nhanVienBO.suaNhanVienBO(maNhanVien, tenNhanVien, diaChi, chucVu, luong, sdt);

				RequestDispatcher rs = request.getRequestDispatcher("TrangCaNhanServlet");
				rs.forward(request, response);
			}else {
				RequestDispatcher rs = request.getRequestDispatcher("SuaTrangCaNhan.jsp");
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
