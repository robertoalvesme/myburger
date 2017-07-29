<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib tagdir="/WEB-INF/tags/admin" prefix="template" %>
<template:admin>
	
	<h1>Formulario</h1>
	
	<form name="formIngredient" id="formIngredient" action="${linkTo[IngredientController].insert()}" method="post" class="form-horizontal" role="form">
		<input type="hidden" name="ingredient.id" value="${ingredient.id}" />
		<input type="hidden" name="ingredient.type" value="${type}" />
		<c:if test="${ingredient.id gt 0 }">
			<input type="hidden" name="_method" value="PUT" />
		</c:if>	
		<div class="form-group">
			<label for="ingredient_name" class="col-sm-2 control-label"><fmt:message key='name' /></label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="ingredient_name" name="ingredient.name" placeholder="<fmt:message key='name' />" value="${ingredient.name}" />
			</div>
		</div>
		<div class="form-group">
			<label for="ingredient_value" class="col-sm-2 control-label"><fmt:message key='value' /></label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="ingredient_value" name="ingredient.value" placeholder="<fmt:message key='value' />" value="${ingredient.value}"/>
			</div>
		</div>
		
		
		
		<div class="form-group">
			<div class="col-md-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value="<fmt:message key='submit' />"/>
			</div>
		</div>
	</form>
	
</template:admin>