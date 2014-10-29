<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>新增其他出库单</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<style>
h3 {
	text-align: center;
	padding-bottom: 0px;
}
#page-header {
	margin-top: 20px;
	margin-bottom: 10px;
}
th, td {
	text-align: center;
	width:100px;
}
#table {
	height: 300px;
	overflow-x: hidden;
	overflow-y: auto;
}
#table input {
	border: none;
	border-radius: 0px;
}
#table #input{
	border: none;
	border-radius: 0px;
}
#top input{
	border: none;
	border-radius: 0px;
	box-shadow: none;
	background-color: #FFF;
	border-bottom: 1px #000 solid;
}
#top #input{
	border: none;
	border-radius: 0px;
	box-shadow: none;
	background-color: #FFF;
	border-bottom: 1px #000 solid;
}
hr {
	margin-top: 5px;
	margin-bottom: 5px;
	border-color:#000;
}
#alert {
	background-color:#EDECEC;
	margin:0px;
	padding:5px;
}
#bottom {
	margin-top: 10px;
}
#bottom input {
	border: none;
	border-radius: 0px;
	box-shadow: none;
	background-color: #FFF;
	border-bottom: 1px #D3D3D3 solid;
}
#bottom select {
	border: none;
	border-radius: 0px;
	box-shadow: none;
	background-color: #FFF;
	border-bottom: 1px #000 solid;
}
</style>
<script>
function addRow(id){
	var str="<tr><td><select name='materialsId' id='input' class='form-control input-sm'><option value=''>请选择</option><s:iterator value='#materialsList'><option value='${id}'>${ name }</option></s:iterator></select></td><td><select name='unitId' id='input' class='form-control input-sm'><option value=''>请选择</option><s:iterator value='#unitList'><option value='${id}'>${ name }</option></s:iterator></select></td><td><input type='number' step='0.001' id='input' value='${ unitPrice }' name='unitPrice' class='form-control input-sm'></td><td><input type='number' step='0.001' id='input' value='${ number }' name='number' class='form-control input-sm'></td><td><input type='number' step='0.001' id='input' value='${ totalPrice }' name='totalPrice' class='form-control input-sm' readonly='readonly'></td></tr>";
	$('#'+id).append(str);
	$('tbody tr td input[name=number]').change(function(){
		var number = $(this).val();
		var unit = $(this).parent().prev().children("input").val();
		if (number != '' && unit != '') {
			$(this).parent().next().children("input").val(number*unit);
		}else{
			$(this).parent().next().children("input").val('');
		}
	});	
	$('tbody tr td input[name=unitPrice]').change(function(){
		var unit = $(this).val();
		var number = $(this).parent().next().children("input").val();
		if (number != '' && unit != '') {
			$(this).parent().next().next().children("input").val(number*unit);
		}else{
			$(this).parent().next().next().children("input").val('');
		}
	});	
}

function deleteRow(){
	$("table tr:not(:first):last").remove();
}
$(document).ready(function(e) {
	
	$('tbody tr td input[name=number]').change(function(){
		var number = $(this).val();
		var unit = $(this).parent().prev().children("input").val();
		if (number != '' && unit != '') {
			$(this).parent().next().children("input").val(number*unit);
		}else{
			$(this).parent().next().children("input").val('');
		}
	});	
	$('tbody tr td input[name=unitPrice]').change(function(){
		var unit = $(this).val();
		var number = $(this).parent().next().children("input").val();
		if (number != '' && unit != '') {
			$(this).parent().next().next().children("input").val(number*unit);
		}else{
			$(this).parent().next().next().children("input").val('');
		}
	});	
});
</script>
</head>

<body class="container">
<div class="page-header" id="page-header">
  <h3>其他出库单</h3>
