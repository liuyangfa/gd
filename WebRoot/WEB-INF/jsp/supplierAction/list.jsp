<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>供应商列表</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
</head>

<body class="container">
<div class="page-header">
  <h1>供应商管理<small>Supplier Management</small></h1>
</div>
<div class="panel panel-info">
	<div class="panel-heading">供应商
		<div class="pull-right">
			<s:a action="supplierAction_addUI" cssClass="btn btn-default btn-sm" role="button">添加</s:a>
		</div>
	</div>
	<table class="table table-hover table-bordered table-striped table-responsive">
    	<thead>
        	<tr><th>名称</th><th>联系人</th><th>联系电话</th><th>地址</th><th>说明</th><th>相关操作</th></tr>
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
              		<s:a id="delete" action="supplierAction_delete?id=%{id}" onClick="return confirm('确定要删除?')" title="删除"><i class="fa fa-trash-o fa-lg"></i></s:a>
					<s:a id="edit" action="supplierAction_editUI?id=%{id}" title="修改"><i class="fa fa-edit fa-lg"></i></s:a>
                </td>
            </tr>
            </s:iterator>
        </tbody>
    </table>
</div>
<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
	<s:form action="supplierAction_list"></s:form>
</body>
</html>