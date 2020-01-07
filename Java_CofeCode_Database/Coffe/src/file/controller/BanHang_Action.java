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
import fpt.model.bean.ThongTinDatBan;
import fpt.model.bo.BanBO;
import fpt.model.bo.DatBanBO;
import fpt.model.bo.HoaDonBO;
import fpt.model.bo.NhanVienBO;

/**
 * Servlet implementation class BanHang_Action
 */
@WebServlet("/BanHang_Action")
public class BanHang_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BanHang_Action() {
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

		//Nếu chọn btn Thanh toán
		if(request.getParameter("thanhtoan")!=null){
			String maBan = request.getParameter("thanhtoan");
			//Lấy hóa đơn của bàn
			HoaDon hoaDon = hoaDonBO.getHoaDon(maBan);
			if(hoaDon!=null){
				// CHuyển sang trạng thái đã trả tiền
				hoaDonBO.thanhToan(hoaDon.getMaHD());
				// Chuyển bàn sang trống
				banBO.updateStatus("Trống", maBan);
			}
		}
		//Nếu chọn nút xóa trong ds chi tiết hóa đơn
		else if(request.getParameter("xoacthd")!=null){
			long maChiTietHoaDon = Long.parseLong(request.getParameter("xoacthd"));
			hoaDonBO.deleteChiTietHoaDon(maChiTietHoaDon);
			return;
			//Neeus thay số lượng
		}else if(request.getParameter("thaysoluong")!=null){
			long maChiTietHoaDon = Long.parseLong(request.getParameter("thaysoluong")); 
			
			
			long soLuong = 1;
			try{
				soLuong = Long.parseLong(request.getParameter("soluong")); 
			}catch (Exception e) {
				soLuong = 1;
			}
			if(soLuong < 1 || soLuong > 10000)
				soLuong = 1;
			hoaDonBO.updateSoLuongChiTietHoaDon(maChiTietHoaDon, soLuong);
			return;
			//Nếu chọn btn Đặt bàn
		}else if(request.getParameter("datban")!=null){
			String maBan = request.getParameter("datban");
			String tenKH = request.getParameter("tenKH");
			String sdt = request.getParameter("sdt");
			String ngay = request.getParameter("ngay");
			String gio = request.getParameter("gio");

			new DatBanBO().addThongTinDatBan(new ThongTinDatBan(tenKH, sdt, ngay, gio, maBan));
			banBO.updateStatus("Đã đặt", maBan);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("BanHang_Menu");
			rd.forward(request, response);
			//Nếu đồng ý hủy bàn
		}else if(request.getParameter("huyban")!=null){
			String maBan = request.getParameter("huyban");

			//Lấy hóa đơn của bàn
			HoaDon hoaDon = hoaDonBO.getHoaDon(maBan);
			if(hoaDon!=null){
				//Lấy ds chi tiết hóa đơn của bàn đó và xóa
				for(ChiTietHoaDon chiTietHoaDon: hoaDonBO.getListChiTietHoaDon(hoaDon.getMaHD()))
					hoaDonBO.deleteChiTietHoaDon(chiTietHoaDon.getMaCTHD());
				//Xóa hóa đơn đó
				hoaDonBO.deleteHoaDon(hoaDon.getMaHD());
			}

			//Xóa thong tin đặt bàn của bàn đó nếu có 
			new DatBanBO().deleteThongTinDatBan(maBan);
			banBO.updateStatus("Trống", maBan);
			return;


		}
		//Nếu đồng ý chọn chuyển bàn 
		else if(request.getParameter("chuyenban")!=null){
			String ban1 = request.getParameter("chuyenban");
			String ban2 = request.getParameter("banchuyenden");

			//Lấy hóa đơn của bàn
			HoaDon hoaDon = hoaDonBO.getHoaDon(ban1);
			//Nếu hóa đơn khác null thì chuyển qua chuyển thông tin đặt bàn
			if(hoaDon!=null){
				hoaDonBO.chuyenBanHoaDon(hoaDon.getMaHD(), ban2);
				banBO.updateStatus("Đang sử dụng", ban2);
			}else{
				DatBanBO datBanBO = new DatBanBO();

				datBanBO.chuyenThongTinDatBan(datBanBO.getThongTinDatBan(ban1).getMaThongTinDatBan(), ban2);
				banBO.updateStatus("Đã đặt", ban2);
			}

			banBO.updateStatus("Trống", ban1);

			return;
		}
		//Nếu đồng ý chọn gộp bàn
		else if(request.getParameter("gopban")!=null){

			String ban1 = request.getParameter("gopban");
			String ban2 = request.getParameter("ban2");

			HoaDon hoaDonBan1 = null;
			HoaDon hoaDonBan2 = null;
			ArrayList<ChiTietHoaDon> arrCT1=null;
			ArrayList<ChiTietHoaDon> arrCT2=null;


			// nếu mã bàn khác nhau thì mới gộp
			if(!ban1.equals(ban2)){

				hoaDonBan1 = hoaDonBO.getHoaDon(ban1);
				hoaDonBan2 = hoaDonBO.getHoaDon(ban2);

				arrCT1 = hoaDonBO.getListChiTietHoaDon(hoaDonBan1.getMaHD());

				
				//check xem bàn 2 có hóa đơn chưa

				if(hoaDonBan2 != null){
					// nếu có 

					arrCT2 = hoaDonBO.getListChiTietHoaDon(hoaDonBan2.getMaHD());
					
					ArrayList<ChiTietHoaDon> arrCTHD2_bansao1 = new ArrayList<ChiTietHoaDon>();
					ArrayList<ChiTietHoaDon> arrCTHD2_bansao2 = new ArrayList<ChiTietHoaDon>();
					for(ChiTietHoaDon cthd1 : arrCT1)
						arrCTHD2_bansao1.add(cthd1);
					for(ChiTietHoaDon cthd2 : arrCT2)
						arrCTHD2_bansao2.add(cthd2);
					
					boolean ck = false;
					
					for(int i = 0; i< arrCT1.size(); i++){
						for(int j = 0; j < arrCT2.size(); j++){
							if(arrCT2.get(j).getMaMon().equals(arrCT1.get(i).getMaMon())){
								
								for(ChiTietHoaDon arr : arrCTHD2_bansao2){
									if(arr.getMaCTHD() == arrCT2.get(j).getMaCTHD()){
										arr.setSoLuongMua(arrCT2.get(j).getSoLuongMua()+arrCT1.get(i).getSoLuongMua());
										break;
									}
								}

//								hoaDonBO.updateCTHD(ct2);
//								hoaDonBO.deleteChiTietHoaDon(ct1.getMaCTHD());
								ck=true;
								break;
							}
						}
						if(!ck){
							//Nếu chưa có thì chuyển chi tiết hóa đơn sang hóa đơn bàn 2
							arrCT1.get(i).setMaHD(hoaDonBan2.getMaHD());
							//Thêm vào bản sao 2
							arrCTHD2_bansao2.add(arrCT1.get(i));
							//Xóa tương ứng ở ptu 1,  những cthd đã chuyển (sau xóa mảng này)
							for(int z = 0; z < arrCTHD2_bansao1.size(); z++){
								if(arrCTHD2_bansao1.get(z).getMaCTHD() == arrCT1.get(i).getMaCTHD())
									arrCTHD2_bansao1.remove(z);
							}
						//	hoaDonBO.updateCTHD(ct1);
						}
						ck=false;
					}
					
					//Xóa những cthd thừa
					for(ChiTietHoaDon c1 : arrCTHD2_bansao1)
						hoaDonBO.deleteChiTietHoaDon(c1.getMaCTHD());
					//update lại những cthd
					for(ChiTietHoaDon c2: arrCTHD2_bansao2)
						hoaDonBO.updateCTHD(c2);

				}else{
					//Nếu chưa có hóa đơn
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
					
					hoaDonBO.addHoaDon(new HoaDon(nhanVien.getMaNV(), ban2, new Date(), false, 0));
					
					hoaDonBan2 = hoaDonBO.getHoaDon(ban2);
					//Set trạng thái bàn thành đang sử dụng
					banBO.updateStatus("Đang sử dụng", ban2);

					//Chuyển cthd từ ban 1 sang ban 2
					for(ChiTietHoaDon ct1 : arrCT1){
						ct1.setMaHD(hoaDonBan2.getMaHD());
						hoaDonBO.updateCTHD(ct1);
					}
				}

				hoaDonBO.deleteHoaDon(hoaDonBan1.getMaHD());
				banBO.updateStatus("Trống", ban1);
			}

		}

	}

}

