<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>用户管理</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<style type="text/css">
.jumbotron{
	height: 610px;
	margin-bottom: 0px;
	
}
h1{
	text-align: center;
}
p{
	text-align: center;
}
#ps{
	margin-top:150px;
}
</style>
</head>

<body>
	<div class="jumbotron">
		<div id="ps">
		<h1>恭喜您，密码修改成功!</h1>
		<p>如果还想再次修改密码请点击下面的按钮</p>
		<p>
			<s:a action="passwordAction_list" cssClass="btn btn-primary btn-lg" role="button">再次修改密码</s:a>
		</p>
		</div>
	</div>

</body>
</html>
