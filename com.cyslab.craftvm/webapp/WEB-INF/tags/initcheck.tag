<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="craft"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ tag import="com.cyslab.craftvm.Craft"%>
<%@ tag import="com.cyslab.craftvm.PageBean"%>
<%@ tag import="com.cyslab.craftvm.metadata.Project"%>
<%@ tag import="com.cyslab.craftvm.metadata.Entity"%>
<%@ tag import="com.cyslab.craftvm.metadata.Field"%>
<%@ tag import="org.apache.commons.lang3.StringUtils"%>
<%
	PageBean pageBean = new Craft().getPageBean(request);
	if (pageBean != null) {
%>
<%-- craft:initcheck success --%>
<%
	} else {
		out.println("Project not initialized properly. Please check your craft file.");
	}
%>