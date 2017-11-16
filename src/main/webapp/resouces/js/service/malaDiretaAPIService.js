angular.module("mDigital").factory("malaDigitalAPI", function($http, config){
	var _getMalaDiretas = function(){
		return $http.get(config.baseURL + "maladireta");
	};
	
	var _cadastrar = function(malaDireta){
		return $http.post(config.baseURL + "maladireta", malaDireta, { headers: 'application/json' });
	}
	
	return {
		getMalaDiretas : _getMalaDiretas,
		cadastrar : _cadastrar
	}
});