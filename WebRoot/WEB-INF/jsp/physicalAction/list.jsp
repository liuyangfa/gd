<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>库存盘点列表</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<script type="text/javascript">
$(document).ready(function(e) {

	  /**
	   * 判断单据状态：
	   *	--| 如果为'未审核'状态，则可以删除，也可以修改
	   *	--| 如果为'已审核'状态，则不能删除，不能修改
	   *
	   */
	var leng=$('tbody tr').length;
	for ( var j = 0; j < leng; j++ ) {
		var a=$('#audit').attr('id','audit'+j).attr('id');
		var b=$('#delete').attr('id','delete'+j).attr('id');
		var c=$('#edit').attr('id','edit'+j).attr('id');
		if($('#'+a).parents().find('tbody tr').eq(j).find('td').eq(1).text()=='已审核'){
			 $('#'+a+' i').removeClass('fa fa-lg fa-check-square-o');
			 $('#'+a+' i').addClass('fa fa-lg fa-check-square');
			 $('#'+a).css('pointer-events','none');
		}
 		if($('#'+b).parents().find('tbody tr').eq(j).find('td').eq(1).text()=='已审核'){
 			 $('#'+b+' i').removeClass('fa fa-lg fa-trash-o');
 			 $('#'+b+' i').addClass('fa fa-lg fa-trash');
 			 $('#'+b).css('pointer-events','none');
 		}
 		if($('#'+c).parents().find('tbody tr').eq(j).find('td').eq(1).text()=='已审核'){
 			$('#'+c+' i').removeClass('fa fa-lg fa-pencil-square-o');
			$('#'+c+' i').addClass('fa fa-lg fa-pencil-square');
 			$('#'+c).css('pointer-events','none');
 		}
	}  
	
});
</script>
</head>

<body class="container">
<div class="page-header">
  <div class="row">
    <div class="col-md-8">
      <h1>库存盘点单管理<small>Inventory Physical Management</small></h1>
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
<div class="panel panel-info">
	<div class="panel-heading">库存盘点
		<div class="pull-right">
			<s:a action="physicalAction_addWay" cssClass="btn btn-default btn-sm" role="button">添加</s:a>
			<s:a action="adjustmentAction_list" cssClass="btn btn-default btn-sm" role="button">库存调整单</s:a>
		</div>
	</div>
<table class="table table-hover table-bordered table-striped table-responsive">
  <thead>
    <tr>
      <th>盘点日期</th>
      <th>审核标志</th>
      <th>单据编号</th>
      <th>盘点仓库</th>
      <th>保管员</th>
      <th>相关操作</th>
    </tr>
  </thead>
  <tbody>
  <s:iterator value="recordList">
    <tr>
    	<td><s:a action="physicalAction_listInfo?id=%{id}&checkyn=%{checkyn}">${ date }</s:a></td>
        <td><s:a action="physicalAction_listInfo?id=%{id}">${ checkyn }</s:a></td>
        <td><s:a action="physicalAction_listInfo?id=%{id}">${ id }</s:a></td>
        <td><s:a action="physicalAction_listInfo?id=%{id}">${ warehouse.name }</s:a></td>
        <td><s:a action="physicalAction_listInfo?id=%{id}">${ user.name }</s:a></td>
        <td>
	        <s:a id="delete" action="physicalAction_delete?id=%{id}" title="删除"><i class="fa fa-lg fa-trash-o"></i></s:a>
	        <s:a id="edit" action="physicalAction_editUI?id=%{id}" title="修改"><i class="fa fa-pencil-square-o fa-lg"></i></s:a>
	        <s:a id="audit" action="physicalAction_audit?id=%{id}" title="未审核"><i class="fa fa-lg fa-check-square-o"></i></s:a>
	       <s:if test="checkyn=='已审核'">
	        <s:a id="" action="physicalAction_createAdjust?id=%{id}" title="生成调整单"><i class="fa fa-lg fa-life-buoy"></i></s:a>
	       </s:if>
        </td>
    </tr>
  </s:iterator>
  </tbody>
</table>
</div>
<div class="alert alert-info alert-dismissible" role="alert">
<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span>
	<span class="sr-only">Close</span></button>
	1.盘点单审核之后才能生产调整单<br>
</div>
</body>
</html>
