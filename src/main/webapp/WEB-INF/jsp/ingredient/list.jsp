<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib tagdir="/WEB-INF/tags/admin" prefix="template" %>
<template:admin>
	
	<h1>Listagem</h1>
	
	
	<h2><fmt:message key='add.new.item' /></h2>
	<div class="btn-group" role="group">
		<a class="btn btn-default" href="${linkTo[IngredientController].form('meat')}" role="button"><fmt:message key='meats' /></a>
		<a class="btn btn-default" href="${linkTo[IngredientController].form('common')}" role="button"><fmt:message key='commons' /></a>
		<a class="btn btn-default" href="${linkTo[IngredientController].form('bread')}" role="button"><fmt:message key='breads' /></a>
		<a class="btn btn-default" href="${linkTo[IngredientController].form('cheese')}" role="button"><fmt:message key='cheeses' /></a>
		<a class="btn btn-default" href="${linkTo[IngredientController].form('salad')}" role="button"><fmt:message key='salads' /></a>
		<a class="btn btn-default" href="${linkTo[IngredientController].form('sauce')}" role="button"><fmt:message key='sauces' /></a>
		<a class="btn btn-default" href="${linkTo[IngredientController].form('special')}" role="button"><fmt:message key='specials' /></a>
	</div>
	
	<div>
	
		<table class="table table-condensed table-hover">
			<thead>
				<tr>
					<th>Ingrediente</th>
					<th></th>
					<th>Valor</th>
					<th>Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ingredientList}" var="ingredient">
				<tr>
					<td>${ingredient.name}</td>
					<td><span class="label label-default"><fmt:message key='${ingredient.type}' /></span></td>
					<td><fmt:formatNumber type="CURRENCY">${ingredient.value}</fmt:formatNumber></td>
					<td>
						<a class="btn btn-default" href="${linkTo[IngredientController].form(ingredient)}" role="button"><fmt:message key='edit' /></a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
	
	</div>
	
</template:admin>