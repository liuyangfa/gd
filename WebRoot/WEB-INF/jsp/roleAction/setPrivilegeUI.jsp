<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<title>岗位权限列表</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery_treeview/jquery.treeview.css">
<script src="${pageContext.request.contextPath}/jquery_treeview/jquery.treeview.js"></script>
<script type="text/javascript">
	$("#tree").treeview(); 
	
	function selectAll(a) {
		$('[name=privilegeIds]').each(function(){
			this.checked = a.checked;
		});
	}
		 $(function(){
			// 给所有的权限复选框加上click事件
			$("[name=privilegeIds]").click(function () {
            var me = this;
            // 当选中或者取消一个权限时，也同时选中或者取消所有的下级权限
            $(this).siblings("ul").find("input").each(function () {
                this.checked = me.checked;
            });

            // 当选中一个权限时，也要选中所有的上级权限
            if (me.checked == true) {
                $(this).parents("li").children("input").each(function () {
                    this.checked = me.checked;
                });
            }
        });

			//
		});
</script>

<style>
#rolePrivilege{
	border:solid 1px;
	border-color:#CCC;
}
#content{
	margin-top:10px;
	margin-left:100px;
}
#button{
	margin-top:10px;
	margin-right:300px;
	margin-bottom:200px;
}
</style>
</head>

<body class="container">
<div class="page-header">
  <h1>配置权限<small>Privilege Management</small></h1>
</div>

<s:form role="form" action="roleAction_setPrivilege" method="post">
	<s:hidden name="id"></s:hidden>
<div id="rolePrivilege">
	正在为【${ name }】分配权限
	<div id="content">
	    <input type="checkbox" id="cbSelectAll" onclick="selectAll(this);"/>
		<label for="cbSelectAll">全选</label>

		<ul id="tree">
			<s:iterator value="#topPrivilegeList">
			<li>
				<input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}"
				<s:property value="%{id in privilegeIds ? 'checked' : ''}" /> />
				<label for="cb_${id}"><i class="fa fa-folder-open">${name}</i></label>
				<ul>
					<s:iterator value="children">
					<li>
						<input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}"
						<s:property value="%{id in privilegeIds ? 'checked' : ''}" /> />
						<label for="cb_${id}"><i class="fa fa-folder-open-o">${name}</i></label>
							<ul>
								<s:iterator value="children">
									<li>
										<input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}"
										<s:property value="%{id in privilegeIds ? 'checked' : ''}" /> />
										<label for="cb_${id}"><i class="fa fa-folder">${name}</i></label>
									</li>
								</s:iterator>
							</ul>
					</li>
					</s:iterator>
				</ul>
			</li>
			</s:iterator>
		</ul>
    </div>
    </div>
    <!-- 表单操作 -->
    <div class="form-group" id="button">
        <div class="col-md-offset-2 col-md-2">
          <button type="submit" class="btn btn-primary">保存</button>
        </div>
        <div class="col-md-8">
         <a href="javascript:history.go(-1);" class="btn btn-primary" role="button">返回</a>
        </div>
	</div>
	<script type="text/javascript">
		$("#tree").treeview();
	</script>
</s:form>

</body>
</html>
