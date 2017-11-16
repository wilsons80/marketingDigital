angular.module("mDigital").controller("appControler", function($scope , $location, usuarioAPI , clienteAPI, malaDigitalAPI){
	$scope.formClientes = {};
	$scope.formMalaDireta = {};
	
	$scope.isRenderFormCadCliente = true;
	
	
	//$scope.clientes = clienteAPI.getClientes();
	
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
	};
	
	$scope.loggof = function(){
		$scope.logado  = false;
		$scope.usuario = undefined;
	};
	
	
	$scope.cadastrarCliente = function(cliente){
		clienteAPI.cadastrar(cliente).then(
				function(data){
					delete $scope.cliente;
					
	                //Volta o estado do formulario para pristine (nunca utilizado)
					$scope.formClientes.$setPristine();
					
					//Ao salvar o contato volto para a página principal
					$location.path("/");	
					
					carregarClientes();
				}
		);
	};

	$scope.cadastrarMalaDireta = function(malaDireta){
		malaDigitalAPI.cadastrar(malaDireta).then(
				function(data){
					delete $scope.malaDireta;
					
	                //Volta o estado do formulario para pristine (nunca utilizado)
					$scope.formMalaDireta.$setPristine();
					
					//Ao salvar o contato volto para a página principal
					$location.path("/");	
					
					carregarMalaDiretas();
				}
		);
	};

	var carregarClientes = function() {
		clienteAPI.getClientes().then(function(response){
			$scope.clientes = response.data;	
		}).catch( function(response){
			console.log(response);
			$scope.error = "Serviço temporariamento fora do ar.";
		});
		
	};
	carregarClientes();	
	
	var carregarMalaDiretas = function(){
		malaDigitalAPI.getMalaDiretas().then(function(response){
			$scope.malaDiretas = response.data;
		}).catch(function(response){
			console.log(response);
			$scope.error = "Serviço temporariamento fora do ar.";
		});
	};
	carregarMalaDiretas();
	
	$scope.renderFormCadastroCliente = function(){
		$scope.isRenderFormCadCliente = true;
		return $scope.isRenderFormCadCliente;
	};
	
	$scope.renderFormCadastroMalaDireta = function(){
		$scope.isRenderFormCadCliente = false;
		return !$scope.isRenderFormCadCliente;
	};
	
	$scope.home = function(){
		//Ao salvar o contato volto para a página principal
		$location.path("/");	
	}
	

});