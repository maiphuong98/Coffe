package fpt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.common.common;
import fpt.model.bean.Ban;
import fpt.model.bean.NhanVien;
import fpt.model.bean.ThucDon;
import fpt.model.bo.BanBO;
import fpt.model.bo.ThucDonBO;

/**
 * Servlet implementation class BanHang_Menu
 */
@WebServlet("/BanHang_Menu")
public class BanHang_Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BanHang_Menu() {
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
	BanBO banBO = new BanBO();
	ThucDonBO thucDonBO = new ThucDonBO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
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
		}else{

			ArrayList<Ban> arrBan = banBO.getListBan();
			Collections.sort(arrBan, Ban.compare);

			ArrayList<ThucDon> arrThucDon = null;		

			//Nếu chọn vào ô tìm kiếm
			if(request.getParameter("key") != null){
				arrThucDon = thucDonBO.getListThucDon(request.getParameter("key"));
				request.setAttribute("danhSachThucDon", arrThucDon);
				RequestDispatcher rd = request.getRequestDispatcher("./BanHang-Action/BanHang-danhSachThucDon.jsp");
				rd.forward(request, response);
			}

			else if(request.getParameter("menu") != null){
				//Chọn danh sách bàn
				if ("ban".equals(request.getParameter("menu"))) {
					request.setAttribute("danhSachBan", arrBan);
					RequestDispatcher rd = request.getRequestDispatcher("./BanHang-Action/BanHang-danhSachBan.jsp");
					rd.forward(request, response);

				}
				//Chọn danh sách món ăn
				else if("thucdon".equals(request.getParameter("menu"))){
					arrThucDon = thucDonBO.getListThucDon();
					request.setAttribute("danhSachThucDon", arrThucDon);
					RequestDispatcher rd = request.getRequestDispatcher("./BanHang-Action/BanHang-danhSachThucDon.jsp");
					rd.forward(request, response);
				}	
			}
			// Mặc định lúc load trang
			else{
				request.setAttribute("danhSachBan", arrBan);
				RequestDispatcher rd = request.getRequestDispatcher("BanHang.jsp");
				rd.forward(request, response);
			}
		}
	}
}
