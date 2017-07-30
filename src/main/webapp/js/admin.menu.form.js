$dom = {
		menuIngredients : $('#menuIngredients')
		, modaIngredients : $('#modaIngredients')
		, menuId : $('#menu_id').val()
		, deleting : false
		, updating : false
}

changeQuantity = function(target){
	
	console.log("Alterar")
	
//	if( $dom.updating ){
//		return;
//	}
	var target = $('#' + target);
	var menuId = target.attr('data-menu');
	var ingredientId = target.attr('data-ingredient');
	var quantity = target.find('input').val();
	$.ajax({
		type: "PUT",
		url: $page.url + 'json/menu/'+ menuId + '/ingredient/' + ingredientId + '/' +  quantity ,
		dataType : 'json',
		contentType: "application/json",
		success : function(){
			// Não fazer nada
		}, 
		error : function(error){
			console.log('Erro');  // TODO : Melhorar mensagem de erro
			console.log(error);
		},
		always: function(){
			$dom.updating = false;
		}
	});
}

remove = function(target){
//	if( $dom.deleting ){
//		return;
//	}
	$dom.deleting = true;
	var target = $('#' + target);
	var menuId = target.attr('data-menu');
	var ingredientId = target.attr('data-ingredient');
	$.ajax({
		type: "DELETE",
		url: $page.url + 'json/menu/'+ menuId + '/ingredient/' + ingredientId ,
		dataType : 'json',
		contentType: "application/json",
		success : function(){
			target.slideUp(function(){
				$(this).remove();
			})
		}, 
		error : function(error){
			console.log('Erro'); // TODO : Melhorar mensagem de erro
			console.log(error);
		},
		always: function(){
			$dom.deleting = false;
		}
	});
}

add = function(){
	var newIngredient = $('#newIngredient');
	var menuId = $('#menu_id').val();
	newIngredient.children().remove()
	$('#newIngredientQuantity').val(1);
	$.get($page.url + 'json/menu/'+ $dom.menuId +'/ingredients',function(data){
		for(i in data){
			newIngredient.append($('<option>', { 
				value: data[i].id,
				text : data[i].name
			}));
		}
		$dom.modaIngredients.modal('show');
	})
}

saveItem = function(){
	var menuId = $dom.menuId;
	var ingredientField = $('#newIngredient');
	var ingredientId = ingredientField.val();
	var quantity = $('#newIngredientQuantity').val();
	
	Mustache.parse($dom.templateIngredientList);
	
	var item = {
		ingredient : {
			name : ingredientField.find('option:selected').text(),
			quantity : quantity,
			id : ingredientId,
			parent : menuId
		},
		index : $dom.menuIngredients.find('.ingredient').length
	};
	
	$.ajax({
		type: "POST",
		url: $page.url + 'json/menu/'+ menuId + '/ingredient/' + ingredientId + '/' +  quantity ,
		dataType : 'json',
		contentType: "application/json",
		success : function(data){
			$dom.menuIngredients.append( Mustache.render( $('#templateIngredientList').html() , item ) );
			$dom.modaIngredients.modal('hide');
		}, 
		error : function(error){
			console.log('Erro'); // TODO : Melhorar mensagem de erro
			console.log(error);
		},
		always: function(){
			$dom.modaIngredients.modal('hide');
		}
	});
}

