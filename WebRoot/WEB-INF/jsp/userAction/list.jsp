<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<title>用户管理</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<script type="text/javascript">
$(document).ready(function(e) {
	var leng=$('tbody tr').length;
	for ( var j = 0; j < leng; j++ ) {
		if($('tbody').find('tr').eq(j).find('td').eq(1).text()=='admin'){
			$('tbody').find('tr').eq(j).hide();
		}
	}
});
</script>
</head>

<body class="container">
<div class="page-header">
  <h1>用户管理<small>User Management</small></h1>
</div>
<div class="panel panel-info">
	<div class="panel-heading">用户
		<div class="pull-right">
			<s:a action="userAction_addUI" cssClass="btn btn-default btn-sm" role="button">添加</s:a>
		</div>
	</div>
	<table class="table table-hover table-bordered table-striped table-responsive">
    	<thead>
        	<tr><th>用户编号</th><th>登录名</th><th>姓名</th><th>所属部门</th><th>岗位</th><th>说明</th><th>相关操作</th></tr>
        </thead>
        <tbody>
	        <s:iterator value="recordList">
	        	<tr>
	        		<td>${ id }</td>
	            	<td>${ loginName }</td>
	                <td>${ name }</td>
	                <td>${ department.name }</td>
	                <td>
	               		<s:iterator value="roles">
	               			${ name }
	               		</s:iterator> 
	                </td>
	                <td>${ description }</td>
	                <td>
	              		<s:a id="delete" action="userAction_delete?id=%{id}" onclick="return confirm('确定要删除?')" title="删除"><i class="fa fa-trash-o fa-lg"></i></s:a>
						<s:a id="edit" action="userAction_editUI?id=%{id}" title="修改"><i class="fa fa-edit fa-lg"></i></s:a>
	                    <s:a id="init" action="userAction_initPassword?id=%{id}" title="初始化密码"><i class="fa fa-key fa-lg"></i></s:a>
						
	                </td>
	            </tr>
	        </s:iterator>
        </tbody>
    </table>
</div>
	<!-- 分页信息 -->
<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
	<s:form action="userAction_list"></s:form>
</body>
</html>
