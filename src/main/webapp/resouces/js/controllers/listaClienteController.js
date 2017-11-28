angular.module("mDigital").controller("listarClienteController", function($location, clienteAPI){
	var vm = this;
	
	
	vm.$onInit = function(){
		clienteAPI.getClientes().then(function(response){
			vm.clientes = response.data;
		});
		
		console.log("Cliente: " , vm.cliente);
	}
	

	
	vm.carregarDadosClente = function(cliente){
		$rootScope.$broadcast("clienteSelecionadoRender", cliente.idCliente);
	}
	
	
	vm.excluirCliente = function(idCliente){
		if (confirm("Deseja realmente excluir esse registro ?")) {
			clienteAPI.excluir(idCliente).then(function(data){
				delete vm.cliente;
				
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

	
	
});