<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>库存调整单列表</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
</head>

<body class="container">
<div class="page-header">
  <div class="row">
    <div class="col-md-8">
      <h1>库存调整单列表管理<small>Inventory Adjustment List Management</small></h1>
    </div>
    <div class="col-md-1"></div>
    <div class="col-md-3" id="search">
      <div class="input-group">
        <input type="text" class="form-control">
        <span class="input-group-btn">
        <button class="btn btn-default" type="button"><i class="glyphicon glyphicon-search"></i></button>
        </span> </div>
    </div>
  </div>
</div>
<div class="panel panel-info">
	<div class="panel-heading">库存调整单
		<div class="pull-right">
			<s:a action="physicalAction_list" cssClass="btn btn-default btn-sm" role="button">返回</s:a>
		</div>
	</div>
<table id="tbl" class="table table-hover table-bordered table-striped table-responsive">
  <thead>
    <tr>
      <th>调整日期</th>
      <th>审核标志</th>
      <th>单据编号</th>
      <th>业务员</th>
      <th>审核人</th>
      <th>说明</th>
      <th>相关操作</th>
    </tr>
  </thead>
  <tbody>
  <s:iterator value="recordList">
    <tr>
      <td><s:a action="adjustmentAction_listInfo?id=%{id}">${date }</s:a></td>
      <td><s:a action="adjustmentAction_listInfo?id=%{id}">${ checkyn }</s:a></td>
      <td><s:a action="adjustmentAction_listInfo?id=%{id}">${ id }</s:a></td>
      <td><s:a action="adjustmentAction_listInfo?id=%{id}">${ user.name }</s:a></td>
      <td><s:a action="adjustmentAction_listInfo?id=%{id}">${ checker }</s:a></td>
      <td><s:a action="adjustmentAction_listInfo?id=%{id}">${ description }</s:a></td>
      <td><s:a id="delete" action="adjustmentAction_delete?id=%{id}" onClick="return confirm('确定要删除吗?')" title="删除"><i class="fa fa-lg fa-trash-o"></i></s:a>
	      <s:a id="edit" action="adjustmentAction_editUI?id=%{id}" title="修改"><i class="fa fa-pencil-square-o fa-lg"></i></s:a>
	      <s:a id="audit" action="adjustmentAction_audit?id=%{id}" onClick="return confirm('确定要审核?')" title="未审核"><i class="fa fa-lg fa-check-square-o"></i></s:a>
	 </td>
    </tr>
    </s:iterator>
  </tbody>
</table>
</div>
</body>
</html>
