<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>新增库存调整单</title>
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
	border-bottom: 1px #000 solid;
}
#bottom #input {
	border: none;
	border-radius: 0px;
	box-shadow: none;
	background-color: #FFF;
	border-bottom: 1px #000 solid;
}
</style>
</head>

<body class="container">
<div class="page-header" id="page-header">
  <h3>库存调整单</h3>
</div>
<s:form action="adjustmentAction_edit" cssClass="form form-horizontal" role="form" method="post">
  <s:hidden name="itemId"></s:hidden>
  <div id="top">
    <div class="row">
      <div class="col-md-4">
        <div class="form-group">
          <label for="id" class="col-md-4 control-label">单据编号:</label>
          <div class="col-md-8">
            <s:textfield cssClass="form-control input-sm" name="id" id="id" readonly="true"></s:textfield>
          </div>
        </div>
      </div>
      <div class="col-md-4"></div>
      <div class="col-md-4">
        <div class="form-group">
          <label for="date" class="col-md-4 control-label">调整日期:</label>
          <div class="col-md-8">
          <input type="date" class="form-control input-sm" id="date" name="date" value="${date}">
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-8">
        <div class="form-group">
          <label for="description" class="col-md-2 control-label">备注:</label>
          <div class="col-md-10">
          	<input type="text" class="form-control input-sm" id="description" name="description" value="${description}">
          </div>
        </div>
      </div>
      <div class="col-md-2"></div>
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
          <th>账存数量</th>
          <th>实存数量</th>
          <th>调整数量</th>
          <th>差异量</th>
          <th>差异原因</th>
          <th>调整原因</th>
        </tr>
      </thead>
      <tbody>
      <s:iterator value="#adjustmentMaterialsList">
        <tr>
          <td> 
          <s:select id="input" value="%{materials.id}" name="materialsId" cssClass="form-control input-sm" list="#materialsList" listKey="id" listValue="name" headerKey="" headerValue="请选择物料" readonly="true" />
	  	  </td>
          <td>
          	<input type="text" id="input" value="${ number }" name="number" class="form-control input-sm" readonly="readonly">
		  </td>
          <td>
          	<input type="text" id="input" value="${ realNumber }" name="realNumber" class="form-control input-sm" readonly="readonly">
          </td>
          <td>
          <input type="text" id="input" value="${ adjustNumber }" name="adjustNumber" class="form-control input-sm">
          </td>
          <td>
          	<input type="text" id="input" value="${ differenceQuantity }" name="differenceQuantity" class="form-control input-sm">
          </td>
          <td>
          	<input type="text" id="input" value="${ differenceReason }" name="differenceReason" class="form-control input-sm">
          </td>
          <td>
          	<input type="text" id="input" value="${ adjustReason }" name="adjustReason" class="form-control input-sm">
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
        <label for="checkyn" class="col-md-3 control-label">审核:</label>
        <div class="col-md-9">
          <s:textfield cssClass="form-control input-sm" name="checkyn" id="checkyn" readonly="true"></s:textfield>
        </div>
      </div>
    </div>
  </div>
</s:form>
</body>
</html>
