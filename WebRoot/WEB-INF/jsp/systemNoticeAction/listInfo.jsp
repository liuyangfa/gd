<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<title>通知详情</title>
</head>
<body class="container">
	<div class="page-header">
		<h1>
			通知详情<small>SystemNotice Detail</small>
		</h1>

	</div>
	<div class="panel panel-primary">
		<div class="panel-heading">
			通知详情
			<div class="pull-right">
				<a href="${pageContext.request.contextPath}/systemNoticeAction_list.action" class="btn btn-default btn-sm" role="button">返回</a>
			</div>
		</div>
		<s:hidden value="id"></s:hidden>
		<s:iterator value="#systemNotice">
			<table class="table table-bordered table-hover table-striped">
				<tbody>
					<tr>
						<td>通知编号</td>
						<td>${ id }</td>
					</tr>

					<tr>
						<td>通知主题</td>
						<td>${ name }</td>
					</tr>
					<tr>
						<td>通知内容</td>
						<td>${ content }</td>
					</tr>
				</tbody>
			</table>
	</s:iterator>
	</div>
</body>
</html>
