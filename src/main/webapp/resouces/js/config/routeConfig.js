angular.module("mDigital").config( function($routeProvider, $locationProvider ){
	
	//Usado para que a URL não fique com caracteres estranhos
	$locationProvider.hashPrefix('');

	// Se vier da página principal da aplicação '/contatos'.
	$routeProvider.when('/login', {
		templateUrl : 'view/login.html',
		controller : 'loginController'
	});
	
	
	$routeProvider.when('/view/index', {
		templateUrl : 'view/index.html',
		controller : 'appControler',
			
		resolve : {
			clientes: function (clienteAPI) {
				return clienteAPI.getClientes();
			},
			malaDiretas: function (malaDigitalAPI) {
				return malaDigitalAPI.getMalaDiretas();
			}
		}
	});

	$routeProvider.when('/view/cadastroCliente', {
		templateUrl : 'view/cadastroClientes.html',
		controller : 'clienteController',
			
		resolve : {
			clientes: function (clienteAPI) {
				return clienteAPI.getClientes();
			}
		}
	});

	$routeProvider.when('/view/cadastroMalaDireta', {
		templateUrl : 'view/cadastroMalaDireta.html',
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
	
	/*
	// Se vier da página principal da aplicação '/contatos'.
	$routeProvider.when('/', {
		templateUrl : 'index.html',
		controller : 'appController',
			
		resolve : {
			clientes: function (clienteAPI) {
				return clienteAPI.getClientes();
			},
			malaDiretas: function (malaDigitalAPI) {
				return malaDigitalAPI.getMalaDiretas();
			}
		}
	});

	
	$routeProvider.when('/malaDireta', {
		templateUrl : 'listagemMalaDireta.html',
		controller : 'malaDiretaController',
			
		resolve : {
			malaDiretas: function (malaDigitalAPI) {
				return malaDigitalAPI.getMalaDiretas();
			}
		}
	});
	
	$routeProvider.when('/cliente', {
		templateUrl : 'listagemMalaDireta.html',
		controller : 'malaDiretaController',
			
		resolve : {
			clientes: function (clienteAPI) {
				return clienteAPI.getClientes();
			}
		}
	});
	
	$routeProvider.when('/login', {
		templateUrl : 'view/login.html',
		controller : 'loginController'
	});
	
	
	$routeProvider.when("/error", {
		templateUrl : "view/error.html"
	});
	*/
	
	// caso não seja nenhum desses, redirecione para a rota '/'
	/*
	$routeProvider.otherwise({
		redirectTo : '/'
	});
	*/
	
	
});