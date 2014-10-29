<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>库存调拨单</title>
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
		if($('#'+a).parent().parent().parent().find('tr').eq(j).find('td').eq(1).text()=='已审核'){
			 $('#'+a+' i').removeClass('fa fa-lg fa-check-square-o');
			 $('#'+a+' i').addClass('fa fa-lg fa-check-square');
			 $('#'+a).css('pointer-events','none');
		}
 		if($('#'+b).parent().parent().parent().find('tr').eq(j).find('td').eq(1).text()=='已审核'){
 			 $('#'+b+' i').removeClass('fa fa-lg fa-trash-o');
 			 $('#'+b+' i').addClass('fa fa-lg fa-trash');
 			 $('#'+b).css('pointer-events','none');
 		}
 		if($('#'+c).parent().parent().parent().find('tr').eq(j).find('td').eq(1).text()=='已审核'){
 			$('#'+c+' i').removeClass('fa fa-lg fa-pencil-square-o');
			$('#'+c+' i').addClass('fa fa-lg fa-pencil-square');
 			$('#'+c).css('pointer-events','none');
 		}
 		if($('#'+a).parent().parent().parent().find('tr').eq(j).find('td').eq(0).text()==$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(0).text()){
 			$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(0).css('visibility','hidden');
 			$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(1).css('visibility','hidden');
 			$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(2).css('visibility','hidden');
 			$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(3).css('visibility','hidden');
 			$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(4).css('visibility','hidden');
 			$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(5).css('visibility','hidden');
 			$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(9).css('visibility','hidden');
 		}
	}  
	
	});
</script>
</head>

<body class="container">
<div class="page-header">
  <div class="row">
    <div class="col-md-8">
      <h1>库存调拨单管理<small>Inventory Allocation Management</small></h1>
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
	<div class="panel-heading">库存调拨单
		<div class="pull-right">
			<s:a action="allocationAction_addUI" cssClass="btn btn-default btn-sm" role="button">添加</s:a>
		</div>
	</div>
<table id="tbl" class="table table-hover table-bordered table-striped table-responsive">
  <thead>
    <tr>
      <th>单据编号</th>
      <th>审核标志</th>
      <th>业务员</th>
      <th>日期</th>
      <th>调出仓库</th>
      <th>调入仓库</th>
      <th>物料名称</th>
      <th>单位</th>
      <th>调拨数量</th>
      <th>相关操作</th>
    </tr>
  </thead>
  <tbody>
  <s:iterator value="recordList">
    <tr>
      <td>${ allocationItem.id }</td>
      <td>${ allocationItem.checkyn }</td>
      <td>${ allocationItem.user.name }</td>
      <td>${ allocationItem.date }</td>
      <td>${ allocationItem.inWarehouse.name }</td>
      <td>${ allocationItem.outWarehouse.name }</td>
      <td>${ materials.name }</td>
      <td>${ unit.name }</td>
      <td>${ number }</td>
      <td>
      	  <s:a id="delete" action="allocationAction_delete?id=%{allocationItem.id}" onClick="return confirm('确定要删除吗?')" title="删除"><i class="fa fa-lg fa-trash-o"></i></s:a>
	      <s:a id="edit" action="allocationAction_editUI?id=%{allocationItem.id}" title="修改"><i class="fa fa-pencil-square-o fa-lg"></i></s:a>
	      <s:a id="audit" action="allocationAction_audit?id=%{allocationItem.id}" onClick="return confirm('确定要审核?')" title="审核"><i class="fa fa-lg fa-check-square-o"></i></s:a></td>
    </tr>
    </s:iterator>
  </tbody>
</table>
</div>
</body>
</html>
