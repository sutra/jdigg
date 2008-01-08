<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ include file="/taglibs.jsp" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title><fmt:message key="title" /> - <decorator:title default="Welcome!" /></title>
		<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=UTF-8" />
		<meta content="all" name="robots" />
		<link rel="icon" href="${ctx}/favicon.ico" type="image/x-icon" />
		<link rel="shortcut icon" href="${ctx}/favicon.ico" type="image/x-icon" />
		<link href="${ctx}/themes/fresh/style.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}/greybox/gb_styles.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}/themes/jdigg.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<c:url value="/dwr/interface/Digg.js" />"></script>
		<script type="text/javascript" src="<c:url value="/dwr/interface/User.js" />"></script>
		<script type="text/javascript" src="<c:url value="/dwr/engine.js" />"></script>
		<script type="text/javascript" src="<c:url value="/dwr/util.js" />"></script>
		<script type="text/javascript" src="${ctx}/prototype.js"></script>
		<script type="text/javascript" src="${ctx}/jquery-1.2.1.min.js"></script>
		<script type="text/javascript">
		<!--
		jQuery.noConflict();
		//-->
		</script>
		<script type="text/javascript" src="${ctx}/jdigg.js"></script>
		<decorator:head />
	</head>
	<body>
		<div id="wrapper">
			<div id="innerwrapper">
				<div id="header" style="text-align:center;">
					<jsp:include flush="true" page="header.jsp" />
				</div>
				<div id="sidebar">
					<jsp:include flush="true" page="sidebar.jsp" />
				</div>
				<div id="sidebarright">
					<jsp:include flush="true" page="sidebarright.jsp" />
				</div>
				<div id="content">
					<decorator:body />
				</div>
				<div id="footer" style="text-align: center;">
					<jsp:include flush="true" page="footer.jsp" />
				</div>
			</div>
		</div>
	</body>
</html>
