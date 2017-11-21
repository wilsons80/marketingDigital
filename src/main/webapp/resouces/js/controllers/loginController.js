angular.module("mDigital").controller("loginController", function($scope, $location, usuarioAPI){
	var isNaoLogado = function(){
		return $scope.logado === undefined | $scope.logado === false;
	}
	
	$scope.logar = function(userName, senha){
		if(isNaoLogado()){
			if(userName === undefined){
				$scope.showMessage = true;
				$scope.messageError = "Usuário não informado!";
			}else if(senha === undefined){
				$scope.showMessage = true;
				$scope.messageError = "Senha não informada!";
			}else{
				usuarioAPI.getUsuario(userName).then(function(response){
					$scope.usuario = response.data;
					
					if(response.status === 204){
						$scope.showMessage = true;
						$scope.messageError = "Usuário não encontrado na base de dados.";
					}else{
						
						if(senha !== $scope.usuario.senha){
							$scope.showMessage = true;
							$scope.messageError = "Senha inválida!!!";
							$scope.logado = false;
						}else{
							$scope.showMessage = false;
							$scope.logado = true;
						}
					}
					
				}).catch(function(response){
					$scope.showMessage = true;
					$scope.messageError = response;
				})	
			}
		}
		
		$location.path("/view/index");
	};
	
	$scope.loggof = function(){
		$scope.logado  = false;
		$scope.usuario = undefined;
	};
	
	
});
