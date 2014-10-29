<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<title>用户管理</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<style>
.page-header{
	margin-top:0px;
}
.userInfo{
	border:solid #CCC 1px;
	border-radius:10px;
}
.roleInfo{
	border:solid #CCC 1px;
	border-radius:10px;
}
#role{
	margin-right:300px;
}
#button{
	margin-top:10px;
}
</style>
</head>

<body class="container">
<div class="page-header">
  <h1>用户管理<small>User Management</small></h1>
</div>
<s:form action="userAction_%{id==null?'add':'edit'}" role="form" cssClass="form-horizontal" method="post">
	<s:hidden name="id"></s:hidden>
	<div class="page-header"><i class="fa fa-angle-double-right"></i>用户信息</div>
    <div class="userInfo">
    <br>
    <div class="form-group" id="role">
 	<label class="col-md-2 control-label">所属部门</label>
    <div class="col-md-10">
      <s:select cssClass="form-control" name="departmentId" list="#departmentList" 
      		listKey="id" listValue="name" headerKey="" headerValue="-------------------------------------请选择所属部门----------------------------------">
	  </s:select>
    </div>
  </div>
  <div class="form-group" id="role">
    <label for="loginName" class="col-md-2 control-label">登录名</label>
    <div class="col-md-10">
      <s:textfield cssClass="form-control" name="loginName" id="loginName" placeholder="登录名"></s:textfield>
    </div>
  </div>
  <div class="form-group" id="role">
    <label for="userName" class="col-md-2 control-label">姓名</label>
    <div class="col-md-10">
      <input type="text" class="form-control" value="${ name }" name="name" id="userName" placeholder="姓名">
    </div>
  </div>
  <div class="form-group" id="role">
    <label class="col-md-2 control-label">性别</label>
    <div class="col-md-10">
   		<div class="col-md-4">
   			<s:radio name="sex" list="{'男','女'}" cssClass="control-label"></s:radio>
    	</div>
    </div>
  </div>
  <div class="form-group" id="role">
    <label for="birthday" class="col-md-2 control-label">出生日期</label>
    <div class="col-md-10">
    	<input type="date" class="form-control" value="${ birthday }" name="birthday" id="birthday">
    </div>
  </div>
  <div class="form-group" id="role">
    <label for="phoneNumber" class="col-md-2 control-label">联系电话</label>
    <div class="col-md-10">
      <input type="tel" class="form-control" value="${ phoneNumber }" name="phoneNumber" id="phoneNumber" placeholder="联系电话">
<!--       <s:textfield cssClass="form-control" name="phoneNumber" id="phoneNumber" placeholder="联系电话"></s:textfield> -->
    </div>
  </div>
  <div class="form-group" id="role">
    <label for="email" class="col-md-2 control-label">E-mail</label>
    <div class="col-md-10">
    	<input type="email" class="form-control" value="${ email }" name="email" id="email" placeholder="邮箱">
    </div>
  </div>
  <div class="form-group" id="role">
    <label for="address" class="col-md-2 control-label">住址</label>
    <div class="col-md-10">
      <s:textfield cssClass="form-control" name="address" id="address" placeholder="住址"></s:textfield>
    </div>
  </div>
  <div class="form-group" id="role">
      <label class="col-md-2 control-label" for="description">说明</label>
      <div class="col-md-10">
      <s:textarea cssClass="form-control" rows="4" name="description" id="description" placeholder="说明"></s:textarea>
  	  </div>
  </div>
  </div>
  <div class="page-header"><i class="fa fa-angle-double-right"></i>岗位设置</div>
  <div class="roleInfo">
  	<br>
  	<div class="form-group" id="role">
        <label class="col-md-2 control-label">岗位</label>
        <div class="col-md-10">
        	<s:select cssClass="form-control" name="roleIds" multiple="true" size="6" list="#roleList" listKey="id" listValue="name">
	  	    </s:select>
	  	    
        </div>
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
</body>
</html>
