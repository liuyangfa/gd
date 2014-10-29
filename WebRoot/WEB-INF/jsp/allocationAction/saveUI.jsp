<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>新增调拨单</title>
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
	var str="<tr><td><select name='materialsId' id='input' class='form-control input-sm'><option value=''>请选择</option><s:iterator value='#materialsList'><option value='${id}'>${ name }</option></s:iterator></select></td><td><select name='unitId' id='input' class='form-control input-sm'><option value=''>请选择</option><s:iterator value='#unitList'><option value='${id}'>${ name }</option></s:iterator></select></td><td><input type='text' id='input' value='${ number }' name='number' class='form-control input-sm'></td></tr>";
	$('#'+id).append(str);
}

function deleteRow(){
	$("table tr:not(:first):last").remove();
}

$(document).ready(function(){
	$('select[name="outWarehouseId"]').change(function(){
		var selectValue=$('select[name="outWarehouseId"] option:selected').val();
		$("#material").children('option[value!=""]').remove();
		$.ajax({
			url:"allocationAction_getMaterials.action",
			 type:"post",
			dataType:"json",
			data:{outWarehouseId:selectValue},
			success:function(data){
				$.each(data, function(index,value){
					$("#material").append("<option value='"+value.materials.id+"'>"+value.materials.name+"</option>");
				});
			}
		});
	});
	
	$('select[name="materialsId"]').change(function(){
		var selectValue=$('select[name="materialsId"] option:selected').val();
		var selectWare=$('select[name="outWarehouseId"] option:selected').val();
		$.ajax({
			url:"allocationAction_getUnit.action",
			 type:"post",
			dataType:"json",
			data:{materialsId:selectValue,outWarehouseId:selectWare},
			success:function(data){
				$("select[name='unitId']").append("<option value='"+data.unit.id+"'>"+data.unit.name+"</option>");//.attr("value",data.unit.id);
				$("input[name='number']").attr("value",data.number);
				
			}
		});
	});
});
</script>
</head>

<body class="container">
<div class="page-header" id="page-header">
  <h3>库存调拨单</h3>
</div>
<s:form action="allocationAction_%{id==null?'add':'edit'}" cssClass="form form-horizontal" role="form" method="post">
  <s:hidden name="id"></s:hidden>
  <div id="top">
    <div class="row">
      <div class="col-md-4">
        <div class="form-group">
          <label for="input" class="col-md-4 control-label">调出仓库:</label>
          <div class="col-md-8">
			<s:select id="input" cssClass="form-control input-sm" name="outWarehouseId" list="#warehouseList" 
      			listKey="id" listValue="name" headerKey="" headerValue="">
	  		</s:select>
          </div>
        </div>
      </div>
      <div class="col-md-4">
     	 <div class="form-group">
          <label for="input" class="col-md-4 control-label">调入仓库:</label>
          <div class="col-md-8">
			<s:select id="input" cssClass="form-control input-sm" name="inWarehouseId" list="#warehouseList" 
      			listKey="id" listValue="name" headerKey="" headerValue="">
	  		</s:select>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="form-group">
          <label for="date" class="col-md-4 control-label">日期:</label>
          <div class="col-md-8">
          <input type="date" class="form-control input-sm" id="date" name="date" value="${date}">
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-4">
        <div class="form-group">
          <label for="id" class="col-md-4 control-label">单据编号:</label>
          <div class="col-md-8">
            <s:textfield cssClass="form-control input-sm" name="id" id="id" disabled="true"></s:textfield>
          </div>
        </div>
      </div>
      <div class="col-md-8">
        <div class="form-group">
          <label for="description" class="col-md-2 control-label">说明:</label>
          <div class="col-md-10">
          	<input type="text" class="form-control input-sm" id="description" name="description" value="${description}">
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
          <th>调拨数量</th>
        </tr>
      </thead>
      <tbody>
      <s:if test="id!=null">
      <s:iterator value="allocationMaterialsList">
        <tr>
          <td> 
          <s:select id="input" value="%{materials.id}" name="materialsId" cssClass="form-control input-sm" list="#materialsList" listKey="id" listValue="name" headerKey="" headerValue="请选择物料" />
	  	  </td>
          <td>
          <s:select id="input" value="%{unit.id}" name="unitId" cssClass="form-control input-sm" list="#unitList" listKey="id" listValue="name" headerKey="" headerValue="请选择" />
		  </td>
          <td>
          <input type="text" id="input" value="${ number }" name="number" class="form-control input-sm">
          </td>
        </tr>
        </s:iterator>
        </s:if>
        <s:else>
        <tr>
          <td>
			<select id="material" name="materialsId" id="input" class="form-control input-sm">
			<option value="">请选择</option>
<!-- 				<s:iterator value="#materialsList"> -->
<!-- 					<option value="${id}">${ name }</option> -->
<!-- 				</s:iterator> -->
			</select>
	  	  </td>
          <td>
	  		<select name="unitId" id="input" class="form-control input-sm">
<!-- 	  		<option value="">请选择</option> -->
<!-- 				<s:iterator value="#unitList"> -->
<!-- 					<option value="${id}">${ name }</option> -->
<!-- 				</s:iterator> -->
			</select>
<!-- 				<input type="text" id="input" name="unitId" class="form-control input-sm"> -->
		  </td>
          <td>
          		<input type="text" id="input" name="number" class="form-control input-sm">
          </td>
        </tr>
        </s:else>
      </tbody>
    </table>
  </div>
  <hr>
  <div class="row" id="bottom">
    <div class="col-md-4">
      <div class="form-group">
        <label for="input" class="col-md-3 control-label">业务员:</label>
        <div class="col-md-9">
        	<s:select id="input" cssClass="form-control input-sm" name="userId" list="#userList" 
      			listKey="id" listValue="name" headerKey="" headerValue="">
	  		</s:select>
        </div>
      </div>
    </div>
    <div class="col-md-4"></div>
    <div class="col-md-4">
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
