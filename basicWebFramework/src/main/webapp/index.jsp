<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<a href="<%=basePath %>/helloWorld">SpringMVC 示例1</a>
<a href="<%=basePath %>/ReceiveParam/query">接收参数</a>
<a href="<%=basePath %>/transViews/go">进入系统</a>
<a href="<%=basePath %>/test1/multi?action=add">进入multi</a>
</body>
</html>