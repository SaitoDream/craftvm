<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="craft"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ tag import="com.cyslab.craftvm.Craft"%>
<%@ tag import="com.cyslab.craftvm.PageBean"%>
<%@ tag import="com.cyslab.craftvm.metadata.Project"%>
<%@ tag import="com.cyslab.craftvm.metadata.Entity"%>
<%@ variable name-given="craft"
	variable-class="com.cyslab.craftvm.Craft" scope="NESTED"%>
<%@ variable name-given="pageBean"
	variable-class="com.cyslab.craftvm.PageBean" scope="NESTED"%>
<%@ variable name-given="project"
	variable-class="com.cyslab.craftvm.metadata.Project"
	scope="NESTED"%>
<%@ variable name-given="entity"
	variable-class="com.cyslab.craftvm.metadata.Entity" scope="NESTED"%>
<%@ variable name-given="request"
	variable-class="javax.servlet.http.HttpServletRequest"%>
<craft:initcheck />
<%
	Craft craft2 = new Craft();
	PageBean pageBean = craft2.getPageBean(request);
	if (pageBean != null) {
%>
<c:set var="craft" value="<%=craft2%>" />
<c:set var="pageBean" value="<%=pageBean%>" />
<c:set var="project" value="<%=pageBean.getProject()%>" />
<c:set var="entity" value="<%=pageBean.getEntity()%>" />
<c:set var="request" value="<%=request%>" />
<%
	}
%>
<jsp:doBody />
