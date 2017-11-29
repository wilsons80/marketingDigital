angular.module("mDigital").config( function( $routeProvider, $locationProvider ){
	
	//Usado para que a URL não fique com caracteres estranhos
	$locationProvider.hashPrefix('');

	// Se vier da página principal da aplicação '/contatos'.
	$routeProvider.when('/login', {
		templateUrl : 'view/login.html',
		controller : 'loginController',
		controllerAs: 'vm'
	});
	
	
	$routeProvider.when('/formCliente', {
		templateUrl : 'view/cliente/formCliente.html',
		controller : 'appControler',
		controllerAs: 'vm'
	});	
	
	$routeProvider.when('/cliente/:id', {
		templateUrl : 'view/cliente/formCliente.html',
		controller : 'formClienteController',
		controllerAs: 'vm'
	});
	
	$routeProvider.when('/cliente', {
		templateUrl : 'view/cliente/formCliente.html',
		controller : 'listarClienteController',
		controllerAs: 'vm'
	});	

	$routeProvider.when('/formMalaDireta', {
		templateUrl : 'view/maladireta/formMalaDireta.html',
		controller : 'appControler',
		controllerAs: 'vm'
	});	

	$routeProvider.when('/malaDireta/:id', {
		templateUrl : 'view/maladireta/formMalaDireta.html',
		controller : 'listaMalaDiretaController',
		controllerAs: 'vm'
	});	
	
	$routeProvider.when('/malaDireta', {
		templateUrl : 'view/maladireta/formMalaDireta.html',
		controller : 'formMalaDiretaController',
		controllerAs: 'vm'
	});	
	
	
	// caso não seja nenhum desses, redirecione para a rota '/'
	$routeProvider.otherwise({
		redirectTo : '/login'
	});
	
});