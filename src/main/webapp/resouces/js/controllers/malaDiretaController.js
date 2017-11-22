angular.module("mDigital").controller("malaDiretaController",function($location, clienteAPI, malaDigitalAPI){
	var vm = this;

	vm.cadastrarMalaDireta = function(malaDireta){
		malaDigitalAPI.cadastrar(malaDireta).then(
				function(response){
					delete vm.malaDireta;
					
	                //Volta o estado do formulario para pristine (nunca utilizado)
					vm.formMalaDireta.$setPristine();
					
					//Ao salvar o contato volto para a página principal
					$location.path("/");	
					
					carregarMalaDiretas();
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
				carregarMalaDiretas();
				
			}).catch(function(data){
				console.log(response);
				vm.error = "Não foi possível excluir a Mala Direta de código: " + idMalaDireta;
			});
		}
	};
	
	vm.salvarMalaDireta = function(malaDireta){
		malaDigitalAPI.alterar(malaDireta).then(function(response){
			delete vm.malaDireta;
			
			carregarMalaDiretas();
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

	var carregarClientes = function() {
		clienteAPI.getClientes().then(function(response){
			vm.clientes = response.data;	
		});
	};
	carregarClientes();	

	var carregarMalaDiretas = function(){
		malaDigitalAPI.getMalaDiretas().then(function(response){
			vm.malaDiretas = response.data;
		});
	};
	carregarMalaDiretas();	

	
	/*////////////////////////////////*/
	/*Código duplicado*/
	var _idMalaDiretaEdicao = 0;
	vm.habilitaAlteracaoMalaDireta = function(codigo){
		_permiteAlterarMalaDireta = !_permiteAlterarMalaDireta;
		_idMalaDiretaEdicao = codigo;
	}

	
	var _permiteAlterarMalaDireta = false;
	vm.isHabilitaAlteracaoMalaDireta = function(codigoEdicao){
		return _permiteAlterarMalaDireta && codigoEdicao === _idMalaDiretaEdicao;
	}
	
	vm.isNotHabilitaAlteracaoMalaDireta = function(codigoEdicao){
		return !vm.isHabilitaAlteracaoMalaDireta(codigoEdicao);
	}
	/*////////////////////////////////*/

	
	
})