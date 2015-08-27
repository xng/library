<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录 | cail.cc</title>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
<form action="login.do" method="post">
<input id="name" name="name" placeholder="请输入姓名..."/>
<input id="pwd" name="pwd" placeholder="请输入密码..." type="password"/>
<button type="button" id="loginBtn">登录</button>
</form>
<script type="text/javascript">
	$(function(){
		$("#loginBtn").click(function(){
			var name = $("#name").val();
			var pwd = $("#pwd").val();
			if(name==null||name==''){
				alert("请输入姓名");
				return;
			}
			if(pwd==null||pwd==''){
				alert("请输入密码");
				return;
			}
			 $.ajax({
					type : "post",
					url : "login.do",
					dataType:"json",
					data : {
						name :name,
						pwd:pwd
					},
					success: function(data){
						if(data.result=='成功'){
							alert("登录成功");
						}else{
							alert("登录失败");
						}
					},
					error: function() {
						alert("系统错误")
		            }
				});
		});
	});
</script>
</body>
</html>