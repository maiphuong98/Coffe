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

import fpt.model.bean.HoaDon;
import fpt.model.bo.HoaDonBO;

/**
 * Servlet implementation class TrangChu_ThongKe
 */
@WebServlet("/TrangChu_ThongKe")
public class TrangChu_ThongKe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrangChu_ThongKe() {
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

		if(request.getParameter("top10MatHangTheoSoLuong")!=null){

			request.setAttribute("top10Hang", hoaDonBO.getTop10MatHangTheoSoLuong(new Date().getMonth()+1));

		}else if(request.getParameter("top10MatHangTheoDoanhThu")!=null){

			request.setAttribute("top10Hang", hoaDonBO.getTop10MatHang(new Date().getMonth()+1));

		}else if(request.getParameter("7ngay")!=null){
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
			request.setAttribute("lstTien", lstTien);
			request.setAttribute("lstDateStringVN", lstDateStringVN);

		}else if(request.getParameter("3thang")!=null){
			ArrayList<Long> lstTien = new ArrayList<>();

			Calendar ngayHienTai = Calendar.getInstance();
			ArrayList<Date> lstDate = new ArrayList<>();
			for(int i = 1 ; i <= 3; i++){
				lstDate.add(ngayHienTai.getTime());
				ngayHienTai.add(Calendar.MONTH, -1);
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
				lstHoaDon = hoaDonBO.selectHoaDonByMonth(s);
				for(HoaDon hoaDon:lstHoaDon)
					tongTien+=hoaDon.getThanhTien();
				lstTien.add(tongTien);	
			}
			request.setAttribute("lstTien", lstTien);
			request.setAttribute("lstDateStringVN", lstDateStringVN);
			request.setAttribute("lstTien", lstTien);
			request.setAttribute("lstDateStringVN", lstDateStringVN);
		}


		RequestDispatcher rd = request.getRequestDispatcher("ThongKe/ThongKe-TrangChu.jsp");
		rd.forward(request, response);
	}

}
