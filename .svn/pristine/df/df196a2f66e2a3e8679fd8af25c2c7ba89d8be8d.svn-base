angular.module("mDigital").factory("usuarioAPI",function($http, config){
	
	var _getUsuario = function(username){
		return $http.get(config.baseURL + "usuario/" + username);
	};
	
	return {
		getUsuario : _getUsuario
	}
	
});