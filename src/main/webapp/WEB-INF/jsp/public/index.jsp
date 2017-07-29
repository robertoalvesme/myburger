<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib tagdir="/WEB-INF/tags/public" prefix="template" %>
<template:public>
	
	<h1>Listagem</h1>
	
	<a href="${linkTo[IngredientController].list()}">Administração</a>
	
	
	
	<table class="table table-condensed table-hover">
		<thead>
			<tr>
				<th>Ingrediente</th>
				<th>Valor</th>
				<th>Ação</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ingredientList}" var="ingredient">
			<tr>
				<td>${ingredient.name}</td>
				<td>${ingredient.value}</td>
				<td></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
</template:public>