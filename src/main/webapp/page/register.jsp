<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>青鸟租房 - 用户注册</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
</div>
<div id="regLogin" class="wrap">
	<div class="dialog">
		<dl class="clearfix">
			<dt>新用户注册</dt>
			<dd class="past">填写个人信息</dd>
		</dl>
		<div class="box">
			<form action="registerUser.action">
				<div class="infos">
					<table class="field">
						<tr>${message}</tr>
						<tr>
							<td class="field">用 户 名：</td>
							<td width="100"><input type="text" class="text" name="name" id="name" /> </td>
							<td></td>
						</tr>
						<tr>
							<td class="field">密　　码：</td>
							<td><input type="password" class="text" name="password" id="password"/></td>
						</tr>
						<tr>
							<td class="field">确认密码：</td>
							<td><input type="password" class="text" name="repassword" id="repassword"/> </td>
						</tr>
						<tr>
							<td class="field">电　　话：</td>
							<td><input type="text" class="text" name="telephone" id="telephone"/> </td>
						</tr>
						<tr>
							<td class="field">用户姓名：</td>
							<td><input type="text" class="text" name="username" id="username" /> </td>
						</tr>
					</table>
					<div class="buttons"><input type="submit" name="submit" value="立即注册" /></div>
				</div>
			</form>
		</div>
	</div>
</div>
<div id="footer" class="wrap">
	<dl>
    	<dt>青鸟租房 &copy; 2010 北大青鸟 京ICP证1000001号</dt>
        <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
    </dl>
</div>
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script>
	$(function () {
		$("form").submit(function () {
			var $name=$("#name").val();
			var password=$("#password").val();
			var repassword=$("#repassword").val();
			var telephone=$("#telephone").val();
			var username=$("#username").val();
			var result=false;
			if($name==""){
				alert("姓名不能为空!")
				result=false;
			}else if(password==""){
				alert("密码不能为空!")
				result=false;
			}else if(repassword==""){
				alert("确认密码不能为空!")
				result=false;
			}else if(password!=repassword) {
				alert("两次密码不一致!")
				result = false;
			}else  if(telephone==""){
				alert("电话不能为空!")
				result=false;
			}else if(username==""){
				alert("用户名不能为空!")
				result=false;
			}else{
				result=true;
			}
			return result;
		});
		$("#name").bind("blur",function () {
		    var thisName=$("#name").val();
		    var name = $("[name=name]");
			$.getJSON("checkNameUser.action",{name:thisName},function (data) {
				if(data.code==10001){
                    $(name).parent().next().html(data.msg);
				}else{
					$(name).parent().next().html("");
				}
			});
		});
	});
</script>
</body>
</html>

