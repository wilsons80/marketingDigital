angular.module("mDigital").controller("malaDiretaController",function($location, malaDigitalAPI){
	var vm = this;
	vm.malaDiretas = null;
	
	
	vm.$onInit = function(){
		malaDigitalAPI.getMalaDiretas().then(function(response){
			vm.malaDiretas = response.data;
		});
	};
	
	
	vm.cadastrarMalaDireta = function(malaDireta){
		malaDigitalAPI.cadastrar(malaDireta).then(
				function(response){
					delete vm.malaDireta;
					
	                //Volta o estado do formulario para pristine (nunca utilizado)
					vm.formMalaDireta.$setPristine();
					
					//Ao salvar o contato volto para a página principal
					$location.path("/");	
					
				}
		).catch(function(response){
			console.log(response);
			vm.error = "Não foi possível cadastrar a Mala Direta.";
		});
	};	
	
	
	vm.excluirMalaDireta = function(idMalaDireta){
		if (confirm("Deseja realmente excluir esse registro ?")) {
			malaDigitalAPI.excluir(idMalaDireta).then(function(data){
				delete vm.malaDireta;
				
			}).catch(function(data){
				console.log(response);
				vm.error = "Não foi possível excluir a Mala Direta de código: " + idMalaDireta;
			});
		}
	};
	
	vm.salvarMalaDireta = function(malaDireta){
		malaDigitalAPI.alterar(malaDireta).then(function(response){
			delete vm.malaDireta;
			
		}).catch(function(response){
			console.log(response);
			vm.error = "Não foi possível alterar a Mala Direta de código: " + idCliente;
		});
		
		_permiteAlterarMalaDireta = false;
		_idMalaDiretaEdicao = 0;
	};
	
	vm.renderFormCadastroMalaDireta = function(){
		vm.isRenderFormCadCliente = false;
		return !vm.isRenderFormCadCliente;
	};

	/*////////////////////////////////*/
	/*Código duplicado*/
	var _permiteAlterarMalaDireta = false;
	vm.isHabilitaAlteracaoMalaDireta = function(codigoEdicao){
		return _permiteAlterarMalaDireta && codigoEdicao === _idMalaDiretaEdicao;
	}
	
	vm.isNotHabilitaAlteracaoMalaDireta = function(codigoEdicao){
		return !vm.isHabilitaAlteracaoMalaDireta(codigoEdicao);
	}
	/*////////////////////////////////*/	
	
	
})