angular.module("mDigital").factory("malaDigitalAPI", function($http, config){
	var _getMalaDiretas = function(){
		return $http.get(config.baseURL + "maladireta");
	};
	
	var _cadastrar = function(malaDireta){
		return $http.post(config.baseURL + "maladireta", malaDireta, { headers: 'application/json' });
	};
	
	var _excluir = function(idMalaDireta){
		return $http.delete(config.baseURL + "maladireta/" + idMalaDireta);
	};
	
	var _getClientesMalaDireta = function(malaDireta){
		return $http.get(config.baseURL + "cliente/faixaRenda/" + malaDireta.faixaRendaInicial + "/" + malaDireta.faixaRendaFinal);
	};
	
	var _alterar = function(malaDireta){
		return $http.put(config.baseURL + "maladireta/" + malaDireta.codigo, malaDireta , { headers: 'application/json' });
	}
	
	return {
		getMalaDiretas : _getMalaDiretas,
		cadastrar : _cadastrar,
		excluir : _excluir,
		getClientesMalaDireta : _getClientesMalaDireta,
		alterar : _alterar
	}
});