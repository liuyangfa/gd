<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>添加新客户</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<style type="text/css">
#input {
	border: none;
	border-radius: 0px;
	box-shadow: none;
	background-color: #FFF;
}

.pull-right {
	margin: -8px;
}
#table {
	height: 460px;
	overflow-x: hidden;
	overflow-y: auto;
}
</style>
<script type="text/javascript">

function addRow(id){
	var str="<tr><td><input id='input' type='text' value='${ category }' name='category' class='form-control input-sm'></td><td><input id='input' type='number' value='${ yearStorage }' name='yearStorage' class='form-control input-sm' step='0.001'></td><td><input id='input' type='number' value='${ price }' name='price' class='form-control input-sm' step='0.001'></td><td><input id='input' type='number' value='${ yearAmountOfCapital }' name='yearAmountOfCapital' class='form-control input-sm' step='0.001'></td></tr>";
	$('#'+id).append(str);
	$('tbody tr td input[name=price]').change(function(){
		var unit = $(this).val();
		var number = $(this).parent().prev().children("input").val();
		if (number != '' && unit != '') {
			$(this).parent().next().children("input").val(number*unit);
		}else{
			$(this).parent().next().children("input").val('');
		}
	});	
	$('tbody tr td input[name=yearStorage]').change(function(){
		var number = $(this).val();
		var unit = $(this).parent().next().children("input").val();
		if (number != '' && unit != '') {
			$(this).parent().next().next().children("input").val(number*unit);
		}else{
			$(this).parent().next().next().children("input").val('');
		}
	});
}

function deleteRow(){
	$("table tr:not(:first):last").remove();
}
$(document).ready(function(e) {
	
	$('tbody tr td input[name=price]').change(function(){
		var unit = $(this).val();
		var number = $(this).parent().prev().children("input").val();
		if (number != '' && unit != '') {
			$(this).parent().next().children("input").val(number*unit);
		}else{
			$(this).parent().next().children("input").val('');
		}
	});	
	$('tbody tr td input[name=yearStorage]').change(function(){
		var number = $(this).val();
		var unit = $(this).parent().next().children("input").val();
		if (number != '' && unit != '') {
			$(this).parent().next().next().children("input").val(number*unit);
		}else{
			$(this).parent().next().next().children("input").val('');
		}
	});	
});
</script>
</head>

<body class="container">
	<div class="page-header">
		<h1>
			ABC分类基础数据<small>ABC Classification Base Data</small>
		</h1>
	</div>
	<s:form action="baseDataAction_%{id==null?'add':'edit'}" role="form"
		cssClass="form-horizontal" method="post">
		<s:hidden name="id"></s:hidden>
		<div class="panel panel-primary" id="table">
			<div class="panel-heading">
				基础数据
				<div class="pull-right">
					<a role="button" class="btn btn-warning btn-sm"
						onclick="addRow('tab');"><i class="fa fa-plus fa-lg"></i></a> <a
						role="button" class="btn btn-warning btn-sm"
						onclick="deleteRow();"><i class="fa fa-minus fa-lg"></i></a>
					<button type="submit" class="btn btn-success">保存</button>
					<a href="javascript:history.go(-1);" class="btn btn-success"
						role="button">返回</a>
				</div>
			</div>
			<table
				class="table table-hover table-bordered table-striped table-responsive" id="tab">
				<thead>
					<tr>
						<th>物料类别</th>
						<th>年库存量</th>
						<th>单价</th>
						<th>年资金占用额</th>
					</tr>
				</thead>
				<tbody>
				<s:if test="id!=null">
				<s:iterator value="#basedataList">
					<tr>
						<td><input id="input" type="text" value="${ category }"
							name="category" class="form-control input-sm"></td>
						<td><input id="input" type="number" value="${ yearStorage }"
							name="yearStorage" class="form-control input-sm" step="0.001"></td>
						<td><input id="input" type="number" value="${ price }"
							name="price" class="form-control input-sm" step="0.001"></td>
						<td><input id="input" type="number"
							value="${ yearAmountOfCapital }" name="yearAmountOfCapital"
							class="form-control input-sm" step="0.001"></td>
					</tr>
				</s:iterator>
				
				</s:if>
				<s:else>
					<tr>
						<td><input id="input" type="text" value="${ category }"
							name="category" class="form-control input-sm"></td>
						<td><input id="input" type="number" value="${ yearStorage }"
							name="yearStorage" class="form-control input-sm" step="0.001"></td>
						<td><input id="input" type="number" value="${ price }"
							name="price" class="form-control input-sm" step="0.001"></td>
						<td><input id="input" type="number"
							value="${ yearAmountOfCapital }" name="yearAmountOfCapital"
							class="form-control input-sm" step="0.001"></td>
					</tr>
				</s:else>
				</tbody>
			</table>
		</div>
	</s:form>
</body>
</html>
