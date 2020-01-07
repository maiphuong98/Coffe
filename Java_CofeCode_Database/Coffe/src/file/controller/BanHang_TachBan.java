package fpt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.model.bean.ChiTietHoaDon;
import fpt.model.bean.HoaDon;
import fpt.model.bean.NhanVien;
import fpt.model.bo.BanBO;
import fpt.model.bo.HoaDonBO;
import fpt.model.bo.NhanVienBO;

/**
 * Servlet implementation class BanHang_TachBan
 */
@WebServlet("/BanHang_TachBan")
public class BanHang_TachBan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BanHang_TachBan() {
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
	HoaDonBO hoaDonBO = new HoaDonBO();
	BanBO banBO = new BanBO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		if(request.getParameterValues("checkbox-tachban")!=null){
			long soLuongTach = 0;
			ChiTietHoaDon cthdTach = null;
			//Lấy mã bàn đang chọn và tách đến
			String maBanDangChon = request.getParameter("bandangchon");
			String maBanTachDen = request.getParameter("select-tachban");
			
			//Nếu 2 bàn khác nhau thì mới tách
			if(!maBanDangChon.equals(maBanTachDen)){
				//Lấy  list check box
				String[] lstCheck = request.getParameterValues("checkbox-tachban");

				for(String maCTHD: lstCheck){

					//Lấy số lượng cần tách
					soLuongTach = Long.parseLong(request.getParameter(maCTHD));
					//Lấy cthd cần tách
					cthdTach = hoaDonBO.getChiTietHoaDonByID(Long.parseLong(maCTHD));

					//Nếu bàn tách đến chưa có hóa đơn
					if(hoaDonBO.getHoaDon(maBanTachDen) == null){
						//Tạo mới 1 hóa đơn cho bàn đó
						
						
						//Lấy thông tin nhân viên
						String tenDangNhap = "admin";
						if(request.getSession().getAttribute("txtTenDangNhap")==null){
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
							tenDangNhap = request.getSession().getAttribute("txtTenDangNhap").toString();
						}
						NhanVien nhanVien = new NhanVienBO().selectTenDangNhap(tenDangNhap);
						
						hoaDonBO.addHoaDon(new HoaDon(nhanVien.getMaNV(), maBanTachDen, new Date(), false, 0));
						
						
						banBO.updateStatus("Đang sử dụng", maBanTachDen);
						//Chuyển sang bàn kia
							//Nếu sluong chuyển sang max thì chuyển đổi mã hóa đơn
						if(soLuongTach == cthdTach.getSoLuongMua()){
							cthdTach.setMaHD(hoaDonBO.getHoaDon(maBanTachDen).getMaHD());
							hoaDonBO.updateCTHD(cthdTach);
						}
							//Nếu sl k max
						else{
							//giảm bên A
							cthdTach.setSoLuongMua(cthdTach.getSoLuongMua()-soLuongTach);
							hoaDonBO.updateCTHD(cthdTach);
							//Tạo ms 1 cthd vs soluong giảm 
							hoaDonBO.addCTHD(new ChiTietHoaDon(soLuongTach, hoaDonBO.getHoaDon(maBanTachDen).getMaHD(), cthdTach.getMaMon()));
						}
								
					}else{
						//Nếu bàn đó có hóa đơn rồi
						
						//Lấy hoadon của ban 2
						HoaDon hoaDonBan2 = hoaDonBO.getHoaDon(maBanTachDen);
						//Lấy ds cthd cua ban 2
						ArrayList<ChiTietHoaDon> lstCTHDBan2 = hoaDonBO.getListChiTietHoaDon(hoaDonBan2.getMaHD());
						//duyet trong ban 2
						Boolean ck = false;
						for(ChiTietHoaDon chiTietHoaDon : lstCTHDBan2){
							//neu có mon do roi
							if(cthdTach.getMaMon().equals(chiTietHoaDon.getMaMon())){
								//Neu sluong chuyen max
								if(soLuongTach==cthdTach.getSoLuongMua()){
									//tang soluong ben 2
									chiTietHoaDon.setSoLuongMua(chiTietHoaDon.getSoLuongMua() + soLuongTach);
									hoaDonBO.updateCTHD(chiTietHoaDon);
									//xoa cthd ben 1
									hoaDonBO.deleteChiTietHoaDon(cthdTach.getMaCTHD());
								}
								//neu k max
								else{
									//giamsoluong ben 1 
									cthdTach.setSoLuongMua(cthdTach.getSoLuongMua() - soLuongTach);
									hoaDonBO.updateCTHD(cthdTach);
									//tang ben 2
									chiTietHoaDon.setSoLuongMua(chiTietHoaDon.getSoLuongMua() + soLuongTach);
									hoaDonBO.updateCTHD(chiTietHoaDon);
								}
								ck = true;
								break;
							}
						}
						if(!ck){
						//neu chua co
						//neu chuyen max
							if(cthdTach.getSoLuongMua() == soLuongTach){
							//Doi ma hoa don cua cthd
								cthdTach.setMaHD(hoaDonBan2.getMaHD());
								hoaDonBO.updateCTHD(cthdTach);
							}
						//neu chuyen k max
							else{
							//giam ben 1
								cthdTach.setSoLuongMua(cthdTach.getSoLuongMua() - soLuongTach);
								hoaDonBO.updateCTHD(cthdTach);
							////Tạo ms 1 cthd vs soluong giảm 
								hoaDonBO.addCTHD(new ChiTietHoaDon(soLuongTach, hoaDonBan2.getMaHD(), cthdTach.getMaMon()));
							}
						}
					}
				}
			}

			RequestDispatcher rd = request.getRequestDispatcher("BanHang_Menu");
			rd.forward(request, response);

		}else response.sendRedirect("BanHang_Menu");
	}

}
