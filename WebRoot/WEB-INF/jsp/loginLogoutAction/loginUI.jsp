<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>后台登录</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<link href="${pageContext.request.contextPath}/style/css/login.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript">
	$(function() {
		document.forms[0].loginName.focus();
	});
	//如果登录页面显示在了框架里，则在顶层窗口显示登录页面
	if (window.parent != window) {
		window.parent.location.href = window.location.href;
	}
</script>
</head>

<body class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">
			库存管理系统
		</div>
		<div class="panel-body">
			<s:form cssClass="form form-horizontal" role="form" id="form"
				action="loginLogoutAction_login" method="post">
				<s:fielderror cssStyle="color:red;"></s:fielderror>
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user fa-lg"></i></span>
						<input type="text" tabindex="1" class="form-control"
							name="loginName" autofocus="autofocus" placeholder="用户名" required>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock fa-lg"></i></span>
						<input type="password" tabindex="2" class="form-control"
							name="password" placeholder="密码" required>
					</div>
				</div>
				<div class="form-group">
					<button tabindex="3" type="submit"
						class="btn btn-success btn-lg btn-block">登录</button>
				</div>
			</s:form>
		</div>
	</div>
</body>
</html>
