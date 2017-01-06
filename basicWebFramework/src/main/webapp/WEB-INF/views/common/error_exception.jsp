<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>系统异常</title>
</head>
<body>
  <div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
      <div class="error-page">
        <h2 class="headline text-red">500</h2>
        <div class="error-content">
          <h3><i class="fa fa-warning text-red"></i> Oops! Something went wrong.</h3>
          <p>
            <h3>系统运行异常,请与管理员联系。</h3>
            <p class="kongbai"></p>
            <strong>${empty exception.message ? exception : exception.message}</strong>
            <div style="display: none;">详细错误：<br/>
              <c:forEach var="trace" items="${exception.stackTrace}"><c:out value="${trace}"></c:out> <br/></c:forEach>
            </div>
            <p>您现在可以返回：<span><a href="javascript:history.go(-1);">上一页</a></span></p>
          </div>
      </div>
      <!-- /.error-page -->
    </section>
    <!-- /.content -->
  </div>
</body>
</html>
