<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="q" uri="/ajaxquery-tags" %> --%>
<%@ taglib uri="/option" prefix="op"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 -----------------Hello World! ----------------------<br>
 ${map }
 </br>
 <c:forEach items="${map }" var="m">
 	${m.key }------>${m.value } 
 </c:forEach>
 <%-- <option:grid gridId="test标签测试"/> --%>
 <op:grid gridId="hello tag 标签" name="自定义属性" title="自定义标题"><div class="receipt_result btncenter">无符合条件的记录</div></op:grid>
 
 <op:table>
 	hello
 </op:table>
</body>
</body>
</html>