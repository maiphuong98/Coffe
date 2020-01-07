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
import fpt.model.bo.ThucDonBO;

/**
 * Servlet implementation class ThucDon
 */
@WebServlet("/ThucDon")
public class ThucDon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThucDon() {
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
	ThucDonBO thucDonBO = new ThucDonBO();
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
				if(request.getParameter("action") != null){
					String action = request.getParameter("action");
					if("them".equals(action)){
						thucDonBO.addThucDon(new fpt.model.bean.ThucDon(request.getParameter("maMon"), request.getParameter("tenMon")
								, Long.parseLong(request.getParameter("gia")), request.getParameter("donViTinh")));
						response.sendRedirect("ThucDon");
					}else if("sua".equals(action)){
						//Hiển thị trang sửa
						if(request.getParameter("tenMon") == null){
							request.setAttribute("thucDon", thucDonBO.getThucDon(request.getParameter("mamon")));
							rd = request.getRequestDispatcher("ThemSuaThucDon.jsp");
						}
						//xử lý sửa
						else{
							thucDonBO.updateThucDon(new fpt.model.bean.ThucDon(request.getParameter("maMon"), request.getParameter("tenMon")
									, Long.parseLong(request.getParameter("gia")), request.getParameter("donViTinh")));
							rd = request.getRequestDispatcher("ThucDon");
						}
						rd.forward(request, response);

					}else if("xoa".equals(action)){
						thucDonBO.deleteThucDon(request.getParameter("mamon"));
						response.sendRedirect("ThucDon");
					}else if("check".equals(action)){
						String maMon = request.getParameter("mamon");
						request.setAttribute("checkThucDon", thucDonBO.checkID(maMon));
						rd = request.getRequestDispatcher("./ajax-rq/checkID-ThucDon.jsp");
						rd.forward(request, response);
					}
				}else{
					request.setAttribute("dsThucDon", thucDonBO.getListThucDon());
					rd = request.getRequestDispatcher("ThucDon.jsp");
					rd.forward(request, response);
				}
			}
		}
	}

}
