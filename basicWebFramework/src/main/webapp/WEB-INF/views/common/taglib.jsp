<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url var="resourceUrl" value="/static"/><%-- 
<spring:url var="ctxPath" value="/"/> --%>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" scope="session"/>