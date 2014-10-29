<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>呆滞料</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
</head>

<body class="container">
	<div class="page-header">
		<div class="row">
			<div class="col-md-9">
				<h1>
					呆滞料管理<small>Sluggish Materials Management</small>
				</h1>
			</div>
		</div>
	</div>
<div class="panel panel-danger">
		<div class="panel-heading">
			呆滞料
		</div>
	<table
		class="table table-hover table-striped table-responsive table-bordered table-condensed">
		<thead>
			<tr>
				<th>呆滞料编号</th>
				<th>物料编号</th>
				<th>物料名称</th>
				<th>数量</th>
				<th>仓库名称</th>
				<th>最后异动日</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="recordList">
				<tr>
					<td>${id}</td>
					<td>${materialsId}</td>
					<td>${materialsName}</td>
					<td>${number}</td>
					<td>${warehouseName}</td>
					<td>${date}</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
	<!-- 分页信息 -->
	<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
	<s:form action="sluggishAction_list"></s:form>
</body>
</html>
