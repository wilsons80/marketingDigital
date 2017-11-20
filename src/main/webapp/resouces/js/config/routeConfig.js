angular.module("mDigital").config( function($routeProvider, $locationProvider){
	//Usado para que a URL não fique com caracteres estranhos
	$locationProvider.hashPrefix('');

	
	$routeProvider.when("/error", {
		templateUrl : "view/error.html"
	});
	
	
	// caso não seja nenhum desses, redirecione para a rota '/'
	$routeProvider.otherwise({
		redirectTo : '/'
	});
	
});