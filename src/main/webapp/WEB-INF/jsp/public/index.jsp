<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib tagdir="/WEB-INF/tags/public" prefix="template" %>
<template:public>

	<div class="row">
		<c:forEach items="${menuList}" var="item" >
			<div class="col-md-3">
				<div>
					<h3>${item.name}</h3>
					<img src="${item.url}" class="img-responsive img-rounded" />
					<hr/>
					<h4><span class="label label-success"><fmt:formatNumber type="CURRENCY">${item.total}</fmt:formatNumber></span></h4>
				</div>
			</div>
		</c:forEach>
	</div>	
	
</template:public>