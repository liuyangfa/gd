<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<title>通知管理</title>

<script type="text/javascript">
$(document).ready(function(e) {
	var leng=$('tbody tr').length;
	for ( var j = 0; j < leng; j++ ) {
		var a=$('#comment').attr('id','comment'+j).attr('id');
		if($('#'+a).parents().find('tbody tr').eq(j).find('td input').attr('value')=='YES'){
			 $('#'+a+' i').removeClass('fa fa-lg fa-bell');
			 $('#'+a+' i').addClass('fa fa-lg fa-bell-o');
		}
	}  
});
</script>
</head>
<body class="container">
	<div class="page-header">
		<h1>
			系统通知管理<small>SystemNotice Management</small>
		</h1>

	</div>
	<div class="panel panel-danger">
		<div class="panel-heading">
			系统通知
		</div>
		<table
			class="table table-hover table-bordered table-striped table-responsive">
			<thead>
				<tr>
					<th>通知编号</th>
					<th>通知主题</th>
					<th>通知摘要</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="recordList">
					<tr>
						<td><s:a action="systemNoticeAction_listInfo?id=%{id}">${id}</s:a></td>
						<td id="comment"><s:a action="systemNoticeAction_listInfo?id=%{id}">
							<i class="fa fa-bell fa-lg"></i>&nbsp;&nbsp;${name}</s:a>
							<input type="hidden" value="${viewyn}" >
						</td>
						<td><s:a action="systemNoticeAction_listInfo?id=%{id}">${summary}</s:a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<!-- 分页信息 -->
	<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>
	<s:form action="systemNoticeAction_list"></s:form>

</body>
</html>
