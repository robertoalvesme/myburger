<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib tagdir="/WEB-INF/tags/public" prefix="template" %>
<template:public>

	<h3><fmt:message key='choose.yours' /></h3>
	
	<form name="formTodo" id="formTodo" class="form-horizontal" method="POST">
		<c:forEach items="${ingredientList}" var="ingredient" varStatus="x">
			<div class="form-group ingredient">
				<div class="col-sm-8">
					 <p class="form-control-static">${ingredient.name}</p>
				</div>
				<div class="col-sm-4">
					<input type="hidden" id="customMenuForm_${x.index}_ingredient.id" name="customMenuForm[${x.index}].ingredient.id" value="${ingredient.id}" />
					<input type="number" id="customMenuForm_${x.index}_quantity" name="customMenuForm[${x.index}].quantity"  min="0" max="15" class="form-control"  placeholder="<fmt:message key='quantity' />" value="${menuIngredient.quantity}" required />
				</div>
			</div>
		</c:forEach>
		<div class="form-group">
			<div class="col-md-offset-11 col-sm-1">
				<input type="submit" class="btn btn-default" value="<fmt:message key='save' />"/>
			</div>
		</div>
	</form>
	
	<c:if test="${customMenu!=null}">
		<h2><fmt:message key='your.order' /></h2>
		
		<h4><fmt:message key='items' /></h4>
		
		<c:choose>
			<c:when test="${fn:length(customMenu.ingredients) eq 0}">
				<fmt:message key='no.items.found' /><
			</c:when>
			<c:otherwise>
			
				<table class="table">
					<tbody>
						<c:forEach items="${customMenu.ingredients}" var="item">
							<tr>
								<td>${item.value}</td>
								<td>${item.key.name}</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<th><fmt:message key='subtotal' /></th><th><fmt:formatNumber type="CURRENCY">${customMenu.subTotal}</fmt:formatNumber></th>
						</tr>
						<tr>
							<th><fmt:message key='discounts' /></th><th><fmt:formatNumber type="CURRENCY">${customMenu.discounts}</fmt:formatNumber></th>
						</tr>
						<tr>
							<th><fmt:message key='total' /></th><th><fmt:formatNumber type="CURRENCY">${customMenu.total}</fmt:formatNumber></th>
						</tr>
					</tfoot>
				</table>
				
			</c:otherwise>
		</c:choose>
	</c:if>
</template:public>