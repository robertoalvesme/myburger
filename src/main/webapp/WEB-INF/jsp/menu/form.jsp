<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib tagdir="/WEB-INF/tags/admin" prefix="template" %>
<template:admin>

	<ol class="breadcrumb">
		<li><a href="${linkTo[AdministrationController].dashboard()}">Home</a></li>
		<li><a href="${linkTo[MenuController].list()}"><fmt:message key='menus'/></a></li>
		<li class="active"><fmt:message key='form'/></li>
	</ol>
	
	<div class="row">
		<div class="col-xs-6">
			<h2><fmt:message key='menu'/></h2>
			<form name="formMenu" id="formMenu" action="${linkTo[MenuController].insert()}" method="post" class="form-horizontal" role="form">
				<input type="hidden" name="menu.id" value="${menu.id}" />
				<c:if test="${menu.id gt 0 }">
					<input type="hidden" name="_method" value="PUT" />
				</c:if>
				<div class="form-group">
					<label for="menu_name" class="col-sm-2 control-label"><fmt:message key='name' /></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="menu_name" name="menu.name" placeholder="<fmt:message key='name' />" value="${menu.name}" required />
					</div>
				</div>
				<%--
				<div class="form-group">
					<label for="menu_value" class="col-sm-2 control-label"><fmt:message key='value' /></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="menu_value" name="menu.value" placeholder="<fmt:message key='value' />" value="<fmt:formatNumber minFractionDigits="2">${menu.value}</fmt:formatNumber>" required />
					</div>
				</div>
				 --%>
				<div class="form-group">
					<div class="col-md-offset-2 col-sm-10">
						<input type="submit" class="btn btn-default" value="<fmt:message key='save' />"/>
					</div>
				</div>
			</form>
		</div>
	</div>	
	
	
	
</template:admin>