<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>添加新部门</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<style type="text/css">
#form{
	margin-top:10px;
	margin-right:300px;
}
#top{
	border:solid #CCC 1px;
	border-radius:10px;
}
</style>
</head>

<body class="container">
<div class="page-header">
  <h1>部门管理<small>Deparment Management</small></h1>
</div>
<div id="top">
<s:form action="departmentAction_%{id==null?'add':'edit'}" role="form" cssClass="form-horizontal" method="post" id="form">
  <s:hidden name="id"></s:hidden>
  <div class="form-group">
 	<label for="roleName" class="col-md-2 control-label">上级部门</label>
    <div class="col-md-10">
      <s:select cssClass="form-control" name="parentId" 
		      list="#departmentList" listKey="id" listValue="name"
		      headerKey="" headerValue="------请选择所属部门--------------">
	  </s:select>
    </div>
  	
  </div>
  <div class="form-group">
    <label for="roleName" class="col-md-2 control-label">部门名称</label>
    <div class="col-md-10">
      <s:textfield cssClass="form-control" name="name" id="roleName" placeholder="部门名称"></s:textfield>
    </div>
  </div>
  <div class="form-group">
      <label class="col-md-2 control-label" for="description">职能说明</label>
      <div class="col-md-10">
      <s:textarea cssClass="form-control" rows="4" name="description" id="description" placeholder="职能说明"></s:textarea>
  	  </div>
  </div>
  <div class="form-group">
    <div class="col-md-offset-2 col-md-2">
      <button type="submit" class="btn btn-primary">保存</button>
    </div>
    <div class="col-md-8">
      <a href="javascript:history.go(-1);" class="btn btn-primary" role="button">返回</a>
    </div>
  </div>
</s:form>
</div>
</body>
</html>
