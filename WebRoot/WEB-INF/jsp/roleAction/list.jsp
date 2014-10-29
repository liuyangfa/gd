<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>岗位管理</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
</head>

<body class="container">
	<div class="page-header">
		<h1>
			岗位管理<small>Role Management</small>
		</h1>
	</div>
	<div class="panel panel-info">
	<div class="panel-heading">岗位
		<div class="pull-right">
			<s:a action="roleAction_addUI" cssClass="btn btn-default btn-sm" role="button">添加</s:a>
		</div>
	</div>
		<table class="table table-hover table-bordered table-striped table-responsive">
			<thead>
				<tr>
					<th>岗位编号</th>
					<th>岗位名称</th>
					<th>岗位说明</th>
					<th>相关操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="recordList">
					<tr>
						<td>${ id }</td>
						<td>${name}</td>
						<td>${description}</td>
						<td>
							<s:a id="a" action="roleAction_delete?id=%{id}" onClick="return confirm('确定要删除?')" title="删除"><i class="fa fa-trash-o fa-lg"></i></s:a> 
							<s:a id="a" action="roleAction_editUI?id=%{id}" title="修改"><i class="fa fa-edit fa-lg"></i></s:a>
							<s:a id="a" action="roleAction_setPrivilegeUI?id=%{id}" title="设置权限"><i class="fa fa-lock fa-lg"></i></s:a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
	<s:form action="roleAction_list"></s:form>
</body>
</html>
