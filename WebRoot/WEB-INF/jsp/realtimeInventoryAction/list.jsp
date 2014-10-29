<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>实时库存列表</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
</head>

<body class="container">
	<div class="page-header">
		<div class="row">
			<div class="col-md-9">
				<h1>
					实时库存列表管理<small>RealTime Inventory Lists Management</small>
				</h1>
			</div>
			<div class="col-md-3" id="search">
	    	 <s:form action="#" class="form form-horizontal" role="form" method="post">
		       <div class="input-group">
			        <input type="text" id="content" class="form-control input-sm" name="search">
			        <span class="input-group-btn">
			        <button class="btn btn-default btn-sm" type="submit"><i class="fa fa-search fa-lg"></i></button>
			        </span> 
		       </div>
		   </s:form>
    </div>
		</div>
	</div>
<div class="panel panel-info">
		<div class="panel-heading">
			实时库存
		</div>
	<table
		class="table table-hover table-striped table-responsive table-bordered table-condensed">
		<thead>
			<tr>
				<th>库存编号</th>
				<th>物料名称</th>
				<th>所属仓库</th>
				<th>常用单位</th>
				<th>基本数量</th>
				<th>最后异动日</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="recordList">
				<tr>
					<td>${id}</td>
					<td>${materials.name}</td>
					<td>${warehouse.name}</td>
					<td>${unit.name}</td>
					<td>${number}</td>
					<td>${date}</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
	<!-- 分页信息 -->
	<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
	<s:form action="realtimeInventoryAction_list"></s:form>
</body>
</html>
