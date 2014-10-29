<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>ABC分类基础数据</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<script type="text/javascript">
	$(document).ready(function(e) {
		var leng = $('tbody tr').length;
		for (var j = 0; j < leng; j++) {
			var a = $('#delete').attr('id', 'delete' + j).attr('id');
			if(j!=0){
				$('#'+a).parents().find('tbody tr').eq(j).find('td:last').css('visibility','hidden');
			}
		}
	});
</script>
</head>

<body class="container">
	<div class="page-header">
		<h1>
			ABC分类基础数据<small>ABC Classification Base Data</small>
		</h1>
	</div>
	<div class="panel panel-info">
		<div class="panel-heading">
			基础数据
			<div class="pull-right">
				<s:a action="baseDataAction_addUI" cssClass="btn btn-default btn-sm" role="button">添加</s:a>
				<s:a action="baseDataAction_analysis" cssClass="btn btn-default btn-sm" role="button">分析</s:a>
				<s:a action="abcAnalysisAction_list" cssClass="btn btn-default btn-sm" role="button">分类</s:a>
			</div>
		</div>
		<table
			class="table table-hover table-bordered table-striped table-responsive">
			<thead>
				<tr>
					<th>序号</th>
					<th>物料类别</th>
					<th>年库存量</th>
					<th>单价</th>
					<th>年资金占用额</th>
					<th>相关操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="recordList">
					<tr>
						<td>${ id }</td>
						<td>${ category }</td>
						<td>${ yearStorage }</td>
						<td>${ price }</td>
						<td>${ yearAmountOfCapital }</td>
						<td><s:a id="delete" action="baseDataAction_delete?id=%{id}"
								onClick="return confirm('确定要删除?')" title="删除">
								<i class="fa fa-trash-o fa-lg"></i>
							</s:a> <s:a id="edit" action="baseDataAction_editUI?id=%{id}"
								title="修改">
								<i class="fa fa-edit fa-lg"></i>
							</s:a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<div class="alert alert-info" role="alert">


	</div>
	<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>
<s:form action="purchaseAction_list"></s:form>
</body>
</html>

