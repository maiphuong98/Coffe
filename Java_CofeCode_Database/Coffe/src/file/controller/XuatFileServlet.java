package fpt.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.common.fileReader;
import fpt.model.bean.HangBanChay;
import fpt.model.bean.HoaDon;
import fpt.model.bean.NhapXuat;

/**
 * Servlet implementation class XuatFileServlet
 */
@WebServlet("/XuatFileServlet")
public class XuatFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuatFileServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		fileReader xuatfile = new fileReader();
		HttpSession session = request.getSession();
		String filename = request.getParameter("filename");
		String chonmuc = (String)session.getAttribute("chonmuc");
		String chondinhdang = (String) request.getParameter("chondinhdang");
		if(chonmuc.equals("banhang")){
			ArrayList<HoaDon> arrHoaDon = (ArrayList<HoaDon>)session.getAttribute("arrHoaDon");
			if(chondinhdang.equals("excel")){
				xuatfile.xuatFileHoaDon(filename, "excel", arrHoaDon);
			}else if(chondinhdang.equals("text")){
				xuatfile.xuatFileHoaDon(filename,"txt", arrHoaDon);
			}
		}else if(chonmuc.equals("hangnhap")){
			ArrayList<NhapXuat> arrNhapXuat = (ArrayList<NhapXuat>)session.getAttribute("arrNhapXuat");
			if(chondinhdang.equals("excel")){
				xuatfile.xuatFileNhapXuat(filename,"excel", arrNhapXuat);
			}else if(chondinhdang.equals("text")){
				xuatfile.xuatFileNhapXuat(filename, "txt", arrNhapXuat);
			}
		}else if(chonmuc.equals("hangbanchay")){
			ArrayList<HangBanChay> arrHangBanChay = (ArrayList<HangBanChay>)session.getAttribute("arrHangBanChay1");
			if(chondinhdang.equals("excel")){
				xuatfile.xuatFileHangBanChay(filename,"excel", arrHangBanChay);
			}else if(chondinhdang.equals("text")){
				xuatfile.xuatFileHangBanChay(filename, "txt", arrHangBanChay);
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("ThongKeBaoCao.jsp");
		rd.forward(request, response);
		
	}

}
