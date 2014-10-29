<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>添加新类别</title>
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
  <h1>物料类别管理<small>Category Management</small></h1>
</div>
<div id="top">
  <s:form action="unitAction_%{id==null?'add':'edit'}" role="form" cssClass="form-horizontal" method="post" id="form">
   	<s:hidden name="id"></s:hidden>
    <div class="form-group">
      <label for="name" class="col-md-2 control-label">计量单位名称</label>
      <div class="col-md-10">
        <s:textfield name="name" cssClass="form-control" id="name" placeholder="类别名称"></s:textfield>
      </div>
    </div>
    <div class="form-group">
      <label class="col-md-2 control-label" for="description">说明</label>
      <div class="col-md-10">
        <s:textarea cssClass="form-control" rows="4" name="description" id="description" placeholder="说明"></s:textarea>
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