angular.module("mDigital").factory("clienteAPI", function($http, config){
	
	var _cadastrar = function(cliente){
		return $http.post(config.baseURL + "cliente", cliente , { headers: 'application/json' });
	}
	
	var _getClientes = function(){
		return $http.get(config.baseURL + "cliente");
	}
	return {
		cadastrar : _cadastrar,
		getClientes : _getClientes
	}
	
});