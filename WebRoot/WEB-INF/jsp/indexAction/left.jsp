<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>左侧菜单栏</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/css/leftMenu.css">
<script src="${pageContext.request.contextPath}/script/jquery-1.11.0.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/font-awesome-4.2.0/css/font-awesome.min.css">
<script type="text/javascript">
	function menuClick(menuDiv) {
		$(".menu").not($(menuDiv).next()).hide();
		$(menuDiv).next().slideToggle();
	}
</script>
<style type="text/css">
body{
	overflow-x:hidden;
}
</style>
</head>
<body>
	<div id="menus">
		<ul class="expmenu">
			<!-- 显示一级菜单 -->
			<s:iterator value="#application.topMenuList">
				<s:if test="#session.user.hasPrivilegeByName(name)">
					<li>
						<div class="header" onClick="menuClick(this)">
							<a href="#"><i class="${icon}"></i>&nbsp;${ name }</a>
						</div> <!-- 显示二级菜单 -->
						<ul class="menu">
							<s:iterator value="children">
								<s:if test="#session.user.hasPrivilegeByName(name)">
									<li><a
										href="${pageContext.request.contextPath}/${url}.action"
										target="right">&nbsp;&nbsp; <i class="${icon }"></i>&nbsp;&nbsp;${ name }
									</a></li>
								</s:if>
							</s:iterator>
						</ul>

					</li>
				</s:if>
			</s:iterator>
		</ul>
	</div>
</body>
</html>