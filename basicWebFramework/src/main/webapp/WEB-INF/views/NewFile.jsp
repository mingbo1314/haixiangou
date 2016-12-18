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
	$(function() {
		$("#queryBtn").click(function() {
			/* var username = encodeURI($("#username").attr("value"));
			var age = encodeURI($("#age").attr("value")); */
			
			var username = $("#username").val();
			var age = $("#age").val();
			
			var user = {username:username,age:age};
			
			$.ajax({
				url:"<%=basePath %>/ReceiveParam/query4",
				type:"post",
				data:{"username":username,
					  "age":age},
				success:function(data) {
					alert(data.username+"-----"+data.age);
				}
			})
		});
	});
</script>

</head>
<body>
	<form action="" id="form">
		<input id="username" name="username" />
		<input id="age" name="age" />
		<input type="button" id="queryBtn" value="提交"/>
	</form>
</body>
</html>