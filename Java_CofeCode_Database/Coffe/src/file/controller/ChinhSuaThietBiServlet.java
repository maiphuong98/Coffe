package fpt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.model.bean.ThietBi;
import fpt.model.bo.ThietBiBO;

/**
 * Servlet implementation class ChinhSuaThietBiServlet
 */
@WebServlet("/ChinhSuaThietBiServlet")
public class ChinhSuaThietBiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChinhSuaThietBiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HtatpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		ThietBiBO thietBiBO =  new ThietBiBO();
		String maThietBi = request.getParameter("maThietBi");
		ThietBi thietbi = thietBiBO.getThietBi(maThietBi);
		request.setAttribute("thietbi", thietbi);
		
		
		if("sua".equals(request.getParameter("sua")) && (request.getParameter("sua") != null) ) {
			String tenThietBi = request.getParameter("tenThietBi");
			int soLuong = Integer.valueOf(request.getParameter("soLuong"));
			String ngayNhap = request.getParameter("ngayNhap");
			int donGia = Integer.valueOf(request.getParameter("donGia"));
			thietBiBO.chinhsuathietbi(maThietBi, tenThietBi, soLuong, ngayNhap, donGia);
			response.sendRedirect("DanhSachThietBiServlet");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("Chinhsuathietbi.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
