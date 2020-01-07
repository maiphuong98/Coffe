package fpt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.common.ConvertDate;
import fpt.common.common;
import fpt.model.bean.HoaDon;
import fpt.model.bean.NhanVien;
import fpt.model.bo.ThongKeBaoCaoBO;

/**
 * Servlet implementation class InServlet
 */
@WebServlet("/InServlet")
public class InServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InServlet() {
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
				ConvertDate convertDate = new ConvertDate();
				String chonmuc = (String) session.getAttribute("chonmuc");
				String ngayBatDau = (String) session.getAttribute("ngayBatDau");
				String ngayKetThuc = (String) session.getAttribute("ngayKetThuc");
				request.setAttribute("ngayBatDau", convertDate.convertDateMonthYear(ngayBatDau));
				request.setAttribute("ngayKetThuc", convertDate.convertDateMonthYear(ngayKetThuc));
				RequestDispatcher rs = request.getRequestDispatcher("in.jsp");
				rs.forward(request, response);
			}
		}
	}

}
