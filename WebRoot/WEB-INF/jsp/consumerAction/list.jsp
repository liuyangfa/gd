<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>客户列表</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>

</head>

<body class="container">
	<div class="page-header">
		<h1>
			客户管理<small>Consumer Management</small>
		</h1>
	</div>
	<div  class="panel panel-info">
	<div class="panel-heading">客户
		<div class="pull-right">
			<s:a action="consumerAction_addUI" cssClass="btn btn-default btn-sm" role="button">添加</s:a>
		</div>
	</div>
		<table class="table table-hover table-bordered table-striped table-responsive">
			<thead>
				<tr>
					<th>客户名称</th>
					<th>联系人</th>
					<th>联系电话</th>
					<th>地址</th>
					<th>说明</th>
					<th>相关操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="recordList">
					<tr>
						<td>${ name }</td>
						<td>${ contact }</td>
						<td>${ phoneNumber }</td>
						<td>${ address }</td>
						<td>${ description }</td>
						<td>
							<s:a id="a" action="consumerAction_delete?id=%{id}" onClick="return confirm('确定要删除?')" title="删除"><i
								class="fa fa-trash-o fa-lg"></i></s:a>
							<s:a id="a" action="consumerAction_editUI?id=%{id}" title="修改"><i class="fa fa-edit fa-lg"></i></s:a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
	<s:form action="consumerAction_list"></s:form>
</body>
</html>

