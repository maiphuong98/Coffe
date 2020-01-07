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

import fpt.model.bo.NhanVienBO;

/**
 * Servlet implementation class TrangCaNhanServlet
 */
@WebServlet("/TrangCaNhanServlet")
public class TrangCaNhanServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public TrangCaNhanServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");

    
    
    NhanVienBO nhanVienBO = new NhanVienBO();

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
		 return;
	}
	
    String tenDangNhap = (String) session.getAttribute("txtTenDangNhap");

    request.setAttribute("nhanVien", nhanVienBO.TrangCaNhanBO(tenDangNhap));
    
    RequestDispatcher rs = request.getRequestDispatcher("TrangCaNhan.jsp");
    rs.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
