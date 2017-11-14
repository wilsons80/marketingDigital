angular.module("mDigital").factory("clienteAPI", function($http, config){
	
	var _cadastrar = function(cliente){
		return $http.post(config.baseURL + "cliente", cliente , { headers: 'application/json' });
	}
	
	return {
		cadastrar : _cadastrar
	}
	
});