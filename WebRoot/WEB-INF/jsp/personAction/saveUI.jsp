<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!doctype html>
<html>
<head>
<title>个人信息修改</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<style type="text/css">
#form{
	margin-right: 300px;
	margin-top:20px;
}
#info{
	border: solid #ccc 1px;
	border-radius:10px;
}
</style>
</head>

<body class="container">
<div class="page-header">
  <h1>个人信息修改<small>Personal Inof Edit</small></h1>
</div>
<div id="info">
<s:form action="personAction_edit" id="form" cssClass="form-horizontal" role="form" method="post">
  <s:hidden name="id"></s:hidden>
  <div class="form-group">
    <label for="name" class="col-md-2 control-label">姓名</label>
    <div class="col-md-10">
    <input type="text" class="form-control" value="${ name }" name="name" id="name" placeholder="姓名">
   	  <s:fielderror fieldName="name"></s:fielderror>
    </div>
  </div>
  <div class="form-group">
    <label class="col-md-2 control-label">性别</label>
    <div class="col-md-10">
   		<div class="col-md-4">
   			<s:radio name="sex" list="{'男','女'}" cssClass="control-label"></s:radio>
   			<s:fielderror fieldName="sex"></s:fielderror>
    	</div>
    </div>
  </div>
  <div class="form-group">
    <label for="birthday" class="col-md-2 control-label">出生日期</label>
    <div class="col-md-10">
    	<input type="date" class="form-control" value="${ birthday }" name="birthday" id="birthday" placeholder="出生日期">
      <s:fielderror fieldName="birthday"></s:fielderror>
    </div>
  </div>
 <div class="form-group">
    <label for="phoneNumber" class="col-md-2 control-label">联系电话</label>
    <div class="col-md-10">
      <s:textfield cssClass="form-control" name="phoneNumber" id="phoneNumber" placeholder="联系电话"></s:textfield>
   	  <s:fielderror fieldName="phoneNumber"></s:fielderror>
    </div>
  </div>
  <div class="form-group">
    <label for="email" class="col-md-2 control-label">E-mail</label>
    <div class="col-md-10">
   		<input type="email" class="form-control" value="${ email }" name="email" id="email" placeholder="邮箱">
<!--       <s:textfield cssClass="form-control" name="email" id="email" placeholder="email"></s:textfield> -->
      <s:fielderror fieldName="email"></s:fielderror>
    </div>
  </div>
  <div class="form-group">
    <label for="address" class="col-md-2 control-label">住址</label>
    <div class="col-md-10">
      <s:textfield cssClass="form-control" name="address" id="address" placeholder="住址"></s:textfield>
   	  <s:fielderror fieldName="address"></s:fielderror>
    </div>
  </div>
  <div class="form-group" id="button">
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
