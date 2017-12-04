angular.module("mDigital").factory("errorInterceptor", function ($q, $location, $rootScope) {
	return {
		responseError: function (rejection) {
			$rootScope.isError = true;
			if (rejection.status === 400) {
				$rootScope.message = rejection.data.message;				
				$location.path("/error");
			}
			if (rejection.status === 500) {
				$location.path("/errorInterno");
			}
			return $q.reject(rejection);
		},
		response : function(response){
			$rootScope.isError = false;
			return response
		},
		request : function(config){
			$rootScope.isError = false;
			return config
		},
		requestError: function(rejection){
			$rootScope.isError = false;
			return $q.reject(rejection)
		}
	};
});