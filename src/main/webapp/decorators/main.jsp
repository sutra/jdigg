<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>jdigg - <decorator:title default="Welcome!" />
		</title>
		<meta http-equiv="Content-Type"
			content="application/xhtml-xml; charset=UTF-8" />
		<meta content="all" name="robots" />
		<decorator:head />
	</head>
	<body>
		<form action="login.html" method="post">
			<input type="text" name="openid_url" />
			<input type="submit" value="Login" />
		</form>
		<div>
			<decorator:body />
		</div>
	</body>
</html>
