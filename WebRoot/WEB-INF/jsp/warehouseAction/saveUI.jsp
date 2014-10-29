<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>添加新仓库</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<style type="text/css">
#form{
	margin-top:10px;
	margin-right:100px;
}
#top{
	border:solid #CCC 1px;
	border-radius:10px;
}
</style>
</head>
<body class="container">
<div class="page-header">
  <h1>仓库管理<small>Warehouse Management</small></h1>
</div>
<div id="top">
  <s:form action="warehouseAction_%{id==null?'add':'edit'}" role="form" cssClass="form-horizontal" method="post" id="form">
    <s:hidden name="id"></s:hidden>
    <div class="form-group">
      <label for="name" class="col-md-2 control-label">仓库名称</label>
      <div class="col-md-10">
        <s:textfield name="name" cssClass="form-control" id="name" placeholder="仓库名称"></s:textfield>
      </div>
    </div>
    <div class="form-group">
      <label class="col-md-2 control-label" for="address">仓库地址</label>
      <div class="col-md-10">
        <s:textfield cssClass="form-control" name="address" id="address" placeholder="仓库地址"></s:textfield>
      </div>
    </div>
    <div class="form-group">
      <label class="col-md-2 control-label" for="description">备注</label>
      <div class="col-md-10">
        <s:textfield cssClass="form-control" name="description" id="description" placeholder="备注"></s:textfield>
      </div>
    </div>
    <div class="form-group">
      <div class="col-md-offset-2 col-md-2"> <button type="submit" class="btn btn-primary">保存</button> </div>
      <div class="col-md-8"><a href="javascript:history.go(-1);" class="btn btn-primary" role="button">返回</a> </div>
    </div>
  </s:form>
</div>
</body>
</html>
