<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>库存管理系统首页</title>
<%@ include  file="/WEB-INF/jsp/public/common.jspf"%>
</head>
<frameset rows="8%,*,3%" framespacing="1" frameborder="yes" border="1" >
  <frame src="${pageContext.request.contextPath}/indexAction_top.action" name="top" scrolling="no">
  <frameset cols="14%,*" border="2">
    <frame src="${pageContext.request.contextPath}/indexAction_left.action" name="left" scrolling="auto" noresize="noresize">
    <frame src="${pageContext.request.contextPath}/indexAction_right.action" name="right" noresize="noresize">
  </frameset>
  <frame src="${pageContext.request.contextPath}/indexAction_bottom.action" name="bottom" scrolling="no" frameborder="1">
</frameset><noframes></noframes>
</html>
