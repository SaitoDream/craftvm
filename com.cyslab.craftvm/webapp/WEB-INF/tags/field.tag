<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="craft"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ tag import="com.cyslab.craftvm.*"%>
<%@ tag import="com.cyslab.craftvm.metadata.*"%>
<%@ tag import="org.apache.commons.lang3.*"%>
<%@ tag import="java.util.*"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="edit" required="false"%>
<%@ attribute name="entity" required="false"%>
<%@ attribute name="project" required="false"%>
<%@ attribute name="displayName" required="false"%>
<%@ attribute name="styleclass" required="false"%>
<%@ attribute name="id" required="false"%>
<craft:initcheck />
<%
	Craft craft = new Craft();
	PageBean pageBean = craft.getPageBean(request);
	Project project = pageBean.getProject();
	Entity entity = pageBean.getEntity();
	Field field = entity.getFieldByName(name);
	if (!craft.isManyToManyOrOneToMany(field)) {
		String varStyleClass = StringUtils.isNotEmpty(styleclass) ? styleclass
				: "input-xlarge";
		String varId = StringUtils.isNotEmpty(id) ? id : field
				.getFullyQualifiedName();
		String varDisplayName = StringUtils.isNotEmpty(displayName) ? displayName
				: field.getDisplayName();
		String varName = field.getFullyQualifiedName();
		String varType = craft.getHtmlInputType(field);
		String varValue = "";
		if ("true".equalsIgnoreCase(edit)) {
%>
<div class="control-group">
	<label for="<%=varId%>"><%=varDisplayName%>:</label> <input
		type="<%=varType%>" class="<%=varStyleClass%>" id="<%=varId%>"
		name="<%=varName%>" value="<%=varValue%>" />
</div>
<%
	} else {
%>
<div class="control-group">
	<label for="<%=varId%>"><%=varDisplayName%>:</label>
	<div style="font-face: bold;"><%=varValue%></div>
</div>
<%
	}
	}
%>
