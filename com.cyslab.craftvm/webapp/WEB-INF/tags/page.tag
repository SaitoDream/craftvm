<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="craft"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ tag import="com.cyslab.craftvm.Craft"%>
<%@ tag import="com.cyslab.craftvm.PageBean"%>
<%@ tag import="com.cyslab.craftvm.metadata.Project"%>
<%@ tag import="com.cyslab.craftvm.metadata.Entity"%>
<%@ tag import="com.cyslab.craftvm.metadata.Field"%>
<%@ tag import="org.apache.commons.lang3.StringUtils"%>
<%--renders page as specified type. For example a list page could be rendered as PDF or XLS. --%>
<%@ attribute name="renderas" required="false"%>
<craft:initcheck />
<%-- craft:initcheck success --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<craft:title />
<craft:loadscripts />
</head>
<jsp:doBody />
</html>
