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
	
	var _getClientesMalaDireta = function(faixaRendaInicial, faixaRendaFinal){
		return $http.get(config.baseURL + "cliente/faixaRenda/" + faixaRendaInicial + "/" + faixaRendaFinal);
	};
	
	var _alterar = function(malaDireta){
		return $http.put(config.baseURL + "maladireta/" + malaDireta.codigo, malaDireta , { headers: 'application/json' });
	}
	
	var _getMalaDiretaPorFaixa = function(faixaInicial, faixaFinal){
		return $http.get(config.baseURL + "maladireta/" + malaDireta.faixaRendaInicial + "/" + malaDireta.faixaRendaFinal);
	}
	
	return {
		getMalaDiretas : _getMalaDiretas,
		cadastrar : _cadastrar,
		excluir : _excluir,
		getClientesMalaDireta : _getClientesMalaDireta,
		alterar : _alterar,
		getMalaDiretaPorFaixa : _getMalaDiretaPorFaixa
	}
});