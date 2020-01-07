<%@page import="fpt.model.bean.HangBanChay"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="fpt.model.bean.NhapXuat"%>
<%@page import="fpt.model.bean.HoaDon"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Trang chủ - CAFE</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("input[value='xem']").click(function(){
			if($("#ngayKetThuc").val() == "" || $("#ngayBatDau").val() == ""){
				alert('Vui Lòng Nhập Thời Gian');
				return false;
			}else{
				var yearOfStarDate = $("#ngayBatDau").val().slice(0,$("#ngayBatDau").val().indexOf("-"));
				var yearOfEndDate = $("#ngayKetThuc").val().slice(0,$("#ngayKetThuc").val().indexOf("-"));
				var yearNow = new Date();
				if(yearOfStarDate > yearNow.getFullYear() || yearOfEndDate > yearNow.getFullYear() || yearOfStarDate < 1900 || yearOfEndDate < 1900 ){
					alert('Vui Lòng Nhập Đúng Thời Gian');
					return false;
				}
				
			}
		});
	});
</script>
<%@include file="./Shared/_bootstrap.jsp"%>
</head>
<body class="fixed sidebar-mini sidebar-mini-expand-feature skin-black-light"
	style="height: auto; min-height: 100%;">
	<!-- Site wrapper -->
	<div class="wrapper" style="height: auto; min-height: 100%;">
		<%@include file="./Shared/_main-header.jsp"%>
		<%@include file="./Shared/_main-sidebar.jsp"%>
		
		<form action="ThongKeBaoCaoServlet" method="post">
		<div class="content-wrapper" style="min-height: 621px;">
			<section class="content">
				<div align="center">
					<label>Chọn mục: </label>
					<input type="radio" name="chonmuc" value="banhang" checked="checked">Bán Hàng
					<input type="radio" name="chonmuc" value="hangnhap">Hàng Nhập
					<input type="radio" name="chonmuc" value="hangbanchay">Hàng Bán Chạy
				</div>
				<table align="center">
					<tr>
						<td><label>Từ Ngày: </label></td>
						<td>
							<div class="input-group date">
			                  <div class="input-group-addon">
			                    <i  class="fa fa-calendar"></i>
			                  </div>
			                  <input type="date" id="ngayBatDau" name="ngayBatDau" class="form-control pull-right">
			                </div>
						</td>
						<td><label>Đến Ngày: </label></td>
						<td>
							<div class="input-group date">
			                  <div class="input-group-addon">
			                    <i  class="fa fa-calendar"></i>
			                  </div>
			                  <input type="date" id="ngayKetThuc" name="ngayKetThuc" class="form-control pull-right">
			                </div>
						</td>
						<td><input type="submit" name="xem" value="xem" ></td>
					</tr>
				</table>
				
                <div class="box-body">
	            <table id="example2" class="table table-bordered table-hover">
	            <%
	            		SimpleDateFormat datefmt = new SimpleDateFormat("dd-MM-YYYY");
	            		DecimalFormat fmt = new DecimalFormat("###,###,###");
		            	String chonmuc = (String)session.getAttribute("chonmuc");
		            	if("banhang".equals(chonmuc)){
				%>
				<thead>
		              <tr>
		              	<td>Mã HĐ</td>
		              	<td>Mã NV</td>
		              	<td>Mã Bàn</td>
		              	<td>Ngày Bán</td>
		              	<td>Thành Tiền(VNĐ)</td>
		              </tr>
	            </thead>
		        <%			ArrayList<HoaDon> arrHoaDon = (ArrayList<HoaDon>)session.getAttribute("arrHoaDon");
		        			long tongtien = 0;
		            		try{
		            			for(HoaDon hoadon : arrHoaDon){
		            				tongtien = tongtien + hoadon.getThanhTien();
	            %>
	              <tbody>
	              	<tr>
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
			    				System.out.println("errorHoaDonjsp");
			    				e.printStackTrace();
		    				}
		          %>
	              <tfoot>
	              		<tr>
	              			<td>Tổng Cộng</td>
	              			<td></td>
	              			<td></td>
	              			<td></td>
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
				              	<td>Đơn Giá(VNĐ)</td>
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
			              		<td><%=nhapxuat.getMaNhapXuat() %></td>
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
					    				System.out.println("errorhangnhapjsp");
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
		              			<td><%=fmt.format((double)tongtien) %></td>
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
				        <%			ArrayList<HangBanChay> arrNhapXuat = (ArrayList<HangBanChay>)session.getAttribute("arrHangBanChay1");
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
					    				System.out.println("errorhangbanchayjsp");
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
	            </form>
	            
	            <div>
	            	<table style="width: 100%">
	            		<div>
	            			<tr>
	            			<form action="XuatFileServlet" method="post">
	            				<div class="modal fade" id="modal-default">
						          <div class="modal-dialog">
						            <div class="modal-content">
						              <div class="modal-header">
						                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						                  <span aria-hidden="true">&times;</span></button>
						                <h4 class="modal-title">Vui Lòng Nhập Tên Cần Xuất</h4>
						              </div>
						              <div class="modal-body">
						                <input class="form-control" type="text" name="filename">
						              </div>
						              <div class="modal-footer">
						                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Đóng</button>
						                <button type="submit" name="xuatfile" value="xuatfile" class="btn btn-primary">Xuất File</button>
						              </div>
						            </div>
						            <!-- /.modal-content -->
						          </div>
						          <!-- /.modal-dialog -->
						        </div>
	            				
	            				<th align="center" style="width: 50%;">
	            					<label>Chọn Định Dạng: </label><br>
	            					<input type="radio" name="chondinhdang" value="excel" checked="checked">File Excel<br>
									<input type="radio" name="chondinhdang" value="text">File Text<br>
									<!-- <input type="submit" name="xuatfile" value="xuatfile"> -->
									<button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-default">
						                Xuất File
						              </button>
	            				</th>
	            			</form>
	            			<form action="InServlet" method="post" >
	            				<th style="width: 50%">
	            					<label>Kho Giay </label>
	            					<select name="khoGiay">
	            						<option value="A0">A0</option>
	            						<option value="A1">A1</option>
	            						<option value="A2">A2</option>
	            						<option value="A3">A3</option>
	            					</select><br>
	            					<label>May In </label>
	            					<select name="loaiMay">
	            						<option value="hplazer">Hp Laser</option>
	            					</select><br>
	            					<label>So Luong </label>
	            					<input type="text" name="soluong" value="1"><br>
	            					<button type="submit" name="in" value="in">In</button>
									<!-- <input type="submit" name="in" value="in"> -->
	            				</th>
	            			</form>
	            			</tr>
	            		</div>
	            	</table>
	            </div>
			</section>
		</div>
		
		<%@include file="./Shared/_main-footer.jsp"%>
	</div>
	<%@include file="./Shared/_js.jsp"%>
	
</body>
</html>