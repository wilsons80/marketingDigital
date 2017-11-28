angular.module("mDigital").factory("clienteAPI", function($http, config){
	
	var _cadastrar = function(cliente){
		return $http.post(config.baseURL + "cliente", cliente , { headers: 'application/json' });
	}
	
	var _getClientes = function(){
		return $http.get(config.baseURL + "cliente");
	}
	
	var _getCliente = function(idCliente){
		return $http.get(config.baseURL + "cliente/" + idCliente);
	}
	
	var _excluir = function(idCliente){
		return $http.delete(config.baseURL + "cliente/" + idCliente);
	};
	
	var _alterar = function(cliente){
		return $http.put(config.baseURL + "cliente/" + cliente.idCliente, cliente , { headers: 'application/json' });
	}
	
	return {
		cadastrar   : _cadastrar,
		getClientes : _getClientes,
		getCliente  : _getCliente,
		excluir     : _excluir,
		alterar     : _alterar 
	}
	
});