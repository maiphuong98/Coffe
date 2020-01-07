<%@page import="fpt.model.bean.Ban"%>
<%@page import="fpt.model.bean.ThucDon"%>
<%@page import="fpt.model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Thêm sửa Bàn</title>

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

		<div class="content-wrapper" style="min-height: 252px;">
			<section class="content-header"> <br>
			</section>
			<section class="content">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">
						<%
							if (request.getAttribute("ban") != null) {
						%>SỬA THÔNG TIN BÀN<%
							} else {
						%>THÊM MỚI BÀN<%
							}
						%>
					</h3>
				</div>
				<div class="box-body box-profile">

					<div class="tab-pane active" id="">
						<form action="Ban" method="post" class="form-horizontal"
							<%if (request.getAttribute("ban") == null) {%>
							onsubmit="return submit11()" <%}%>>
							<%
								if (request.getAttribute("ban") != null) {
									Ban ban = (Ban) request.getAttribute("ban");
							%>
							<div class="form-group">
								<label for="inputName" class="col-sm-4 control-label">Mã
									bàn:</label>

								<div class="col-sm-4">
									<input type="text" class="form-control" id="" name="maBan"
										placeholder="Mã bàn" minlength="1" maxlength="20"
										readonly="readonly" value="<%=ban.getMaBan()%>">
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-4 control-label"
									minlength="1" maxlength="50">Tên Bàn:</label>

								<div class="col-sm-4">
									<input type="text" class="form-control" id="" name="tenBan"
										placeholder="Tên" required value="<%=ban.getTenBan()%>">
								</div>
							</div>

							<%
								} else {
							%>

							<div class="form-group">
								<label for="inputName" class="col-sm-4 control-label">Mã
									bàn:</label>

								<div class="col-sm-4">
									<input type="text" class="form-control" id="maBan" name="maBan"
										placeholder="Mã bàn" minlength="1" maxlength="20" required
										onkeyup="checkMaBan()">
									<p id="check-ma"></p>
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-4 control-label"
									minlength="1" maxlength="50">Tên bàn:</label>

								<div class="col-sm-4">
									<input type="text" class="form-control" id="" name="tenBan"
										placeholder="Tên" required>
								</div>
							</div>

							<%
								}
							%>

							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-4">
									<%
										if (request.getAttribute("ban") != null) {
									%><button type="submit" name="action" value="sua"
										class="btn btn-primary">Sửa</button>
									<%
										} else {
									%><button type="submit" name="action" value="them"
										class="btn btn-primary">Thêm</button>
									<%
										}
									%>
									<a href="Ban" class="btn btn-primary"><b>Đóng</b></a>
								</div>

							</div>
						</form>
					</div>
				</div>

				<!-- /.box-body -->
			</div>
			</section>
		</div>

		<script>
			function submit11() {
				if (document.getElementById("check-true") === null) {
					return true;
				} else {
					
					alert('Trùng mã!');
					return false;
				}
			};
			function checkMaBan() {
				var maBan = document.getElementById("maBan").value;
				var xmlhttp = new XMLHttpRequest();
				xmlhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						document.getElementById("check-ma").innerHTML = this.responseText;
					}
				};

				xmlhttp
						.open("GET", "Ban?action=check&maban=" + maBan,
								true);
				xmlhttp.send();
			};
		</script>
		<!-- /.content-wrapper -->


		<%@include file="./Shared/_main-footer.jsp"%>
	</div>

	<%@include file="./Shared/_js.jsp"%>
</body>
</html>