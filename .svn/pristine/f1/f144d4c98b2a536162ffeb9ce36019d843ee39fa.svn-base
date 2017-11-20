angular.module("mDigital").factory("errorInterceptor", function ($q, $location, $rootScope) {
	return {
		responseError: function (rejection) {
			$rootScope.isError = true;
			console.log(rejection.status);
			console.log(rejection);
			if (rejection.status === 404) {
				console.log("Error: 404");
				$location.path("/error");
			}
			if (rejection.status === 500) {
				$location.path("/error");
			}
			return $q.reject(rejection);
		},
		response : function(response){
			$rootScope.isError = false;
			console.log("Response: ");
			console.log(response);
			return response
		},
		request : function(config){
			$rootScope.isError = false;
			console.log("Request: ");
			console.log(config);
			return config
		},
		requestError: function(rejection){
			$rootScope.isError = false;
			console.log("Código de erro: ");
			console.log(rejection.status);
			return $q.reject(rejection)
		}
	};
});