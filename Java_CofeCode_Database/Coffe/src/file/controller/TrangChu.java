package fpt.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.common.common;
import fpt.model.bean.HoaDon;
import fpt.model.bean.NhanVien;
import fpt.model.bo.HoaDonBO;

/**
 * Servlet implementation class TrangChu
 */
@WebServlet("/TrangChu")
public class TrangChu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrangChu() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

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
				try{
					ArrayList<Long> lstTien = new ArrayList<>();

					Calendar ngayHienTai = Calendar.getInstance();
					//Lấy list 7 ngày gần nhất
					ArrayList<Date> lstDate = new ArrayList<>();
					for(int i = 1 ; i <= 7; i++){
						lstDate.add(ngayHienTai.getTime());
						ngayHienTai.add(Calendar.DAY_OF_MONTH, -1);
					}

					//Đổi sang list ngày string
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // Chuẩn sql
					SimpleDateFormat sdfVN = new SimpleDateFormat("dd/MM/yyyy"); //Chuẩn VN
					ArrayList<String> lstDateString = new ArrayList<>();
					ArrayList<String> lstDateStringVN = new ArrayList<>();	//List này để request về hiển thị
					for(Date d : lstDate){
						lstDateString.add(sdf.format(d));
						lstDateStringVN.add(sdfVN.format(d));
					}

					ArrayList<HoaDon> lstHoaDon = null;
					long tongTien = 0;
					for(String s : lstDateString){
						tongTien = 0;
						lstHoaDon = hoaDonBO.selectHoaDonByDate(s);
						for(HoaDon hoaDon:lstHoaDon)
							tongTien+=hoaDon.getThanhTien();
						lstTien.add(tongTien);	
					}

					//Lấy list Hóa đơn đã trả tiền của ngày hôm nay & hôm qua
					ArrayList<HoaDon> hoaDonHomNay = hoaDonBO.selectHoaDonByDate(lstDateString.get(0));
					ArrayList<HoaDon> hoaDonHomQua = hoaDonBO.selectHoaDonByDate(lstDateString.get(1));
					//Doanh thu hôm nay

					//Tính tỉ lệ doanh thu
					long tienHomNay = 0;
					long tienHomQua = 0;
					
					for(HoaDon h1 : hoaDonHomNay)
						tienHomNay += h1.getThanhTien();
					for(HoaDon h2 : hoaDonHomQua)
						tienHomQua += h2.getThanhTien();
					
					float tiLeDoanhThu = 0F;
					try{
						tiLeDoanhThu = ((float)tienHomNay / (float)tienHomQua) * 100;

					}catch (Exception e) {
						if(hoaDonHomQua == null || hoaDonHomQua.size() == 0 )
							tiLeDoanhThu = hoaDonHomNay.size() * 100;
					}

					request.setAttribute("toDay", hoaDonHomNay);
					//10 mặt hàng bán chạy nhất trong tháng
					request.setAttribute("top10Hang", hoaDonBO.getTop10MatHang(new Date().getMonth()+1));
					//Ti le Doanh thu
					request.setAttribute("tiLeDoanhThu", tiLeDoanhThu);
					//Top 10 hóa đơn 
					request.setAttribute("top10", hoaDonBO.selectTop10());
					request.setAttribute("lstTien", lstTien);
					request.setAttribute("lstDateStringVN", lstDateStringVN);

				}catch (Exception e) {
				}
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
	}
}
