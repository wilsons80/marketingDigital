angular.module("mDigital").controller("clienteController", function( $location, clienteAPI, malaDigitalAPI){
	var vm = this;
	
	vm.salvarCliente = function(cliente){
		//O cliente já existe
		if(cliente.idCliente > 0 ){
			vm.alterarCliente(cliente);
		}else{
			vm.cadastrarCliente(cliente);
		}
	}	
	
	vm.cadastrarCliente = function(cliente){
		console.log(cliente);
		
		clienteAPI.cadastrar(cliente).then(
				function(data){
					delete vm.cliente;
					
	                //Volta o estado do formulario para pristine (nunca utilizado)
					//vm.formClientes.$setPristine();
					
					//Ao salvar o contato volto para a página principal
					$location.path("/view/cadastroCliente");	
					
					carregarClientes();
				}
		).catch(function(response){
			console.log(response);
			vm.error = "Não foi possível cadastrar o Cliente.";
		});;
	};
	
	vm.alterarCliente = function(cliente){
		clienteAPI.alterar(cliente).then( function(response){
			delete vm.cliente;
			//vm.formClientes.$setPristine();
			carregarClientes();
		}).catch(function(response){
			console.log(response);
			vm.error = "Não foi possível alterar o Cliente de código: " + idCliente;
		});
	}
	
	vm.carregarDadosClente = function(cliente){
		vm.cliente = angular.copy(cliente);
	}
	
	vm.excluirCliente = function(idCliente){
		if (confirm("Deseja realmente excluir esse registro ?")) {
			clienteAPI.excluir(idCliente).then(function(data){
				delete vm.cliente;
				carregarClientes();
				
			}).catch(function(data){
				console.log(response);
				vm.error = "Não foi possível excluir o Cliente de código: " + idCliente;
			});
		}
	};
	
	vm.getClientesMalaDireta = function(malaDireta){
		malaDigitalAPI.getClientesMalaDireta(malaDireta).then( function(response){
			vm.clientes = response.data;
		});
	};
	
	vm.renderFormCadastroCliente = function(){
		vm.isRenderFormCadCliente = true;
		return vm.isRenderFormCadCliente;
	};

	
	/*////////////////////////////////*/
	/*Código duplicado*/
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

	var _permiteAlterarMalaDireta = false;
	vm.isHabilitaAlteracaoMalaDireta = function(codigoEdicao){
		return _permiteAlterarMalaDireta && codigoEdicao === _idMalaDiretaEdicao;
	}
	
	vm.isNotHabilitaAlteracaoMalaDireta = function(codigoEdicao){
		return !vm.isHabilitaAlteracaoMalaDireta(codigoEdicao);
	}
	/*////////////////////////////////*/
	
	
});