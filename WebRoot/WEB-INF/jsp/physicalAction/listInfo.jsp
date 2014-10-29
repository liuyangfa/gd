<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>库存盘点列表</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<script type="text/javascript">
$(document).ready(function(e) {
	// 如果该单据已审核则不显示修改按钮
	if($('input[type=hidden]:last').val()=='已审核'){
		
		$('#edit').css('visibility','hidden');;
	}
});
</script>
</head>

<body class="container">
<div class="page-header">
  <div class="row">
    <div class="col-md-8">
      <h1>库存盘点列表管理<small>Inventory Physical List Management</small></h1>
    </div>
    <div class="col-md-1"></div>
    <div class="col-md-3" id="search">
      <div class="input-group">
        <input type="text" class="form-control input-sm">
        <span class="input-group-btn">
        <button class="btn btn-default btn-sm" type="button"><i class="fa fa-search fa-lg"></i></button>
        </span> </div>
    </div>
  </div>
</div>
<div class="panel panel-default">
	<div class="panel-heading">库存盘点
		<div class="pull-right">
			<s:hidden value="id"></s:hidden>
				<s:a id="edit" action="physicalAction_editUI?id=%{id}" cssClass="btn btn-default btn-sm" role="button">修改</s:a>
			<a href="javascript:history.go(-1);" class="btn btn-default btn-sm" role="button">返回</a>
		</div>
	</div>
<table class="table table-hover table-bordered table-striped table-responsive">
  <thead>
    <tr>
      <th>物料名称</th>
      <th>常用单位</th>
      <th>账存数量</th>
      <th>实存数量</th>
      <th>盘盈数量</th>
      <th>盘亏数量</th>
      <th>备注</th>
    </tr>
  </thead>
  <tbody>
  <s:iterator value="#physicalMaterials">
    <tr>
        <td>${ materials.name }</td>
        <td>${ unit.name }</td>
        <td>${ number }</td>
        <td>${ realNumber }</td>
        <td>${ profitNumber }</td>
        <td>${ lossNumber }</td>
        <td>${ description }<input type="hidden" value="${physicalItem.checkyn}" ></td>
    </tr>
  </s:iterator>
  </tbody>
</table>
</div>
</body>
</html>
