package fpt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.model.bean.Ban;
import fpt.model.bean.HoaDon;
import fpt.model.bo.BanBO;
import fpt.model.bo.HoaDonBO;

/**
 * Servlet implementation class BanHang_LoadModal
 */
@WebServlet("/BanHang_LoadModal")
public class BanHang_LoadModal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BanHang_LoadModal() {
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
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("modal")!=null){
			String modal = request.getParameter("modal");
			
			if("chuyenban".equals(modal)){
				ArrayList<Ban> arrBan = new BanBO().getListBan();
				Collections.sort(arrBan, Ban.compare);
				
				request.setAttribute("dsBan", arrBan);
				
				
				RequestDispatcher rd = request.getRequestDispatcher("./BanHang-Action/BanHang-ChuyenBan.jsp");
				rd.forward(request, response);
				
			}else if("gopban".equals(modal)){
				ArrayList<Ban> arrBan = new BanBO().getListBan();
				Collections.sort(arrBan, Ban.compare);
				
				request.setAttribute("dsBan", arrBan);
				
				RequestDispatcher rd = request.getRequestDispatcher("./BanHang-Action/BanHang-GopBan.jsp");
				rd.forward(request, response);
			}else if("tachban".equals(modal)){
				HoaDonBO hoaDonBO = new HoaDonBO();
				BanBO banBO =new BanBO();
				String maBan = request.getParameter("maban");
				HoaDon hoaDon = hoaDonBO.getHoaDon(maBan);
				
				if(hoaDon != null){
					request.setAttribute("dsCTHD", hoaDonBO.getListChiTietHoaDon(hoaDon.getMaHD()));
				}
				ArrayList<Ban> dsBan = banBO.getListBan();
				Collections.sort(dsBan, Ban.compare);
				Ban ban = banBO.getBan(maBan);
				//Xóa bàn đang tách trong ds trả về
				for(int i=0; i<dsBan.size(); i++)
					if(dsBan.get(i).getMaBan().equals(ban.getMaBan())){
						dsBan.remove(i);
						break;
					}
				
				request.setAttribute("dsBan", dsBan);
				request.setAttribute("ban", ban);
				
				RequestDispatcher rd = request.getRequestDispatcher("./BanHang-Action/BanHang-TachBan.jsp");
				rd.forward(request, response);
			}
		}
	}

}
