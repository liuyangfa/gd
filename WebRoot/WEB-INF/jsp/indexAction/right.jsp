<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<style type="text/css">
img{
margin-bottom:40px;
padding-right:10px;
}
</style>
</head>

<body>
  <div class="panel panel-default">
  <div class="panel-heading">库存管理流程图</div>
  <div class="panel-body">
    <div class="row">
      <div class="col-md-8">
        <div id="im"> <img name="data" src="${pageContext.request.contextPath}/style/images/index.png" width="771" height="485" alt="" id="data" usemap="#m_data"/> 		</div>
      </div>
      <div class="col-md-4">
        <div class="alert alert-info">
        	<p class="lead">
        	仓存管理系统，是通过入库业务（包括外购入库、产品入库、委外加工入库、其它入库）、出库业务（包括销售出库、生产领料、委外加工出库、其它出库、受托加工领料）、仓存调拨、库存调整（包括盘盈入库、盘亏毁损）、虚仓单据（包括虚仓入库、虚仓出库、虚仓调拨、受托加工产品入库）等功能，结合批次管理、物料对应、库存盘点、质检管理、即时库存管理等功能综合运用的管理系统，对仓存业务的物流和成本管理全过程进行有效控制和跟踪，实现完善的企业仓储信息管理。该系统可以独立执行库存操作；与采购管理系统、销售管理系统、存货核算系统、成本管理系统的单据和凭证等结合使用，将能提供更完整、全面的企业物流业务流程管理和财务管理信息。

        	</p>
		</div>
      </div>
    </div>
  </div>
</div>
<map name="m_data" id="m_data">
  <area target="right" title="出入库流水账" href="${pageContext.request.contextPath}/Action_list.action" shape="rect" coords="2,2,153,55">
  <area target="right" title="系统设置" href="${pageContext.request.contextPath}/Action_list.action" shape="rect" coords="207,0,360,55">
  <area target="right" title="呆滞料分析" href="${pageContext.request.contextPath}/sluggishAction_list.action" shape="rect" coords="406,1,558,56">
  <area target="right" title="物料ABC分类" href="${pageContext.request.contextPath}/baseDataAction_list.action" shape="rect" coords="618,2,768,56">
  <area target="right" title="外购入库单" href="${pageContext.request.contextPath}/purchaseAction_list.action" shape="rect" coords="0,98,152,151" >
  <area target="right" title="库存调拨单" href="${pageContext.request.contextPath}/allocationAction_list.action" shape="rect" coords="308,98,461,152">
  <area target="right" title="生产领料单" href="${pageContext.request.contextPath}/produceAction_list.action" shape="rect" coords="619,98,772,151">
  <area target="right" title="产品入库单" href="${pageContext.request.contextPath}/productAction_list.action" shape="rect" coords="2,221,154,267">
  <area target="right" title="实仓" href="" shape="rect" coords="326,189,446,280">
  <area target="right" title="销售出库单" href="${pageContext.request.contextPath}/salesAction_list.action" shape="rect" coords="619,217,768,271">
  <area target="right" title="其他入库单" href="${pageContext.request.contextPath}/otherInAction_list.action" shape="rect" coords="0,332,153,385">
  <area target="right" title="其他出库单" href="${pageContext.request.contextPath}/otherOutAction_list.action" shape="rect" coords="619,330,769,386">
  <area target="right" title="盘点方案" href="${pageContext.request.contextPath}/physicalAction_addWay.action" shape="rect" coords="1,420,153,475">
  <area target="right" title="盘点单" href="${pageContext.request.contextPath}/physicalAction_list.action" shape="rect" coords="309,428,463,482">
  <area target="right" title="库存调整单" href="${pageContext.request.contextPath}/adjustmentAction_list.action" shape="rect" coords="619,427,770,483">
</map>
</body>
</html>
