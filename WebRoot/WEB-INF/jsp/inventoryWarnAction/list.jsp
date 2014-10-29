<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>库存预警</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
</head>
<body class="container">
	<div class="page-header">
		<div class="row">
			<div class="col-md-9">
				<h1>
					库存预警管理<small>Inventory Warning Management</small>
				</h1>
			</div>
		</div>
	</div>
<div class="panel panel-warning">
		<div class="panel-heading">
			库存预警
		</div>
	<table
		class="table table-hover table-striped table-responsive table-bordered table-condensed">
		<thead>
			<tr>
				<th>预警编号</th>
				<th>物料类别</th>
				<th>物料名称</th>
				<th>常用单位</th>
				<th>最低库存</th>
				<th>最高库存</th>
				<th>安全库存</th>
				<th>实际库存</th>
				<th>变化量</th>
				<th>状态</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="recordList">
				<tr>
					<td>${id}</td>
					<td>${category}</td>
					<td>${materialsName}</td>
					<td>${unitName}</td>
					<td>${lowestInventory}</td>
					<td>${highestInventory}</td>
					<td>${safeInventory}</td>
					<td>${realInventory}</td>
					<td>${changeNumber}</td>
					<td>${status}</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
	<!-- 分页信息 -->
	<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
	<s:form action="inventoryWarnAction_list"></s:form>
</body>
</html>
