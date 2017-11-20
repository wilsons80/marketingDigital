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
	
	
	$scope.salvarCliente = function(cliente){
		//O cliente já existe
		if(cliente.idCliente > 0 ){
			alterarCliente(cliente);
		}else{
			cadastrarCliente(cliente);
		}
	}
	
	var cadastrarCliente = function(cliente){
		clienteAPI.cadastrar(cliente).then(
				function(data){
					delete $scope.cliente;
					
	                //Volta o estado do formulario para pristine (nunca utilizado)
					$scope.formClientes.$setPristine();
					
					//Ao salvar o contato volto para a página principal
					$location.path("/");	
					
					carregarClientes();
				}
		).catch(function(response){
			console.log(response);
			$scope.error = "Não foi possível cadastrar o Cliente.";
		});;
	};
	
	var alterarCliente = function(cliente){
		clienteAPI.alterar(cliente).then( function(response){
			delete $scope.cliente;
			$scope.formClientes.$setPristine();
			carregarClientes();
		}).catch(function(response){
			console.log(response);
			$scope.error = "Não foi possível alterar o Cliente de código: " + idCliente;
		});
	}
	
	$scope.carregarDadosClente = function(cliente){
		$scope.cliente = angular.copy(cliente);
	}
	
	$scope.excluirCliente = function(idCliente){
		if (confirm("Deseja realmente excluir esse registro ?")) {
			clienteAPI.excluir(idCliente).then(function(data){
				delete $scope.cliente;
				carregarClientes();
				
			}).catch(function(data){
				console.log(response);
				$scope.error = "Não foi possível excluir o Cliente de código: " + idCliente;
			});
		}
	};
	

	
	$scope.cadastrarMalaDireta = function(malaDireta){
		malaDigitalAPI.cadastrar(malaDireta).then(
				function(response){
					delete $scope.malaDireta;
					
	                //Volta o estado do formulario para pristine (nunca utilizado)
					$scope.formMalaDireta.$setPristine();
					
					//Ao salvar o contato volto para a página principal
					$location.path("/");	
					
					carregarMalaDiretas();
				}
		).catch(function(response){
			console.log(response);
			$scope.error = "Não foi possível cadastrar a Mala Direta.";
		});
	};	
	
	
	$scope.excluirMalaDireta = function(idMalaDireta){
		if (confirm("Deseja realmente excluir esse registro ?")) {
			malaDigitalAPI.excluir(idMalaDireta).then(function(data){
				delete $scope.malaDireta;
				carregarMalaDiretas();
				
			}).catch(function(data){
				console.log(response);
				$scope.error = "Não foi possível excluir a Mala Direta de código: " + idMalaDireta;
			});
		}
	};
	
	$scope.getClientesMalaDireta = function(malaDireta){
		malaDigitalAPI.getClientesMalaDireta(malaDireta).then( function(response){
			$scope.clientes = response.data;
		});
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
		delete $scope.cliente;
		delete $scope.malaDireta;
		
		_permiteAlterarMalaDireta = false;
		_idMalaDiretaEdicao = 0;
		
		//Ao salvar o contato volto para a página principal
		$location.path("/");
	
		carregarMalaDiretas();
		carregarClientes();	
	}
	
	var _idMalaDiretaEdicao = 0;
	$scope.habilitaAlteracaoMalaDireta = function(codigo){
		_permiteAlterarMalaDireta = !_permiteAlterarMalaDireta;
		_idMalaDiretaEdicao = codigo;
	}
	
	var _permiteAlterarMalaDireta = false;
	$scope.isHabilitaAlteracaoMalaDireta = function(codigoEdicao){
		return _permiteAlterarMalaDireta && codigoEdicao === _idMalaDiretaEdicao;
	}
	
	$scope.isNotHabilitaAlteracaoMalaDireta = function(codigoEdicao){
		return !$scope.isHabilitaAlteracaoMalaDireta(codigoEdicao);
	}
	
	
	$scope.salvarMalaDireta = function(malaDireta){
		malaDigitalAPI.alterar(malaDireta).then(function(response){
			delete $scope.malaDireta;
			
			carregarMalaDiretas();
		}).catch(function(response){
			console.log(response);
			$scope.error = "Não foi possível alterar a Mala Direta de código: " + idCliente;
		});
		
		_permiteAlterarMalaDireta = false;
		_idMalaDiretaEdicao = 0;
	}
	

});