package fpt.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.common.common;
import fpt.common.fileReader;
import fpt.model.bean.HangBanChay;
import fpt.model.bean.HoaDon;
import fpt.model.bean.NhanVien;
import fpt.model.bean.NhapXuat;
import fpt.model.bo.ThongKeBaoCaoBO;

/**
 * Servlet implementation class ThongKeBaoCaoServlet
 */

@WebServlet("/ThongKeBaoCaoServlet")

public class ThongKeBaoCaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThongKeBaoCaoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
				ThongKeBaoCaoBO thongKeBaoCaoBO = new ThongKeBaoCaoBO();

				String ngayBatDau = request.getParameter("ngayBatDau");
				String ngayKetThuc = request.getParameter("ngayKetThuc");
				session.setAttribute("ngayBatDau", ngayBatDau);
				session.setAttribute("ngayKetThuc", ngayKetThuc);

				if("xem".equals(request.getParameter("xem"))){
					if("banhang".equals(request.getParameter("chonmuc"))){
						ArrayList<HoaDon> arrHoaDon = new ArrayList<>();
						arrHoaDon = thongKeBaoCaoBO.xemThongKeBaoCaoHoaDon(ngayBatDau, ngayKetThuc);
						session.setAttribute("arrHoaDon", arrHoaDon);
						session.setAttribute("chonmuc", "banhang");

					}else if("hangnhap".equals(request.getParameter("chonmuc"))){
						ArrayList<NhapXuat> arrNhapXuat = new ArrayList<>();
						arrNhapXuat = thongKeBaoCaoBO.xemThongKeBaoCaoNhapXuat(ngayBatDau,ngayKetThuc);
						session.setAttribute("arrNhapXuat", arrNhapXuat);
						session.setAttribute("chonmuc", "hangnhap");
					}else if("hangbanchay".equals(request.getParameter("chonmuc"))){
						ArrayList<HangBanChay> arrHangBanChay = new ArrayList<>();
						arrHangBanChay = thongKeBaoCaoBO.xemThongKeBaoCaoHangBanChay(ngayBatDau,ngayKetThuc);
						session.setAttribute("arrHangBanChay1", arrHangBanChay);
						session.setAttribute("chonmuc", "hangbanchay");
					}
					//			if(!request.getParameter("in").equals("")){
					//				RequestDispatcher rd = request.getRequestDispatcher("in.jsp");
					//				rd.forward(request, response);
					//			}
				}
				RequestDispatcher ds = request.getRequestDispatcher("ThongKeBaoCao.jsp");
				ds.forward(request, response);
			}
		}
	}

}
