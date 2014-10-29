<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>物料列表</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
</head>

<body class="container">
	<div class="page-header">
		<h1>
			物料管理<small>Materials Management</small>
		</h1>
	</div>
	<div class="panel panel-info">
	<div class="panel-heading">物料
		<div class="pull-right">
			<s:a action="materialsAction_addUI" cssClass="btn btn-default btn-sm" role="button">添加</s:a>
		</div>
	</div>
		<table class="table table-hover table-bordered table-striped table-responsive">
			<thead>
				<tr>
					<th>物料类别</th>
					<th>物料编号</th>
					<th>物料名称</th>
					<th>规格</th>
					<th>最低库存</th>
					<th>最高库存</th>
					<th>安全库存</th>
					<th>无发生额时间(天)</th>
					<th>说明</th>
					<th>相关操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="recordList">
					<tr>
						<td>${ category.name }</td>
						<td>${ id }</td>
						<td>${ name }</td>
						<td>${ specifications }</td>
						<td>${ lowestInventory }</td>						
						<td>${ highestInventory }</td>						
						<td>${ safeInventory }</td>						
						<td>${ noAmountOfTime }</td>						
						<td>${ description }</td>
						<td><s:a id="a" action="materialsAction_delete?id=%{id}"
								onClick="return confirm('确定要删除?')" title="删除">
								<i class="fa fa-trash-o fa-lg"></i>
							</s:a> <s:a id="a" action="materialsAction_editUI?id=%{id}" title="修改">
								<i class="fa fa-edit fa-lg"></i>
							</s:a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<!-- 分页信息 -->
<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
	<s:form action="materialsAction_list"></s:form>
</body>
</html>
