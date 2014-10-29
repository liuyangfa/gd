<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>新增库存盘点单</title>
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
	overflow: auto;
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

<script type="text/javascript">
$(document).ready(function(e) {
	
	$('tbody tr td input[name=realNumber]').change(function(){
		var realNumber = $(this).val();
		var number=$(this).parent().prev().children('input').val();
		var result=realNumber-number;
		if(result>0){
			$(this).parent().next().children('input').val(result);
			$(this).parent().next().next().children('input').val('');
		}else if(result<0){
			$(this).parent().next().next().children("input").val(-result);
			$(this).parent().next().children("input").val('');
		}else{
			$(this).parent().next().children("input").val('');
			$(this).parent().next().next().children("input").val('');
		}
	});	
	
});
</script>
</head>

<body class="container">
<div class="page-header" id="page-header">
  <h3>库存盘点单</h3>
</div>
<s:form action="physicalAction_edit" cssClass="form form-horizontal" role="form" method="post">
  <s:hidden name="id"></s:hidden>
  <div id="top">
    <div class="row">
      <div class="col-md-4">
        <div class="form-group">
         <label for="date" class="col-md-4 control-label">盘点日期:</label>
          <div class="col-md-8">
          <input type="date" class="form-control input-sm" id="date" name="date" value="${date}">
          </div>
        </div>
      </div>
      <div class="col-md-4"></div>
      <div class="col-md-4">
        <div class="form-group">
        <label for="input" class="col-md-4 control-label">盘点仓库:</label>
          <div class="col-md-8">
			<s:select id="input" cssClass="form-control input-sm" name="warehouseId" list="#warehouseList" 
      			listKey="id" listValue="name" headerKey="" headerValue="" disabled="true">
	  		</s:select>
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
          <label for="input" class="col-md-4 control-label">备注:</label>
          <div class="col-md-8">
          	<input type="text" class="form-control input-sm" id="input" name="description" value="${ description }">
          </div>
        </div>
      </div>
    </div>
  </div>
  <div id="alert" class="alert" role="alert">
    <div class="row">
      <div class="col-md-2"></div>
      <div class="col-md-4">
        <button type="submit" class="btn  btn-primary btn-sm btn-block">保存</button>
      </div>
      <div class="col-md-4"> <a href="javascript:history.go(-1);" class="btn btn-primary btn-block btn-sm" role="button">返回</a> </div>
      <div class="col-md-2"></div>
    </div>
  </div>
  <hr>
  <div id="table">
    <table class="table table-hover table-bordered table-striped table-responsive" id="tab">
      <thead>
        <tr>
          <th>物料名称</th>
	      <th>常用单位</th>
	      <th>账存数量</th>
	      <th>实存数量</th>
	      <th>盘盈数量</th>
	      <th>盘亏数量</th>
        </tr>
      </thead>
      <tbody>
      <s:iterator value="#physicalMaterialsList">
        <tr>
          <td> 
          <s:select id="input" value="%{materials.id}" name="materialsId" cssClass="form-control input-sm" list="#materialsList" listKey="id" listValue="name" headerKey="" headerValue="请选择物料" readonly="readonly"/>
	  	  </td>
          <td>
          <s:select id="input" value="%{unit.id}" name="unitId" cssClass="form-control input-sm" list="#unitList" listKey="id" listValue="name" headerKey="" headerValue="请选择"  readonly="readonly"/>
		  </td>
          <td>
          	<input type="text" id="input" value="${ number }" name="number" class="form-control input-sm" readonly="readonly">
          </td>
          <td>
          	<input type="number" id="input" value="${ realNumber }" name="realNumber" class="form-control input-sm" step="0.001">
          </td>
          <td>
          	<input type="text" id="input" value="${ profitNumber }" name="profitNumber" class="form-control input-sm" readonly="readonly">
          </td>
          <td>
          	<input type="text" id="input" value="${ lossNumber }" name="lossNumber" class="form-control input-sm" readonly="readonly">
          </td>
        </tr>
        </s:iterator>
      </tbody>
    </table>
  </div>
  <hr>
  <div class="row" id="bottom">
    <div class="col-md-4">
      <div class="form-group">
        <label for="input" class="col-md-3 control-label">保管员:</label>
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
