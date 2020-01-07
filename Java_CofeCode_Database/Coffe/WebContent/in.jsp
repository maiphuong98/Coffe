<%@page import="fpt.model.bean.HangBanChay"%>
<%@page import="fpt.model.bean.NhapXuat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="fpt.model.bean.HoaDon"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thống Kê Báo Cáo</title>
</head>
<body>
	<%
	SimpleDateFormat datefmt = new SimpleDateFormat("dd-MM-YYYY");
	DecimalFormat fmt = new DecimalFormat("###,###,###");
	String chonmuc = (String)session.getAttribute("chonmuc"); 
	String ngayBatDau = (String)request.getAttribute("ngayBatDau");
	String ngayKetThuc = (String)request.getAttribute("ngayKetThuc");
	%>
	<div class="wrapper" style="height: auto; min-height: 100%;">
	<h1><p align="center">THỐNG KÊ BÁO CÁO</p></h1>
	<table align="center" style="text-align:left;">
		<tr >
			<th>Họ & Tên :</th>
			<td>Kang Hyo Mun</td>
		</tr>
		<tr>
			<th>Chức Vụ: </th>
			<td>Quản Trị</td>
		</tr>
		<tr>
			<th>Từ Ngày: </th>
			<td><%=request.getAttribute("ngayBatDau") %></td>
			<th>Đến Ngày: </th>
			<td><%=request.getAttribute("ngayKetThuc") %></td>
		</tr>
		<tr>
			<th>Đối Tượng Thống Kê: </th>
			<td>
				<%
					if(chonmuc.equals("banhang")){
						out.print("Bán Hàng");
					}else if(chonmuc.equals("hangnhap")){
						out.print("Hàng Nhập");
					}else if(chonmuc.equals("hangbanchay")){
						out.print("Hàng Bán Chạy");
					}
				%>
			</td>
		</tr>
	</table>
	<table align="center" border="1" style="border-spacing: inherit; text-align: center">
	            <%
		            	if("banhang".equals(chonmuc)){
				%>
				<thead>
		              <tr >
		              	<td >Mã HĐ</td>
		              	<td>Mã NV</td>
		              	<td>Mã Bàn</td>
		              	<td>Ngày Bán</td>
		              	<td>Thành Tiền</td>
		              </tr>
	            </thead>
		        <%			ArrayList<HoaDon> arrHoaDon = (ArrayList<HoaDon>)session.getAttribute("arrHoaDon");
		        			long tongtien = 0;
		            		try{
		            			for(HoaDon hoadon : arrHoaDon){
		            				tongtien = tongtien + hoadon.getThanhTien();
	            %>
	              <tbody>
	              	<tr >
	              		<td><%=hoadon.getMaHD() %></td>
	              		<td><%=hoadon.getMaNV() %></td>
	              		<td><%=hoadon.getMaBan() %></td>
	              		<td><%=datefmt.format(hoadon.getNgayBan()) %></td>
	              		<td><%=fmt.format((double)hoadon.getThanhTien()) %></td>
	              	</tr>
	              </tbody>
	              
	              <%
	            				}
		            		}catch(Exception e){
			    				System.out.println("error");
			    				e.printStackTrace();
		    				}
		          %>
	              <tfoot>
	              		<tr>
	              			<td  colspan="4">Tổng Cộng</td>
	              			<td><%=fmt.format((double)tongtien) %></td>
	              		</tr>
	              </tfoot>
		          <%	
		          		}else if("hangnhap".equals(chonmuc)){
			      %>
					      <thead>
				              <tr>
				              	<td>Mã Xuất Nhập</td>
				              	<td>Ngày Nhập</td>
				              	<td>Ngày Xuất</td>
				              	<td>Số Lượng</td>
				              	<td>Mã Nguyên Liệu</td>
				              	<td>Đơn Giá</td>
				              </tr>
			            </thead>
				        <%			ArrayList<NhapXuat> arrNhapXuat = (ArrayList<NhapXuat>)session.getAttribute("arrNhapXuat");
				        			int tongtien = 0;
				            		try{
				            			for(NhapXuat nhapxuat : arrNhapXuat){
				            				tongtien = tongtien + (nhapxuat.getSoLuong()*nhapxuat.getDonGia());
			            %>
			              <tbody>
			              	<tr>
			              		<td ><%=nhapxuat.getMaNhapXuat() %></td>
			              		<td><%=datefmt.format(nhapxuat.getNgayNhap()) %></td>
			              		<td><%if(nhapxuat.getNgayXuat()==null){ out.print("-");}else {out.print(datefmt.format(nhapxuat.getNgayXuat()));} %></td>
			              		<td><%=nhapxuat.getSoLuong() %></td>
			              		<td><%=nhapxuat.getMaNguyenLieu() %></td>
			              		<td><%=fmt.format((double)nhapxuat.getDonGia()) %></td>
			              	</tr>
			              </tbody>
			              
			              <%
			            				}
				            		}catch(Exception e){
					    				System.out.println("error");
					    				e.printStackTrace();
				    				}
				           %>
				          
				    	<tfoot>
		              		<tr>
		              			<td>Tổng Cộng</td>
		              			<td></td>
		              			<td></td>
		              			<td></td>
		              			<td></td>
		              			<td ><%=fmt.format((double)tongtien) %></td>
		              		</tr>
	             		</tfoot>
	             		<%
		          			}else if("hangbanchay".equals(chonmuc)){
		      			%>
						      <thead>
					              <tr>
					              	<td>Tên Món</td>
					              	<td>Ngày Bán</td>
					              	<td>Số Lượng Bán</td>
					              </tr>
			            	</thead>
					       <%		ArrayList<HangBanChay> arrNhapXuat = (ArrayList<HangBanChay>)session.getAttribute("arrHangBanChay");
				            		try{
				            			for(HangBanChay hangbanchay : arrNhapXuat){
			            	%>
				         		<tbody>
					              	<tr>
					              		<td><%=hangbanchay.getTenMon() %></td>
					              		<td><%=datefmt.format(hangbanchay.getNgayBan()) %></td>
					              		<td><%=hangbanchay.getSoLuongMua() %></td>
					              	</tr>
			              		</tbody>
				              
				              <%
				            				}
					            		}catch(Exception e){
						    				System.out.println("error");
						    				e.printStackTrace();
					    				}
					           %>
					          
					    	<tfoot>
			              		<tr>
			              		</tr>
	             			</tfoot>
	             		<%
		          			}
				        %>
	            </table>
	       </div>
</body>
</html>