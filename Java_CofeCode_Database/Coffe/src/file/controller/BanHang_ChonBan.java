package fpt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.model.bean.ChiTietHoaDon;
import fpt.model.bean.HoaDon;
import fpt.model.bean.ThongTinDatBan;
import fpt.model.bo.DatBanBO;
import fpt.model.bo.HoaDonBO;

/**
 * Servlet implementation class BanHang_ChonBan
 */
@WebServlet("/BanHang_ChonBan")
public class BanHang_ChonBan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BanHang_ChonBan() {
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
	DatBanBO datBanBO = new DatBanBO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HoaDon hoaDon = null;
		ArrayList<ChiTietHoaDon> arrChiTietHoaDon = null;
		ThongTinDatBan thongTinDatBan = null;
		
		if(request.getParameter("maban")!= null){
			String maBan = request.getParameter("maban");
			//
			thongTinDatBan = datBanBO.getThongTinDatBan(maBan);
			if(thongTinDatBan != null){
				request.setAttribute("thongTinDatBan", thongTinDatBan);
			}else{
				// lấy hóa đơn của bàn đó
				hoaDon = hoaDonBO.getHoaDon(maBan);
				// lấy list chi tiết hóa đơn của bàn đó
				if(hoaDon != null) arrChiTietHoaDon = hoaDonBO.getListChiTietHoaDon(hoaDon.getMaHD());
				request.setAttribute("danhSachChiTietHoaDon", arrChiTietHoaDon);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("./BanHang-Action/BanHang-danhSachChiTietHoaDon.jsp");
			rd.forward(request, response);
			
		}
	}

}
