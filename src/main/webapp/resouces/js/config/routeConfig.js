angular.module("mDigital").config( function($routeProvider, $locationProvider ){
	
	//Usado para que a URL não fique com caracteres estranhos
	$locationProvider.hashPrefix('');

	// Se vier da página principal da aplicação '/contatos'.
	$routeProvider.when('/login', {
		templateUrl : 'view/login.html',
		controller : 'loginController',
		controllerAs: 'vm'
	});
	
	
	$routeProvider.when('/index', {
		templateUrl : 'view/index.html',
		controller : 'appControler'
	});	
	
	$routeProvider.when('/listarCliente', {
		redirectTo : '/index'
	});	
	
	$routeProvider.when('/cliente/:id', {
		templateUrl : 'view/index.html',
		controller : 'formClienteController'
	});	

	$routeProvider.when('/cadastroMalaDireta', {
		templateUrl : 'view/index.html',
		controller : 'malaDiretaController',
			
		resolve : {
			malaDiretas: function (malaDigitalAPI) {
				return malaDigitalAPI.getMalaDiretas();
			}
		}
	});	
	
	
	// caso não seja nenhum desses, redirecione para a rota '/'
	$routeProvider.otherwise({
		redirectTo : '/login'
	});
	
});