</div>
<s:form action="otherOutAction_%{itemId==null?'add':'edit'}" cssClass="form form-horizontal" role="form" method="post">
  <s:hidden name="itemId"></s:hidden>
  <div id="top">
    <div class="row">
      <div class="col-md-4">
        <div class="form-group">
           <label for="input" class="col-md-4 control-label">领料部门:</label>
          <div class="col-md-8">
			<s:select id="input" cssClass="form-control input-sm" name="departmentId" list="#departmentList" 
      			listKey="id" listValue="name" headerKey="" headerValue="">
	  		</s:select>
          </div>
        </div>
      </div>
      <div class="col-md-4"></div>
      <div class="col-md-4">
        <div class="form-group">
          <label for="input" class="col-md-4 control-label">日期:</label>
          <div class="col-md-8">
          <input type="date" class="form-control input-sm" id="input" name="date" value="${date}">
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-4">
        <div class="form-group">
          <label for="input" class="col-md-4 control-label">单据编号:</label>
          <div class="col-md-8">
            <s:textfield cssClass="form-control input-sm" name="itemId" id="input" disabled="true"></s:textfield>
          </div>
        </div>
      </div>
      <div class="col-md-4"></div>
      <div class="col-md-4">
        <div class="form-group">
          <label for="input" class="col-md-4 control-label">发料仓库:</label>
          <div class="col-md-8">
          	<s:select id="input" cssClass="form-control input-sm" name="warehouseId" list="#warehouseList" 
      			listKey="id" listValue="name" headerKey="" headerValue="">
	  		</s:select>
          </div>
        </div>
      </div>
    </div>
  	<div class="row">
  		<div class="col-md-12">
	  		<div class="form-group">
	          <label for="input" class="col-md-1 control-label">说明:</label>
	          <div class="col-md-11">
	          	<input type="text" class="form-control input-sm" id="input" name="description" value="${description}">
	          </div>
	        </div>
	    </div>
  	</div>
  </div>
  <div id="alert" class="alert" role="alert">
    <div class="row">
     <div class="col-md-4"> 
	    <a role="button" class="btn btn-success btn-sm" onclick="addRow('tab');"><i class="fa fa-plus fa-lg"></i></a> 
	     <a role="button" class="btn btn-success btn-sm" onclick="deleteRow();"><i class="fa fa-minus fa-lg"></i></a> 
     </div>
      <div class="col-md-4">
        <button type="submit" class="btn  btn-primary btn-sm btn-block">保存</button>
      </div>
      <div class="col-md-4"> <a href="javascript:history.go(-1);" class="btn btn-primary btn-block btn-sm" role="button">返回</a> </div>
    </div>
  </div>
  <hr>
  <div id="table">
    <table class="table table-hover table-bordered table-striped table-responsive" id="tab">
      <thead>
        <tr>
          <th>物料名称</th>
          <th>单位</th>
          <th>单价</th>
          <th>数量</th>
          <th>总金额</th>
        </tr>
      </thead>
      <tbody>
      <s:if test="itemId!=null">
      <s:iterator value="inventoryOutMaterialsList">
        <tr>
          <td> 
          <s:select id="input" value="%{inventoryOutItem.materials.id}" name="materialsId" cssClass="form-control input-sm" list="#materialsList" listKey="materials.id" listValue="materials.name" headerKey="" headerValue="请选择物料" />
	  	  </td>
          <td>
          <s:select id="input" value="%{unit.id}" name="unitId" cssClass="form-control input-sm" list="#unitList" listKey="id" listValue="name" headerKey="" headerValue="请选择" />
		  </td>
          <td>
          	<input type='number' step='0.001' id="input" value="${ unitPrice }" name="unitPrice" class="form-control input-sm">
          </td>
          <td>
          <input type='number' step='0.001' id="input" value="${ number }" name="number" class="form-control input-sm">
          </td>
          <td>
          	<input type='number' step='0.001' id="input" value="${ totalPrice }" name="totalPrice" class="form-control input-sm" readonly="readonly">
          </td>
        </tr>
        </s:iterator>
        </s:if>
        <s:else>
        <tr>
          <td>
			<select name="materialsId" id="input" class="form-control input-sm">
			<option value="">请选择</option>
				<s:iterator value="#materialsList">
					<option value="${materials.id}">${ materials.name }</option>
				</s:iterator>
			</select>
	  	  </td>
          <td>
	  		<select name="unitId" id="input" class="form-control input-sm">
	  		<option value="">请选择</option>
				<s:iterator value="#unitList">
					<option value="${id}">${ name }</option>
				</s:iterator>
			</select>
		  </td>
          <td>
          	<input type='number' step='0.001' id="input" value="${ unitPrice }" name="unitPrice" class="form-control input-sm">
          </td>
          <td>
          <input type='number' step='0.001' id="input" value="${ number }" name="number" class="form-control input-sm">
          </td>
          <td>
          	<input type='number' step='0.001' id="input" value="${ totalPrice }" name="totalPrice" class="form-control input-sm" readonly="readonly">
          </td>
        </tr>
        </s:else>
      </tbody>
    </table>
  </div>
  <hr>
  <div class="row" id="bottom">
    <div class="col-md-3">
      <div class="form-group">
        <label for="input" class="col-md-4 control-label">业务员:</label>
        <div class="col-md-8">
        	<s:select id="input" cssClass="form-control input-sm" name="userId" list="#userList" 
      			listKey="id" listValue="name" headerKey="" headerValue="">
	  		</s:select>
        </div>
      </div>
    </div>
    <div class="col-md-3">
    	<div class="form-group">
        <label id="label" for="input" class="col-md-4 control-label">制单人:</label>
        <div class="col-md-8">
        	<input type="text" id="input" value="${ producer }" name="producer" class="form-control input-sm" readonly="readonly">
        </div>
      </div>
    </div>
    <div class="col-md-3">
    	<div class="form-group">
        <label id="label" for="input" class="col-md-4 control-label">审核日期:</label>
        <div class="col-md-8">
        	<input type="text" id="input" value="${ checkDate }" name="checkDate" class="form-control input-sm" readonly="readonly">
        </div>
      </div>
    </div>
    <div class="col-md-3">
      <div class="form-group">
        <label id="label" for="checkyn" class="col-md-3 control-label">审核:</label>
        <div class="col-md-9">
          <s:textfield cssClass="form-control input-sm" name="checkyn" id="checkyn" disabled="true"></s:textfield>
        </div>
      </div>
    </div>
  </div>
</s:form>
</body>
</html>
