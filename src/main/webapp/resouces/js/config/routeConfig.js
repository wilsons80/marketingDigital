angular.module("mDigital").config( function($routeProvider, $locationProvider ){
	
	//Usado para que a URL não fique com caracteres estranhos
	$locationProvider.hashPrefix('');

	// Se vier da página principal da aplicação '/contatos'.
	$routeProvider.when('/login', {
		templateUrl : 'view/login.html',
		controller : 'loginController',
		controllerAs: 'vm'
	});
	
	
	$routeProvider.when('/view/index', {
		templateUrl : 'view/index.html',
		controller : 'appControler',
		controllerAs: 'vm',
			
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
		controllerAs: 'vm',
		
		resolve : {
			clientes: function (clienteAPI) {
				return clienteAPI.getClientes();
			},
			malaDiretas: function (malaDigitalAPI) {
				return malaDigitalAPI.getMalaDiretas();
			}
		}
	});
	
	$routeProvider.when('/view/cadastroMalaDireta', {
		templateUrl : 'view/cadastroMalaDireta.html',
		controller : 'malaDiretaController',
		controllerAs: 'vm',
		
		resolve : {
			clientes: function (clienteAPI) {
				return clienteAPI.getClientes();
			},
			malaDiretas: function (malaDigitalAPI) {
				return malaDigitalAPI.getMalaDiretas();
			}
		}
	});
	
	$routeProvider.when('/view/alterarMalaDireta', {
		templateUrl : 'view/index.html',
		controller : 'malaDiretaController',
		controllerAs: 'vm',
		
		resolve : {
			clientes: function (clienteAPI) {
				return clienteAPI.getClientes();
			},
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