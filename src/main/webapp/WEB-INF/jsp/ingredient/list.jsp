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
				<li class="active"><fmt:message key='ingredients'/></li>
			</ol>
		</div>
		<div class="col-md-2 pull-right">
			<div class="dropdown">
				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
					<fmt:message key='add.new.item'/> <span class="glyphicon glyphicon-plus"></span>
				</button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
					<li><a href="${linkTo[IngredientController].form('meat')}" role="button" data-toggle="tooltip" data-placement="bottom" title="<fmt:message key='tooltip.meat' />"><fmt:message key='meats' /></a></li>
					<li><a href="${linkTo[IngredientController].form('common')}" role="button" data-toggle="tooltip" data-placement="bottom" title="<fmt:message key='tooltip.common' />"><fmt:message key='commons' /></a></li>
					<li><a href="${linkTo[IngredientController].form('bread')}" role="button" data-toggle="tooltip" data-placement="bottom" title="<fmt:message key='tooltip.bread' />"><fmt:message key='breads' /></a></li>
					<li><a href="${linkTo[IngredientController].form('cheese')}" role="button" data-toggle="tooltip" data-placement="bottom" title="<fmt:message key='tooltip.cheese' />"><fmt:message key='cheeses' /></a></li>
					<li><a href="${linkTo[IngredientController].form('salad')}" role="button" data-toggle="tooltip" data-placement="bottom" title="<fmt:message key='tooltip.salad' />"><fmt:message key='salads' /></a></li>
					<li><a href="${linkTo[IngredientController].form('sauce')}" role="button" data-toggle="tooltip" data-placement="bottom" title="<fmt:message key='tooltip.sauce' />"><fmt:message key='sauces' /></a></li>
					<li><a href="${linkTo[IngredientController].form('special')}" role="button" data-toggle="tooltip" data-placement="bottom" title="<fmt:message key='tooltip.special' />"><fmt:message key='specials' /></a></li>
				</ul>
			</div>
		</div>
	</div>
		
	
	<div>
	
		<table class="table table-condensed table-hover">
			<thead>
				<tr>
					<th><fmt:message key='name' /></th>
					<th></th>
					<th><fmt:message key='value' /></th>
					<th><fmt:message key='actions' /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ingredientList}" var="ingredient">
				<tr>
					<td>${ingredient.name}</td>
					<td><span class="label label-default"><fmt:message key='${ingredient.type.description}' /></span></td>
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