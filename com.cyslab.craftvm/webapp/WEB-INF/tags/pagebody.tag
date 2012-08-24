<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="craft"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ tag import="com.cyslab.craftvm.Craft"%>
<%@ tag import="com.cyslab.craftvm.PageBean"%>
<%@ tag import="com.cyslab.craftvm.metadata.Project"%>
<%@ tag import="com.cyslab.craftvm.metadata.Entity"%>
<%@ tag import="com.cyslab.craftvm.metadata.Field"%>
<%@ tag import="org.apache.commons.lang3.StringUtils"%>
<craft:initcheck />
<body data-spy="scroll" data-target=".subnav" data-offset="50">
	<div
		style="margin: 5px; margin-left: 10px; margin-right: 10px; background-color: white; transparency: none">
		<jsp:doBody />
	</div>
</body>
