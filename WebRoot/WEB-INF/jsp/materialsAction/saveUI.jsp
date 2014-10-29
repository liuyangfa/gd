<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<title>添加新物料</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<style type="text/css">
#form{
	margin-top:20px;
	margin-right:300px;
}
#top{
	border:solid #CCC 1px;
	border-radius:10px;
}
</style>
</head>

<body class="container">
<div class="page-header">
  <h1>物料管理<small>Materials Management</small></h1>
</div>
<div id="top">
  <s:form action="materialsAction_%{id==null?'add':'edit'}" role="form" cssClass="form-horizontal" method="post" id="form">
    <s:hidden name="id"></s:hidden>
    <div class="form-group">
      <label for="categoryId" class="col-md-2 control-label">物料类别</label>
      <div class="col-md-10">
        <s:select cssClass="form-control" id="categoryId" name="categoryId" list="#categoryList" 
	      		listKey="id" listValue="name" headerKey="" headerValue="-------------------------------------请选择所属类别----------------------------------">
	    </s:select>
      </div>
    </div>
    <div class="form-group">
      <label class="col-md-2 control-label" for="name">物料名称</label>
      <div class="col-md-10">
	      <s:textfield cssClass="form-control" name="name" id="name" placeholder="物料名称"></s:textfield>
      </div>
    </div>
    <div class="form-group">
      <label class="col-md-2 control-label" for="specifications">规格</label>
      <div class="col-md-10">
	      <s:textfield cssClass="form-control" name="specifications" id="specifications" placeholder="规格"></s:textfield>
      </div>
    </div>
    <div class="form-group">
      <label class="col-md-2 control-label" for="lowestInventory">最低库存</label>
      <div class="col-md-10">
      	<input type="number" value="${ lowestInventory }" class="form-control" id="lowestInventory" name="lowestInventory" placeholder="最低库存">
<!-- 	      <s:textfield cssClass="form-control" name="lowestInventory" id="lowestInventory" placeholder="最低库存"></s:textfield> -->
      </div>
    </div>
    <div class="form-group">
      <label class="col-md-2 control-label" for="highestInventory">最高库存</label>
      <div class="col-md-10">
      <input type="number" value="${ highestInventory }" class="form-control" id="highestInventory" name="highestInventory" placeholder="最高库存">
<!-- 	      <s:textfield cssClass="form-control" name="highestInventory" id="highestInventory" placeholder="最高库存"></s:textfield> -->
      </div>
    </div>
    <div class="form-group">
      <label class="col-md-2 control-label" for="safeInventory">安全库存</label>
      <div class="col-md-10">
      <input type="number" value="${ safeInventory }" class="form-control" id="safeInventory" name="safeInventory" placeholder="安全库存">
<!-- 	      <s:textfield cssClass="form-control" name="safeInventory" id="safeInventory" placeholder="安全库存"></s:textfield> -->
      </div>
    </div>
    <div class="form-group">
      <label class="col-md-2 control-label" for="noAmountOfTime">无发生额时间(天)</label>
      <div class="col-md-10">
       <input type="number" value="${ noAmountOfTime }" class="form-control" id="noAmountOfTime" name="noAmountOfTime" placeholder="无发生额时间(天)">
<!-- 	      <s:textfield cssClass="form-control" name="noAmountOfTime" id="noAmountOfTime" placeholder="无发生额时间(天)"></s:textfield> -->
      </div>
    </div>
    <div class="form-group">
      <label class="col-md-2 control-label" for="description">说明</label>
      <div class="col-md-10">
        <s:textarea rows="4" cssClass="form-control" name="description" id="description" placeholder="说明"></s:textarea>
      </div>
    </div>
    <div class="form-group">
      <div class="col-md-offset-2 col-md-2"> <button type="submit" class="btn btn-primary">保存</button> </div>
      <div class="col-md-8"><a href="javascript:history.go(-1);" class="btn btn-primary" role="button">返回</a> </div>
    </div>
  </s:form>
</div>
</body>
</html>