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
import fpt.model.bo.BanBO;

/**
 * Servlet implementation class Ban
 */
@WebServlet("/Ban")
public class Ban extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ban() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;

		if(session.getAttribute("user") == null){
			rd = request.getRequestDispatcher("DangNhap.jsp");
			rd.forward(request, response);
		}else{
			NhanVien nhanVien = (NhanVien)session.getAttribute("user");
			if(common.NHAN_VIEN.equals(nhanVien.getChucVu())){
				rd = request.getRequestDispatcher("BanHang_Menu");
				rd.forward(request, response);
			}else if(common.QUAN_TRI_VIEN.equals(nhanVien.getChucVu())){
				if(request.getParameter("action") != null){
					String action = request.getParameter("action");
					if("them".equals(action)){
						banBO.addBan(new fpt.model.bean.Ban(request.getParameter("maBan"), request.getParameter("tenBan"), "Trống"));
						response.sendRedirect("Ban");
						return;
					}else if("sua".equals(action)){
						//Hiển thị trang sửa
						if(request.getParameter("tenBan") == null){
							request.setAttribute("ban", banBO.getBan(request.getParameter("maBan")));
							rd = request.getRequestDispatcher("ThemSuaBan.jsp");
						}
						//xử lý sửa
						else{
							banBO.updateBan(new fpt.model.bean.Ban(request.getParameter("maBan"), request.getParameter("tenBan"), "Trống"));
							response.sendRedirect("Ban");
							return;
						}
						rd.forward(request, response);


					}else if("check".equals(action)){
						String maBan = request.getParameter("maban");
						request.setAttribute("checkBan", banBO.checkID(maBan));
						rd = request.getRequestDispatcher("./ajax-rq/checkID-Ban.jsp");
						rd.forward(request, response);
					}
				}else{
					request.setAttribute("dsBan", banBO.getListBan());
					rd = request.getRequestDispatcher("Ban.jsp");
					rd.forward(request, response);
				}
			}
		}	
	}

}
