angular.module("mDigital").controller("malaDiretaController",function($scope , $location, malaDigitalAPI){
	
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
	};
	
	
	var carregarMalaDiretas = function(){
		malaDigitalAPI.getMalaDiretas().then(function(response){
			$scope.malaDiretas = response.data;
		}).catch(function(response){
			console.log(response);
			$scope.error = "Serviço temporariamento fora do ar.";
		});
	};
	carregarMalaDiretas();
	
	
	
	$scope.renderFormCadastroMalaDireta = function(){
		$scope.isRenderFormCadCliente = false;
		return !$scope.isRenderFormCadCliente;
	};
	
})