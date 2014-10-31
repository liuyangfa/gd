<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>注销成功页面</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<style type="text/css">
.jumbotron {
	height: 666px;
	margin-bottom: 0px;
	background-color:#f5f5f5;
}
#ps{
	margin-top:160px;
}

h1 {
	text-align: center;
}

p {
	text-align: center;
}
</style>
</head>

<body>
	<div class="jumbotron">
		<div id="ps">
			<h1>注销成功</h1>
			<p>当前用户已经成功登出系统，想重新登录请点击下面的按钮</p>
			<p>
				<s:a action="loginLogoutAction_loginUI"
					cssClass="btn btn-success btn-lg" role="button">重新登录</s:a>
			</p>
		</div>
	</div>
</body>
</html>
