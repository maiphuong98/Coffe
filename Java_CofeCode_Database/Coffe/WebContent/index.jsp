<%@page import="fpt.model.bean.MatHangBanChay"%>
<%@page import="fpt.model.bo.NhanVienBO"%>
<%@page import="fpt.common.common"%>
<%@page import="fpt.model.bean.HoaDon"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Trang chủ - CAFE</title>

<%@include file="./Shared/_bootstrap.jsp"%>
</head>
<body
	class="fixed sidebar-mini sidebar-mini-expand-feature skin-black-light"
	style="height: auto; min-height: 100%;">
	<!-- Site wrapper -->
	<div class="wrapper" style="height: auto; min-height: 100%;">
		<%@include file="./Shared/_main-header.jsp"%>
		<%@include file="./Shared/_main-sidebar.jsp"%>




		<!-- Content Wrapper. Contains page content -->


		<div class="content-wrapper" style="min-height: 621px;">
			<!-- Content Header (Page header) -->
			<section class="content-header"></section>

			<!-- Main content -->
			<section class="content">


				<div class="row">
					<div class="col-lg-9 col-xs-9">

						<div class="row">
							<div class="col-md-12">

								<!-- Thống kê nhỏ -->

								<!-- /.col -->
								<div class="row">
									<div class="col-lg-12">
										<div class="box" style="border-top: 0px; margin-bottom: 3px;">
											<h4
												style="margin-top: 3px; margin-left: 15px; margin-bottom: 3px; border-bottom-width: 10px; padding-bottom: 5px; padding-top: 5px;">
												<b>KẾT QUẢ BÁN HÀNG HÔM NAY.</b>
											</h4>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-4 col-xs-12">
										<!-- small box -->
										<div class="small-box bg-aqua">
											<div class="inner">
												<h3>
													<%
														long doanhThuHomNay = 0;
														if (request.getAttribute("toDay") != null) {
															ArrayList<HoaDon> hoaDonHomNay = (ArrayList<HoaDon>) request.getAttribute("toDay");
															for (HoaDon hoaDon : hoaDonHomNay)
																doanhThuHomNay += hoaDon.getThanhTien();
													%><%=hoaDonHomNay.size()%>
													<%
														}
													%>
												</h3>

												<p>HÓA ĐƠN MỚI</p>
											</div>
											<div class="icon">
												<i class="fa fa-shopping-cart"></i>
											</div>
										</div>
									</div>
									<!-- ./col -->
									<div class="col-lg-4 col-xs-12">
										<!-- small box -->
										<div class="small-box bg-green">
											<div class="inner">
												<h3>
													<%
														if (request.getAttribute("tiLeDoanhThu") != null) {
													%><%=Math.round(Float.parseFloat(request.getAttribute("tiLeDoanhThu").toString()) * 100) / 100%>
													<%
														}
													%><sup style="font-size: 20px">%</sup>
												</h3>

												<p>SO VỚI HÔM QUA</p>
											</div>
											<div class="icon">
												<i class="ion ion-stats-bars"></i>
											</div>
										</div>
									</div>
									<!-- ./col -->
									<div class="col-lg-4 col-xs-12">
										<!-- small box -->
										<div class="small-box bg-yellow">
											<div class="inner">
												<h3><%=new common().fomatTien(doanhThuHomNay)%></h3>

												<p>DOANH THU TRONG NGÀY</p>
											</div>
											<div class="icon">
												<i class="fa fa-money"></i>
											</div>
										</div>
									</div>

								</div>


								<!-- End thống kê nhỏ -->

							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<!-- Chart 1-->

								<div class="box box-success">
									<div class="box-header with-border">
										<h3 class="box-title">
											<b>TỔNG DOANH THU CỦA QUÁN.</b>
										</h3>

										<div class="box-tools pull-right">
											<ul class="nav nav-tabs">
												<li class="dropdown"><a class="dropdown-toggle"
													data-toggle="dropdown"  aria-expanded="false">
														THỐNG KÊ THEO <span class="caret"></span>
												</a>
													<ul class="dropdown-menu">
														<li role="presentation"><a role="menuitem"
															tabindex="-1"  onclick="loadChart('7ngay')">7 NGÀY GẦN NHẤT</a></li>
														<li role="presentation"><a role="menuitem"
															tabindex="-1"  onclick="loadChart('3thang')">3 THÁNG GẦN NHẤT</a></li>
													</ul></li>
											</ul>
										</div>

									</div>
									<div class="box-body">
										<div class="chart">
											<canvas id="barChart" style="height: 230px; width: 510px;"
												width="510" height="230"></canvas>
										</div>
									</div>
									<!-- /.box-body -->
								</div>

								<!-- End Chart 1-->

								<div class="box box-success">
									<div class="box-header with-border">
										<h3 class="box-title">
											<b>TOP 10 HÀNG HÓA BÁN CHẠY THÁNG NÀY.</b>
										</h3>

										<div class="box-tools pull-right">
											<ul class="nav nav-tabs">
												<li class="dropdown"><a class="dropdown-toggle"
													data-toggle="dropdown" aria-expanded="false">
														THỐNG KÊ THEO <span class="caret"></span>
												</a>
													<ul class="dropdown-menu">
														<li role="presentation"><a role="menuitem"
															tabindex="-1"  onclick="loadChart('top10MatHangTheoDoanhThu')">THEO DOANH THU</a></li>
														<li role="presentation"><a role="menuitem"
															tabindex="-1"  onclick="loadChart('top10MatHangTheoSoLuong')">THEO SỐ LƯỢNG</a></li>
													</ul></li>
											</ul>
										</div>
									</div>
									<div class="box-body">
										<div class="chart">
											<canvas id="barChart2" style="height: 230px; width: 510px;"
												width="510" height="230"></canvas>
										</div>
									</div>
									<!-- /.box-body -->
								</div>

								<!-- End Chart 2-->

							</div>
						</div>

					</div>
					<div class="col-lg-3 col-xs-3">

						<!-- TimeLine -->
						<div class="row">
							<div class="col-md-12">
								<div class=""></div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12">
								<!-- The time line -->
								<ul class="timeline">
									<!-- timeline time label -->
									<li class="time-label"><span class="bg-red"> Các
											hoạt động gần đây </span></li>
									<!-- /.timeline-label -->
									<%
										if (request.getAttribute("top10") != null) {
											ArrayList<HoaDon> lstHD = (ArrayList<HoaDon>) request.getAttribute("top10");
											common cm = new common();
											if (lstHD != null) {
												NhanVienBO nhanVienBO = new NhanVienBO();
												for (HoaDon hoaDon : lstHD) {
									%>
									<!-- timeline item -->
									<li><i class="fa fa-user bg-aqua"></i>

										<div class="timeline-item">
											<span class="time"><i class="fa fa-clock-o"></i> <%=cm.tinhThoiGianGiua2Ngay(hoaDon.getNgayBan())%></span>

											<h4 class="timeline-header no-border">
												<a href="#"><b><%=nhanVienBO.selectBO(hoaDon.getMaNV()).getHoTen()%></b></a>
												bán đơn hàng với giá trị
												<%=cm.fomatTien(hoaDon.getThanhTien()) + " VNĐ"%>
											</h4>
										</div></li>
									<!-- END timeline item -->
									<%
										}
											}
										}
									%>
									<li><i class="fa fa-clock-o bg-gray"></i></li>

								</ul>
							</div>
							<!-- /.col -->
						</div>

					</div>
				</div>



			</section>
			<!-- /.content -->
		</div>


		<!-- /.content-wrapper -->


		<div style="display: none;" id="content-chart">
									<%
										if (request.getAttribute("lstDateStringVN") != null && request.getAttribute("lstTien") != null) {
											ArrayList<String> lstDateStringVN = (ArrayList<String>) request.getAttribute("lstDateStringVN");
											ArrayList<Long> lstTien = (ArrayList<Long>) request.getAttribute("lstTien");
											int i = 0;
											for (String s : lstDateStringVN) {
									%>
									<p id='<%="date" + i%>'><%=s%></p>
									<%
										i++;
											}
											i = 0;
											for (long t : lstTien) {
									%>
									<p id='<%="tien" + i%>'><%=t%></p>
									<%
										i++;
											}
										}
									%>

									<!-- Chart  2-->
									<%
										if (request.getAttribute("top10Hang") != null) {
											ArrayList<MatHangBanChay> lstMH = (ArrayList<MatHangBanChay>) request.getAttribute("top10Hang");
											int j = 0;
											for (MatHangBanChay mh : lstMH) {
									%>
									<p id='<%="tenMon" + j%>'><%=mh.getTenMon()%></p>
									<p id='<%="tienHang" + j%>'><%=mh.getTongTien()%></p>
									<%
										j++;
											}
									%>

									<%
										}
									%>
								</div>

		<%@include file="./Shared/_main-footer.jsp"%>



	</div>

	<%@include file="./Shared/_js.jsp"%>
	<!-- page script -->
	<script>
		$(function() {
			//--------------
			//- AREA CHART -
			//--------------
			var areaChartData = {
				labels : [ date6, date5, date4, date3, date2, date1, date0 ],
				datasets : [ {
					label : 'Electronics',
					fillColor : 'rgba(210, 214, 222, 1)',
					strokeColor : 'rgba(210, 214, 222, 1)',
					pointColor : 'rgba(210, 214, 222, 1)',
					pointStrokeColor : '#c1c7d1',
					pointHighlightFill : '#fff',
					pointHighlightStroke : 'rgba(220,220,220,1)',
					data : [ tien6, tien5, tien4, tien3, tien2, tien1, tien0 ]
				} ]
			}
			//data 2
			var areaChartData2 = {
				labels : [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ],
				datasets : [ {
					label : 'Electronics',
					fillColor : 'rgba(210, 214, 222, 1)',
					strokeColor : 'rgba(210, 214, 222, 1)',
					pointColor : 'rgba(210, 214, 222, 1)',
					pointStrokeColor : '#c1c7d1',
					pointHighlightFill : '#fff',
					pointHighlightStroke : 'rgba(220,220,220,1)',
					data : [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 1000 ]
				} ]
			}

			//get data chart doanh thu 7 ngày
			for (var i = 0; i < 7; i++) {
				areaChartData.labels[i] = document.getElementById('date' + i).innerHTML;
				areaChartData.datasets[0].data[i] = document
						.getElementById('tien' + i).innerHTML;
			}
			//get data chart top hàng bán chạy trong tháng
			for (var i = 0; i < 10; i++) {
				areaChartData2.labels[i] = document
						.getElementById('tenMon' + i).innerHTML;
				areaChartData2.datasets[0].data[i] = document
						.getElementById('tienHang' + i).innerHTML;
			}
			//-------------
			//- BAR CHART 1-
			//-------------
			var barChartCanvas = $('#barChart').get(0).getContext('2d')
			var barChart = new Chart(barChartCanvas)
			var barChartData = areaChartData
			barChartData.datasets[0].fillColor = '#00a65a'
			barChartData.datasets[0].strokeColor = '#00a65a'
			barChartData.datasets[0].pointColor = '#00a65a'
			var barChartOptions = {
				//Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
				scaleBeginAtZero : true,
				//Boolean - Whether grid lines are shown across the chart
				scaleShowGridLines : true,
				//String - Colour of the grid lines
				scaleGridLineColor : 'rgba(0,0,0,.05)',
				//Number - Width of the grid lines
				scaleGridLineWidth : 1,
				//Boolean - Whether to show horizontal lines (except X axis)
				scaleShowHorizontalLines : true,
				//Boolean - Whether to show vertical lines (except Y axis)
				scaleShowVerticalLines : true,
				//Boolean - If there is a stroke on each bar
				barShowStroke : true,
				//Number - Pixel width of the bar stroke
				barStrokeWidth : 2,
				//Number - Spacing between each of the X value sets
				barValueSpacing : 5,
				//Number - Spacing between data sets within X values
				barDatasetSpacing : 1,
				//String - A legend template
				//Boolean - whether to make the chart responsive
				responsive : true,
				maintainAspectRatio : true
			}

			barChartOptions.datasetFill = false
			barChart.Bar(barChartData, barChartOptions)

			//-------------
			//- BAR CHART 2-
			//-------------
			var barChartCanvas2 = $('#barChart2').get(0).getContext('2d')
			var barChart2 = new Chart(barChartCanvas2)
			var barChartData2 = areaChartData2
			barChartData2.datasets[0].fillColor = '#58bbf5'
			barChartData2.datasets[0].strokeColor = '#58bbf5'
			barChartData2.datasets[0].pointColor = '#00a65a'
			var barChartOptions2 = {
				//Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
				scaleBeginAtZero : true,
				//Boolean - Whether grid lines are shown across the chart
				scaleShowGridLines : true,
				//String - Colour of the grid lines
				scaleGridLineColor : 'rgba(0,0,0,.05)',
				//Number - Width of the grid lines
				scaleGridLineWidth : 1,
				//Boolean - Whether to show horizontal lines (except X axis)
				scaleShowHorizontalLines : true,
				//Boolean - Whether to show vertical lines (except Y axis)
				scaleShowVerticalLines : true,
				//Boolean - If there is a stroke on each bar
				barShowStroke : true,
				//Number - Pixel width of the bar stroke
				barStrokeWidth : 2,
				//Number - Spacing between each of the X value sets
				barValueSpacing : 5,
				//Number - Spacing between data sets within X values
				barDatasetSpacing : 1,
				//String - A legend template
				//Boolean - whether to make the chart responsive
				responsive : true,
				maintainAspectRatio : true
			}

			barChartOptions2.datasetFill = false
			barChart2.Bar(barChartData2, barChartOptions2)
		})
	</script>

	<script type="text/javascript">
		function loadChart(pra) {

			var action = "";
			if (pra == "top10MatHangTheoSoLuong") {
				action = "TrangChu_ThongKe?top10MatHangTheoSoLuong=0";
			} else if (pra == "top10MatHangTheoDoanhThu") {
				action = "TrangChu_ThongKe?top10MatHangTheoDoanhThu=0";
			} else if (pra == "7ngay") {
				action = "TrangChu_ThongKe?7ngay=0";
			} else if (pra == "3thang") {
				action = "TrangChu_ThongKe?3thang=0";
			}
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById("content-chart").innerHTML = this.responseText;
					if (pra == "top10MatHangTheoSoLuong"
							|| pra == "top10MatHangTheoDoanhThu") {

						//data 2
						var areaChartData2 = {
							labels : [],
							datasets : [ {
								label : 'Electronics',
								fillColor : 'rgba(210, 214, 222, 1)',
								strokeColor : 'rgba(210, 214, 222, 1)',
								pointColor : 'rgba(210, 214, 222, 1)',
								pointStrokeColor : '#c1c7d1',
								pointHighlightFill : '#fff',
								pointHighlightStroke : 'rgba(220,220,220,1)',
								data : []
							} ]
						}

						//get data chart top hàng bán chạy trong tháng
						for (var i = 0; i < 10; i++) {
							if (document.getElementById('tenMon' + i) != null) {
								areaChartData2.labels
										.push(document.getElementById('tenMon'
												+ i).innerHTML);
								areaChartData2.datasets[0].data
										.push(document
												.getElementById('tienHang' + i).innerHTML);
							}
						}
						//-------------
						//- BAR CHART 2-
						//-------------
						var barChartCanvas2 = $('#barChart2').get(0)
								.getContext('2d')
						var barChart2 = new Chart(barChartCanvas2)
						var barChartData2 = areaChartData2
						barChartData2.datasets[0].fillColor = '#58bbf5'
						barChartData2.datasets[0].strokeColor = '#58bbf5'
						barChartData2.datasets[0].pointColor = '#00a65a'
						var barChartOptions2 = {
							//Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
							scaleBeginAtZero : true,
							//Boolean - Whether grid lines are shown across the chart
							scaleShowGridLines : true,
							//String - Colour of the grid lines
							scaleGridLineColor : 'rgba(0,0,0,.05)',
							//Number - Width of the grid lines
							scaleGridLineWidth : 1,
							//Boolean - Whether to show horizontal lines (except X axis)
							scaleShowHorizontalLines : true,
							//Boolean - Whether to show vertical lines (except Y axis)
							scaleShowVerticalLines : true,
							//Boolean - If there is a stroke on each bar
							barShowStroke : true,
							//Number - Pixel width of the bar stroke
							barStrokeWidth : 2,
							//Number - Spacing between each of the X value sets
							barValueSpacing : 5,
							//Number - Spacing between data sets within X values
							barDatasetSpacing : 1,
							//String - A legend template
							//Boolean - whether to make the chart responsive
							responsive : true,
							maintainAspectRatio : true
						}

						barChartOptions2.datasetFill = false
						barChart2.Bar(barChartData2, barChartOptions2)
					}

					if (pra == "7ngay" || pra == "3thang") {

						var areaChartData = {
							labels : [],
							datasets : [ {
								label : 'Electronics',
								fillColor : 'rgba(210, 214, 222, 1)',
								strokeColor : 'rgba(210, 214, 222, 1)',
								pointColor : 'rgba(210, 214, 222, 1)',
								pointStrokeColor : '#c1c7d1',
								pointHighlightFill : '#fff',
								pointHighlightStroke : 'rgba(220,220,220,1)',
								data : []
							} ]
						}
						//get data chart doanh thu 7 ngày
						for (var i = 0; i < 7; i++) {
							if (document.getElementById('date' + i) != null) {
								areaChartData.labels.push(document
										.getElementById('date' + i).innerHTML);
								areaChartData.datasets[0].data.push(document
										.getElementById('tien' + i).innerHTML)
							}
						}

						//-------------
						//- BAR CHART 1-
						//-------------
						var barChartCanvas = $('#barChart').get(0).getContext(
								'2d')
						var barChart = new Chart(barChartCanvas)
						var barChartData = areaChartData
						barChartData.datasets[0].fillColor = '#00a65a'
						barChartData.datasets[0].strokeColor = '#00a65a'
						barChartData.datasets[0].pointColor = '#00a65a'
						var barChartOptions = {
							//Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
							scaleBeginAtZero : true,
							//Boolean - Whether grid lines are shown across the chart
							scaleShowGridLines : true,
							//String - Colour of the grid lines
							scaleGridLineColor : 'rgba(0,0,0,.05)',
							//Number - Width of the grid lines
							scaleGridLineWidth : 1,
							//Boolean - Whether to show horizontal lines (except X axis)
							scaleShowHorizontalLines : true,
							//Boolean - Whether to show vertical lines (except Y axis)
							scaleShowVerticalLines : true,
							//Boolean - If there is a stroke on each bar
							barShowStroke : true,
							//Number - Pixel width of the bar stroke
							barStrokeWidth : 2,
							//Number - Spacing between each of the X value sets
							barValueSpacing : 5,
							//Number - Spacing between data sets within X values
							barDatasetSpacing : 1,
							//String - A legend template
							//Boolean - whether to make the chart responsive
							responsive : true,
							maintainAspectRatio : true
						}

						barChartOptions.datasetFill = false
						barChart.Bar(barChartData, barChartOptions)

					}
				}
			};

			xmlhttp.open("GET", action, true);
			xmlhttp.send();
		};
	</script>
</body>
</html>