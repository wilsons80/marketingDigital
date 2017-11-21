angular.module("mDigital").controller("clienteController", function($scope , $location, clienteAPI){
	
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

	
	$scope.renderFormCadastroCliente = function(){
		$scope.isRenderFormCadCliente = true;
		return $scope.isRenderFormCadCliente;
	};
	

});