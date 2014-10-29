<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<title>日志管理</title>
</head>
<body class="container">
	<div class="page-header">
		<h1>
			系统日志管理<small>SystemLog Management</small>
		</h1>

	</div>
	<div class="panel panel-info">
		<div class="panel-heading">
			系统日志
		</div>
		<table
			class="table table-hover table-bordered table-striped table-responsive">
			<thead>
				<tr>
					<th>主机名</th>
					<th>IP地址</th>
					<th>操作名称</th>
					<th>操作时间</th>
					<th>用户</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="recordList">
					<tr>
						<td>${host}</td>
						<td>${ipAddr}</td>
						<td>${path}</td>
						<td>${date}</td>
						<td>${user.name}</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<!-- 分页信息 -->
	<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>
	<s:form action="systemlogAction_list"></s:form>

</body>
</html>
