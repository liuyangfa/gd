<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>盘点方案</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<style type="text/css">
#button {
	margin-top: 20px;
	margin-bottom:20px;
}

</style>
</head>

<body class="container">
	<div class="page-header">
		<div class="row">
			<div class="col-md-8">
				<h1>
					库存调整单列表管理<small>Inventory Adjustment List Management</small>
				</h1>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-3" id="search">
				<div class="input-group">
					<input type="text" class="form-control"> <span
						class="input-group-btn">
						<button class="btn btn-default" type="button">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</span>
				</div>
			</div>
		</div>
	</div>
	<div class="panel panel-primary">
		<div class="panel-heading">盘点方案</div>
		<div class="panel-body">
			请选择需要盘点的仓库
			<s:form action="physicalAction_add" method="post"
				cssClass="form form-horizontal" role="form">
				<s:iterator value="#realtimeInventoryList">
					<div class="radio">
						<label><input name="warehouseId" type="radio"
							value="${ warehouse.id }">${ warehouse.name }</label>
					</div>
				</s:iterator>
				<button id="button" type="submit" class="btn btn-primary btn-sm">保存</button>
				<a href="javascript:history.go(-1);" class="btn btn-primary btn-sm" role="button">返回</a>
			</s:form>
		</div>
	</div>
</body>
</html>
