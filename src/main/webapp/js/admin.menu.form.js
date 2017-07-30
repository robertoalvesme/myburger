$dom = {
		menuIngredients : $('#menuIngredients')
		, deleting : false
		, updating : false
}

//add = function(){
//	
//}

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

