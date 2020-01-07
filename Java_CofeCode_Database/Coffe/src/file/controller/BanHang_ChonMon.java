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
import javax.servlet.http.HttpSession;

import fpt.model.bean.ChiTietHoaDon;
import fpt.model.bean.HoaDon;
import fpt.model.bean.NhanVien;
import fpt.model.bo.BanBO;
import fpt.model.bo.HoaDonBO;
import fpt.model.bo.NhanVienBO;

/**
 * Servlet implementation class BanHang_ChonMon
 */
@WebServlet("/BanHang_ChonMon")
public class BanHang_ChonMon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BanHang_ChonMon() {
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
		
		String maBan = request.getParameter("maban");
		String maMon = request.getParameter("mamon");
		
		//check xem bàn có hóa đơn chưa
		HoaDon hoaDon = hoaDonBO.getHoaDon(maBan);
		if(hoaDon != null){
			// nếu có 
			
			//Kiểm tra món đó đã tồn tại trong ctht của bàn đó chưa, nếu có thì update số lượng
			
			ArrayList<ChiTietHoaDon> arrChiTietHoaDon = hoaDonBO.getListChiTietHoaDon(hoaDon.getMaHD());
			
			boolean chk = false;
			for(ChiTietHoaDon chiTietHoaDon : arrChiTietHoaDon){
				if(chiTietHoaDon.getMaHD() == hoaDon.getMaHD() && chiTietHoaDon.getMaMon().equals(maMon)){
					chiTietHoaDon.setSoLuongMua(chiTietHoaDon.getSoLuongMua()+1);
					hoaDonBO.updateCTHD(chiTietHoaDon);
					chk=true;
					break;
				}	
			}
			// nếu trong arr chưa có thì tạo mới 1 chitiethoadon
			if(!chk) 
				hoaDonBO.addCTHD(new ChiTietHoaDon(1,hoaDon.getMaHD(),maMon));
			
		}else{
			//Nếu chưa
			
			//tạo mới 1 hóa đơn
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
			
			hoaDonBO.addHoaDon(new HoaDon(nhanVien.getMaNV(), maBan, new Date(), false, 0));
			hoaDon = hoaDonBO.getHoaDon(maBan);
			//Set trạng thái bàn thành đang sử dụng
			banBO.updateStatus("Đang sử dụng", maBan);
			
			//tạo mới 1 chitiethoadon
			hoaDonBO.addCTHD(new ChiTietHoaDon(1,hoaDon.getMaHD(),maMon));
			
		}
			
		request.setAttribute("danhSachChiTietHoaDon", hoaDonBO.getListChiTietHoaDon(hoaDon.getMaHD()));
		RequestDispatcher rd = request.getRequestDispatcher("./BanHang-Action/BanHang-danhSachChiTietHoaDon.jsp");
		rd.forward(request, response);
	}

}
