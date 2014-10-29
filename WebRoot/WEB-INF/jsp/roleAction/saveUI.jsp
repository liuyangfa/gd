<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>岗位管理页面</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<style type="text/css">
#top{
	border:solid #ccc 1px;
	border-radius:10px;
}
#form{
	margin-top:10px;
	margin-right:300px;
}

</style>

</head>

<body class="container">
	<div class="page-header">
		<h1>
			岗位管理<small>Role Management</small>
		</h1>
	</div>
	<div id="top">
	<s:form action="roleAction_%{id==null?'add':'edit'}" role="form" id="form"
		cssClass="form-horizontal" method="post">
		<s:hidden name="id"></s:hidden>
		<div class="form-group">
			<label for="roleName" class="col-md-2 control-label">岗位名称</label>
			<div class="col-md-10">
				<s:textfield cssClass="form-control" id="roleName" name="name"
					placeholder="岗位名称" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 control-label" for="description">岗位说明</label>
			<div class="col-md-10">
				<s:textarea cssClass="form-control" name="description" rows="4"
					id="description" placeholder="岗位说明"></s:textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-2">
				<button type="submit" class="btn btn-primary">保存</button>
			</div>
			<div class="col-md-8">
				<a href="javascript:history.go(-1);" class="btn btn-primary"
					role="button">返回</a>
			</div>
		</div>
	</s:form>
	</div>
</body>
</html>
