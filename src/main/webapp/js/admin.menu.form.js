$dom = {
		menuIngredients : $('#menuIngredients')
		, deleting : false
		, updating : false
}

add = function(){
	
}

remove = function(target){
	
	if( $dom.deleting ){
		return;
	}
	
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
			console.log('Erro');
			console.log(error);
		},
		always: function(){
			$dom.deleting = false;
		}
	});
}

changeQuantity = function( object ){
	if( object.value <= 0 ){
		console.log( object.parentElement.parentElement.getAttribute('id') );
	}
}
