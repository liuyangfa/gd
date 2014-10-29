<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>外购入库单</title>
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
		if($('#'+a).parent().parent().parent().find('tr').eq(j).find('td').eq(2).text()=='已审核'){
			 $('#'+a+' i').removeClass('fa fa-lg fa-check-square-o');
			 $('#'+a+' i').addClass('fa fa-lg fa-check-square');
			 $('#'+a).css('pointer-events','none');
		}
 		if($('#'+b).parent().parent().parent().find('tr').eq(j).find('td').eq(2).text()=='已审核'){
 			 $('#'+b+' i').removeClass('fa fa-lg fa-trash-o');
 			 $('#'+b+' i').addClass('fa fa-lg fa-trash');
 			 $('#'+b).css('pointer-events','none');
 		}
 		if($('#'+c).parent().parent().parent().find('tr').eq(j).find('td').eq(2).text()=='已审核'){
 			$('#'+c+' i').removeClass('fa fa-lg fa-pencil-square-o');
			$('#'+c+' i').addClass('fa fa-lg fa-pencil-square');
 			$('#'+c).css('pointer-events','none');
 		}
 		if($('#'+a).parent().parent().parent().find('tr').eq(j).find('td').eq(1).text()==$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(1).text()){
 			$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(0).css('visibility','hidden');
 			$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(1).css('visibility','hidden');
 			$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(2).css('visibility','hidden');
 			$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(3).css('visibility','hidden');
 			$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(4).css('visibility','hidden');
 			$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(5).css('visibility','hidden');
 			$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(6).css('visibility','hidden');
 			$('#'+a).parent().parent().parent().find('tr').eq(j+1).find('td').eq(12).css('visibility','hidden');
 		}
	} 
	/**
	当select的值变化时，content的type随之变化，并且清空input的值 
	
	*/
	$('#condition').change(function(){
		var value=$(this).children('option:selected').val();//这就是selected的值 
		if(value=='date'){
			$('#content').remove();
			var input='<input type="date" id="content" class="form-control input-sm" name="content" value="${ content }">';
			$('#div').prepend(input);
			$('#content').attr('value','');
		}else if(value=='id'){
			$('#content').remove();
			var input='<input type="number" id="content" class="form-control input-sm" min="1" max="100000" name="content" value="${ content }">';
			$('#div').prepend(input);
			$('#content').attr('value','');
		}
		else if(value=='checkyn'){
			$('#content').remove();
			var select='<select name="content" id="content" class="form-control input-sm"><option value="未审核">未审核</option><option value="已审核">已审核</option></select>';
			$('#div').prepend(select);
		}
		else{
			$('#content').remove();
			var input='<input type="text" id="content" class="form-control input-sm" name="content" value="${ content }">';
			$('#div').prepend(input);
			$('#content').attr('value','');
		}
	});
	
	/**
	当点击搜索之后
	*/
	if($('#condition').children('option:selected').val()=='checkyn'){
		$('#content').remove();
		var select='<select name="content" id="content" class="form-control input-sm"><option value="未审核">未审核</option><option value="已审核">已审核</option></select>';
		$('#div').prepend(select);
	}else if($('#condition').children('option:selected').val()=='date'){
		$('#content').attr('type','date');
	}else if($('#condition').children('option:selected').val()=='id'){
		$('#content').attr('type','number');
		$('#content').attr('min','1');
		$('#content').attr('max','1000');
	}else{
		$('#content').attr('type','text');
	}
	
});
</script>
</head>

<body class="container">
<div class="page-header">
  <div class="row">
    <div class="col-md-8">
      <h1>外购入库单管理<small>Purchase InventoryIn Management</small></h1>
    </div>
    <div class="col-md-4" id="search">
	<s:form action="purchaseAction_search" class="form form-inline" role="form" method="post">
		<div class="form-inline">
 		<s:select name="condition" cssClass="form-control input-sm" id="condition"
			list="#{'date':'日期','id':'单据编号','checkyn':'审核标志','userId':'业务员','warehouseId':'收料仓库','materialsId':'物料名称','supplierId':'供应商名称'}" 
			headerKey="" headerValue="请选择条件"/>
		       <div id="div" class="input-group col-md-6">
			        <input type="text" id="content" class="form-control input-sm" name="content" value="${ content }">
			        <span class="input-group-btn">
			      	  <button class="btn btn-default btn-sm" type="submit"><i class="fa fa-search fa-lg"></i></button>
			        </span> 
		       </div>
		</div>
	</s:form>
    </div>
  </div>
</div>
<div class="panel panel-info">
	<div class="panel-heading">外购入库单
		<div class="pull-right">
			<s:a action="purchaseAction_addUI" cssClass="btn btn-default btn-sm" role="button">添加</s:a>
		</div>
	</div>
<table id="tbl" class="table table-hover table-bordered table-striped table-responsive">
  <thead>
    <tr>
      <th>制单日期</th>
      <th>单据编号</th>
      <th>审核标志</th>
      <th>审核日期</th>
      <th>业务员</th>
      <th>供应商</th>
      <th>收料仓库</th>
      <th>物料名称</th>
      <th>单位</th>
      <th>单价</th>
      <th>数量</th>
      <th>总金额</th>
      <th>相关操作</th>
    </tr>
  </thead>
  <tbody>
  <s:iterator value="recordList">
    <tr>
      <td>${ inventoryInItem.date }</td>
      <td>${ inventoryInItem.id }</td>
      <td>${ inventoryInItem.checkyn }</td>
      <td>${ inventoryInItem.checkDate }</td>
      <td>${ inventoryInItem.user.name }</td>
      <td>${ inventoryInItem.supplier.name }</td>
      <td>${ inventoryInItem.warehouse.name }</td>
	  <td>${ materials.name }</td>
	  <td>${ unit.name }</td>
	  <td>${ unitPrice }</td>
	  <td>${ number }</td>
	  <td>${ totalPrice }</td>
      <td><s:a id="delete" action="purchaseAction_delete?itemId=%{inventoryInItem.id}" onClick="return confirm('确定要删除吗?')" title="删除"><i class="fa fa-lg fa-trash-o"></i></s:a>
      	  <s:a id="edit" action="purchaseAction_editUI?itemId=%{inventoryInItem.id}" title="修改"><i class="fa fa-pencil-square-o fa-lg"></i></s:a>
     	  <s:a id="audit" action="purchaseAction_audit?itemId=%{inventoryInItem.id}" onClick="return confirm('确定要审核?')" title="未审核"><i class="fa fa-lg fa-check-square-o"></i></s:a></td>
    </tr>
    </s:iterator>
  </tbody>
</table>
</div>
<!-- 分页信息 -->
<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>
<s:form action="purchaseAction_list"></s:form>
</body>
</html>
