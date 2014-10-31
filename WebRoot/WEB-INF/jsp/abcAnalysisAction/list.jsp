<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>ABC分析分类</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<script src="${pageContext.request.contextPath}/Chart.js-master/Chart.js"></script>
<script>
$(document).ready(function(){
			$('.canvas').children('#canvas1').hide();
			$('.canvas').children('#canvas2').hide();
			$('#z').click(function(){
				var result = new Array();
				result.push("0");
				var cap=new Array();
				cap.push("0");
				$.ajax({
		 			url:"abcAnalysisAction_labelLine.action",
		 			async:false,
		 			type:"post",
		 			dataType:"json",
		 			success:function(data){
		 				$.each(data, function(index,value){
		 					result.push(value.category);
		 					cap.push(value.yearAmountOfCapitalTotalPercent);
		 				});
		 			}
		 		});
				var lineChartData = {
						labels : result,
						datasets : [
							{
								label: "折线图",
								fillColor : "rgba(220,220,220,0.2)",
								strokeColor : "rgba(220,220,220,1)",
								pointColor : "rgba(220,220,220,1)",
								pointStrokeColor : "#fff",
								pointHighlightFill : "#fff",
								pointHighlightStroke : "rgba(220,220,220,1)",
								data : cap
							}
						]

					};
				var ctx = $('#canvas1').get(0).getContext("2d");
				new Chart(ctx).Line(lineChartData, {
					responsive: true
				});
				
				$('.canvas').children('#canvas1').show();
				$('.canvas').children('#canvas2').hide();
			});
			$('#f').click(function(){
				var result = new Array();
				var cap=new Array();
				$.ajax({
		 			url:"abcAnalysisAction_labelLine.action",
		 			async:false,
		 			type:"post",
		 			dataType:"json",
		 			success:function(data){
		 				$.each(data, function(index,value){
		 					result.push(value.category);
		 					cap.push(value.yearAmountOfCapitalTotalPercent);
		 				});
		 			}
		 		});
				var barChartData = {
						labels : result,
						datasets : [
							{
								fillColor : "rgba(220,220,220,0.5)",
								strokeColor : "rgba(220,220,220,0.8)",
								highlightFill: "rgba(220,220,220,0.75)",
								highlightStroke: "rgba(220,220,220,1)",
								data : cap
							}
						]

					};
				var ctx = $('#canvas2').get(0).getContext("2d");
				new Chart(ctx).Bar(barChartData, {
					responsive : true
				});
				$('.canvas').children('#canvas2').show();
				$('.canvas').children('#canvas1').hide();
			});
		});
</script>
</head>

<body class="container">
	<div class="page-header">
		<h1>
			ABC分析分类<small>ABC Analysis And Classification</small>
		</h1>
	</div>
	<div  class="panel panel-success">
	<div class="panel-heading">ABC分类
		<div class="pull-right">
		<button class="btn btn-success btn-sm" data-toggle="modal" data-target="#myModal">ABC分类图</button>
			<a href="javascript:history.go(-1);" class="btn btn-default btn-sm" role="button">返回</a>
		</div>
	</div>
		<table class="table table-hover table-bordered table-striped table-responsive">
			<thead>
				<tr>
					<th>品目数累计</th>
					<th>物料类别</th>
					<th>品目数累计(%)</th>
					<th>单价</th>
					<th>年库存量</th>
					<th>年资金占用额(元)</th>
					<th>年资金占用额累计(元)</th>
					<th>年资金占用额累计(%)</th>
					<th>分类</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#abcAnalysisList">
					<tr>
						<td>${ id }</td>
						<td>${ category }</td>
						<td>${ itemTotalPercent }%</td>
						<td>${ price }</td>
						<td>${ yearStorage }</td>
						<td>${ yearAmountOfCapital }</td>
						<td>${ yearAmountOfCapitalTotal }</td>
						<td>${ yearAmountOfCapitalTotalPercent }%</td>
						<td>${ classification }</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">ABC分类</h4>
      </div>
      <div class="modal-body">
        <div style="width:100%;height:auto;">
			<div class="canvas">
				<canvas id="canvas1" height="450" width="500"></canvas>
				<canvas id="canvas2" height="450" width="500"></canvas>
			</div>
		</div>
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button id="z" type="button" class="btn btn-default">显示折线图</button>
        <button id="f" type="button" class="btn btn-default">显示直方图</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>

