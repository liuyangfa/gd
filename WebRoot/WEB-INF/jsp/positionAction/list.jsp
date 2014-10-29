<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>仓位列表</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
</head>

<body class="container">
<div class="page-header">
  <h1>仓位管理<small>Position Management</small></h1>
</div>
<div class="panel panel-info">
	<div class="panel-heading">仓位
		<div class="pull-right">
			<s:a action="positionAction_addUI" cssClass="btn btn-default btn-sm" role="button">添加</s:a>
		</div>
	</div>
	<table class="table table-hover table-bordered table-striped table-responsive">
    	<thead>
        	<tr><th>仓位名称</th><th>所属仓库</th><th>备注</th><th>相关操作</th></tr>
        </thead>
        <tbody>
        <s:iterator value="#positionList">
        	<tr>
            	<td>${ name }</td>
                <td>${ warehouse.name }</td>
                <td>${ description }</td>
                <td>
              		<s:a action="positionAction_delete?id=%{id}" onClick="return confirm('确定要删除?')" title="删除"><i class="fa fa-trash-o fa-lg"></i></s:a>
					<s:a action="positionAction_editUI?id=%{id}" title="修改"><i class="fa fa-edit fa-lg"></i></s:a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</div>
</body>
</html>