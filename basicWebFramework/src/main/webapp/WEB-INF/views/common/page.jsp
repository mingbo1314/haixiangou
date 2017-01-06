<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="row">
	<div class="col-sm-12" >
		<div class="dataTables_paginate paging_bootstrap">
	<div class="col-sm-8" align="right">
			<ul class="pagination">

				<li class="prev ${page.isFirstPage=='true'?'disabled':'' }"><a
					href="${ctxPath}/${url}?currentPage=${page.firstPage}"
					onClick="aa(this);"> <i class="fa fa-angle-double-left"></i>
				</a></li>

				<c:forEach begin="${page.firstPage}" end="${page.lastPage}"
					varStatus="status">
					<li class="${status.index==page.pageNum?'active':'' }"><c:choose>
							<c:when test="${status.index==page.pageNum}">
								<a href="#">${status.index}</a>
							</c:when>
							<c:otherwise>
								<a href="${ctxPath}/${url}?currentPage=${status.index}"
									onClick="aa(this);">${status.index}</a>
							</c:otherwise>
						</c:choose></li>
				</c:forEach>

				<li class="next ${page.isLastPage=='true'?'disabled':'' }"><a
					href="${ctxPath}/${url}?currentPage=${page.lastPage}"
					onClick="aa(this);"> <i class="fa fa-angle-double-right"></i>
				</a></li>
			</ul>
		</div>
		<div class="col-sm-4 pagination" >
		跳转到第<input type="text" name="currentPage" size="3" />页
		<a href="${ctxPath}/${url}?" onClick="submit(this)">
		<input type="button" value="确定" /></a>，共<span>${page.pages}</span>页，共计<span>${page.total}</span>条记录
	
</div>
		</div>
		
	</div>
</div>

<script>
	function aa(_this) {
		var url = _this.href;
		url = url + "&" + $("#form").serialize();
		_this.href = url;
	}
	function submit(_this) {
		var url = _this.href;
		url = url + "currentPage=" + $("input[name='currentPage']").val() +  "&" + $("#form").serialize();
		_this.href = url;
	}
</script>
