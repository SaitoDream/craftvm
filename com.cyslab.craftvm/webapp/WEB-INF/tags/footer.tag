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
<craft:craft>
	<footer class="footer">
		<div class="pull-left">&copy; 2012 ${project.name}. All rights
			reserved.</div>
		<div class="pull-right">
			<a href="#">Back to top</a>
		</div>
	</footer>
</craft:craft>