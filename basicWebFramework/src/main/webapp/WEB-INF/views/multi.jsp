<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=basePath%>/public/js/jquery-1.8.3.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		alert(5);
	});
	/* window.onload = function() { 
		alert(5);
	}; */
</script>
</head>
<body>
多个方法请求
${method }

</body>
</html>