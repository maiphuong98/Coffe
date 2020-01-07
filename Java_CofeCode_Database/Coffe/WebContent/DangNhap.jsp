<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Đăng Nhập</title>

<%@include file="./Shared/_bootstrap.jsp"%>
</head>
<body class="hold-transition login-page">
<%String st = (String)request.getAttribute("resultLogin"); %>
	<div class="login-box">
		<div class="login-logo">
			<a href="#"><b>CoffeeShop</b>Management</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<h3 class="login-box-msg">Đăng Nhập</h3>
			<p class="text-red wrongformat" style="text-align: center;"><%if(st != null) {%><%=st%><%} %></p>

			<form action="DangNhapServlet" method="post" onsubmit="return checkLogin();">
				<div class="form-group has-feedback">
				<label>Tên đăng nhập: </label>
					<input type="text" class="form-control" id="txtTenDangNhap" name="txtTenDangNhap" placeholder="Tên đăng nhập" onblur="return checkLogin();">
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
					<p class="text-yellow wrongformat" id="lbTenDangNhap"></p>
				</div>
				<div class="form-group has-feedback">
				<label>Mật khẩu: </label>
					<input type="password" class="form-control" id="txtMatKhau" name="txtMatKhau" placeholder="Mật khẩu" onblur="return checkLogin();">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
					<p class="text-yellow wrongformat" id="lbMatKhau"></p>
				</div>
				<div class="row">
					<div class="col-xs-8">
					</div>
					<div class="col-xs-4">
						<button type="submit" name="btnDangNhap" value="temp" class="btn btn-primary btn-block btn-flat">Đăng Nhập</button>
					</div>
				</div>
			</form>
			
		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 3 -->
	<script src="../../bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="../../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
            function checkLogin()
            {
                var tenDangNhap = document.getElementById("txtTenDangNhap");
                var matKhau = document.getElementById("txtMatKhau");
                var valid = true;
                if (tenDangNhap.value.length <= 0)
                {
                	document.getElementById("lbTenDangNhap").innerHTML = "* Tên đăng nhập không được trống!";
                    valid = false;
                }
                else if(matKhau.value.length < 1){
                	document.getElementById("lbMatKhau").innerHTML = "* Vui lòng nhập mật khẩu dài hơn 1 ký tự!";
                    valid = false;
                }
                else{
                	document.getElementById("lbTenDangNhap").innerHTML = "";
                	document.getElementById("lbMatKhau").innerHTML = "";
                }
                return valid;
            };
        </script>
</body>
</html>