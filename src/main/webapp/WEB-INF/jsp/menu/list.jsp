<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib tagdir="/WEB-INF/tags/admin" prefix="template" %>
<template:admin>

	<div class="row">
		<div class="col-md-10">
			<ol class="breadcrumb">
				<li><a href="${linkTo[AdministrationController].dashboard()}">Home</a></li>
				<li class="active"><fmt:message key='menus'/></li>
			</ol>
		</div>
		<div class="col-md-2 pull-right">
			<a href="${linkTo[MenuController]}" class="btn btn-default"><fmt:message key='add.new.item'/> <span class="glyphicon glyphicon-plus"></span></a>
		</div>
	</div>
		
	
	<div>
	
		<table class="table table-condensed table-hover">
			<thead>
				<tr>
					<th><fmt:message key='name' /></th>
					<th><fmt:message key='value' /></th>
					<th><fmt:message key='actions' /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${menuList}" var="menu">
				<tr>
					<td>${menu.name}</td>
					<td><span class="label label-default"><fmt:message key='${menu.type.description}' /></span></td>
					<td>
						<a class="btn btn-default" href="${linkTo[MenuController].form(menu)}" role="button"><fmt:message key='edit' /></a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</div>
	
</template:admin>