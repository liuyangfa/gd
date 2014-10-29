<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<title>密码修改</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<style type="text/css">
#form{
	margin-top:20px;
	margin-left:10px;
	margin-right:50px;
}
</style>
</head>

<body class="container">
<div class="page-header">
  <h1>密码修改<small>Password Edit</small></h1>
</div>
<div id="pass">
<div class="panel panel-danger">
		<div class="panel-heading">
			修改密码
		</div>
  <s:form role="form" cssClass="form-horizontal" action="passwordAction_edit" method="post" id="form">
    <div class="form-group">
      <label for="oldpassword" class="col-md-2 control-label">请输入旧密码</label>
      <div class="col-md-6">
     	<input type="password" autofocus="autofocus" tabindex="1" class="form-control" name="oldpassword" id="oldpassword" required>
      </div>
      <div class="col-md-4">
      	<s:fielderror fieldName="oldpassword" cssStyle="color:red"></s:fielderror>
      </div>
    </div>
    <div class="form-group">
      <label for="password" class="col-md-2 control-label">请输入新密码</label>
      <div class="col-md-6">
        <input type="password" class="form-control" tabindex="2" name="newpassword" id="password" required>
      </div>
      <div class="col-md-4">
     	<s:fielderror fieldName="newpassword" cssStyle="color:red"></s:fielderror>
    </div>
    </div>
    <div class="form-group">
      <label for="confirmpassword" class="col-md-2 control-label">请再次输入新密码</label>
      <div class="col-md-6">
      	<input type="password" class="form-control" tabindex="3" name="confirmpassword" id="confirmpassword" required>
      </div>
    </div>
    <div class="form-group" id="button">
      <div class="col-md-offset-2 col-md-2">
        <button type="submit" tabindex="4" class="btn btn-primary">保存</button>
      </div>
      <div class="col-md-8">
  	 	 <button type="reset" tabindex="4" class="btn btn-primary">重置</button>
    </div>
    </div>
  </s:form>
  </div>
</div>
</body>
</html>
