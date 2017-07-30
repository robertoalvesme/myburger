<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib tagdir="/WEB-INF/tags/admin" prefix="template" %>
<template:admin>
	
	<jsp:attribute name="extraStyles">
		<!-- Extra CSS -->
	</jsp:attribute>
	
	<jsp:attribute name="extraScripts">
		<script>
			$page = {
				url : '<c:url value="/" />'
			}
		</script>
		<script src="<c:url value='/js/admin.menu.form.js' />"></script>
		<script id="templateIngredientList" type="x-tmpl-mustache">
			<div class="form-group ingredient" data-menu="{{ ingredient.parent }}" data-ingredient="{{ ingredient.id }}" id="item_{{ index }}">
				<input type="hidden" name="menu.ingredients[{{ index }}].id.ingredient.id" value="{{ ingredient.id }}" />
				<div class="col-sm-7">
					 <p class="form-control-static">{{ ingredient.name }}</p>
				</div>
				<div class="col-sm-2">
					<input type="number" min="1" max="15" class="form-control" required name="menu.ingredients[{{ index }}].quantity" id="menu_ingredients_{{ index }}_quantity" placeholder="<fmt:message key='quantity' />" value="{{ ingredient.quantity }}" required />
				</div>
				<div class="col-sm-3">
					<div class="btn-group">
						<a class="btn btn-default" href="javascript:void(0);" onclick="changeQuantity('item_{{index}}');" role="button"><span class="glyphicon glyphicon-refresh"></span></a>
						<a class="btn btn-default" href="javascript:void(0);" onclick="remove('item_{{index}}');" role="button"><span class="glyphicon glyphicon-remove"></span></a>
					</div>
				</div>
			</div>	
		</script>
	</jsp:attribute>
	
	<jsp:body>
		<div class="modal fade" id="modaIngredients" tabindex="-1" role="dialog">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title"><fmt:message key='add.new.item' /></h4>
					</div>
					<div class="modal-body">
						<form name="formTodo" id="formTodo" class="form-horizontal" method="POST">
							<div class="form-group">
								<label for="recipient-name" class="col-sm-2 control-label"><fmt:message key='ingredient' /></label>
								<div class="col-sm-6">
									<select class="form-control" name="newIngredient" id="newIngredient">
									</select>
								</div>
								<div class="col-sm-2">
									<input class="form-control" type="number" name="newIngredientQuantity" id="newIngredientQuantity" value="1" />
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key='close' /></button>
						<button type="button" class="btn btn-primary" onClick="saveItem();" ><fmt:message key='add' /></button>
					</div>
				</div>
			</div>
		</div>
		
		<ol class="breadcrumb">
			<li><a href="${linkTo[AdministrationController].dashboard()}">Home</a></li>
			<li><a href="${linkTo[MenuController].list()}"><fmt:message key='menus'/></a></li>
			<li class="active"><fmt:message key='form'/></li>
		</ol>
		
		<div class="row">
			<div class="col-xs-6">
				<div>
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab"><fmt:message key='menu' /></a></li>
						<li role="presentation"><a href="#ingredients" aria-controls="ingredients" role="tab" data-toggle="tab"><fmt:message key='ingredients' /></a></li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="home">
							<form name="formMenu" id="formMenu" action="${linkTo[MenuController].insert()}" method="post" class="form-horizontal" role="form">
								<input type="hidden" name="menu.id" id="menu_id" value="${menu.id}" />
								<c:if test="${menu.id gt 0 }">
									<input type="hidden" name="_method" value="PUT" />
								</c:if>
								<div class="form-group">
									<label for="menu_name" class="col-sm-2 control-label"><fmt:message key='name' /></label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="menu_name" name="menu.name" placeholder="<fmt:message key='name' />" value="${menu.name}" required />
									</div>
								</div>
								<div class="form-group">
									<label for="menu_url" class="col-sm-2 control-label"><fmt:message key='image' /></label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="menu_url" name="menu.url" placeholder="<fmt:message key='url' />" value="${menu.url}" required />
									</div>
								</div>
								<!-- TODO : Fazer calculo para Subtotal -->
								<%--
								<div class="form-group">
									<label for="menu_subtotal" class="col-sm-2 control-label"><fmt:message key='subtotal' /></label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="menu_subtotal" name="menu.subtotal" placeholder="<fmt:message key='subtotal' />" value="<fmt:formatNumber minFractionDigits="2">${menu.subtotal}</fmt:formatNumber>" readonly />
									</div>
								</div>
								 --%>
								<div class="form-group">
									<label for="menu_value" class="col-sm-2 control-label"><fmt:message key='total' /></label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="menu_value" name="menu.total" placeholder="<fmt:message key='total' />" value="<fmt:formatNumber minFractionDigits="2">${menu.total}</fmt:formatNumber>" required />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-offset-2 col-sm-10">
										<input type="submit" class="btn btn-default" value="<fmt:message key='save' />"/>
									</div>
								</div>
							</form>
						</div>
						<div role="tabpanel" class="tab-pane" id="ingredients">
							<div class="row">
								<div class="col-xs-offset-8 col-xs-2">
									<a class="btn btn-default" href="#" onclick="add();" role="button"><fmt:message key='add.new.item' /></a>
								</div>
							</div>
							<hr />
							<div id="menuIngredients">
								<c:forEach items="${menu.ingredients}" var="menuIngredient" varStatus="x">
									<div class="form-group ingredient" data-menu="${menu.id}" data-ingredient="${menuIngredient.id.ingredient.id}" id="item_${x.index}">
										<div class="col-sm-7">
											 <p class="form-control-static">${menuIngredient.id.ingredient.name}</p>
										</div>
										<div class="col-sm-2">
											<input type="number" min="1" max="15" class="form-control" onchange="changeQuantity('item_${x.index}');" name="menu.ingredients[${x.index}].quantity" id="menu_ingredients_${x.index}_quantity" placeholder="<fmt:message key='quantity' />" value="${menuIngredient.quantity}" required />
										</div>
										<div class="col-sm-3">
											<div class="btn-group">
												<a class="btn btn-default" href="javascript:void(0);" onclick="changeQuantity('item_${x.index}');" role="button"><span class="glyphicon glyphicon-refresh"></span></a>
												<a class="btn btn-default" href="javascript:void(0);" onclick="remove('item_${x.index}');" role="button"><span class="glyphicon glyphicon-remove"></span></a>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	
	</jsp:body>
</template:admin>
