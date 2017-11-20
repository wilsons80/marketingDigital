angular.module("mDigital").directive("uiAlert", function(){
	return {
		templateUrl : "view/alertView.html",
		replace : true,
		restrict : "AE",
		scope : {
			titleMessage : "@title",
			error : "=message"
		}
	};
});

/*
 * Tipos de restrição
 * 
 *   A - Diretiva restrica ao atributo do elemento
 *   E - Diretiva restrica ao elemento
 *   C - Diretiva restrica a classe do elemento
 *   M - Diretiva restrica ao comentário do elemento  
 */