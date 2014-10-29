<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>部门列表</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
</head>

<body class="container">
<div class="page-header">
  <h1>部门管理<small>Department Management</small></h1>
</div>
<div class="panel panel-info">
	<div class="panel-heading">部门
		<div class="pull-right">
			<s:a action="departmentAction_addUI?parentId=%{#parent.id}" cssClass="btn btn-default btn-sm" role="button">添加</s:a>
			<s:if test="#parent!=null">
				<s:a action="departmentAction_list?parentId=%{#parent.parent.id}" cssClass="btn btn-default btn-sm" role="button">返回上一级</s:a>
			</s:if>
		</div>
	</div>
	<table class="table table-hover table-bordered table-striped table-responsive">
    	<thead>
        	<tr><th>部门名称</th><th>上级部门</th><th>职能说明</th><th>相关操作</th></tr>
        </thead>
        <tbody>
        <s:iterator value="#departmentList">
        	<tr>
            	<td><s:a action="departmentAction_list?parentId=%{id}">${ name }</s:a></td>
                <td>${ parent.name }</td>
                <td>${ description }</td>
                <td>
              		<s:a action="departmentAction_delete?id=%{id}&parentId=%{parent.id}" onclick="return confirm('确定要删除?')" title="删除"><i class="fa fa-trash-o fa-lg"></i></s:a>
					<s:a action="departmentAction_editUI?id=%{id}" title="修改"><i class="fa fa-edit fa-lg"></i></s:a>
                </td>
            </tr>
          </s:iterator>
        </tbody>
    </table>
</div>
</body>
</html>
