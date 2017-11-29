angular.module("mDigital").controller("listarClienteController", function($location, $rootScope, clienteAPI){
	var vm = this;
	
	
	vm.$onInit = function(){
		
		var unbuidCarregarListaClientes = $rootScope.$on("atualizarListaClientes", vm.carregarListaClientes.bind(this));
		this.$onDestroy = function () {
			unbuidCarregarListaClientes();
		};
		
		vm.carregarListaClientes();
	}

	vm.carregarListaClientes = function(){
		clienteAPI.getClientes().then(function(response){
			vm.clientes = response.data;
		});
	}

	
	vm.carregarDadosClente = function(cliente){
		$rootScope.$broadcast("clienteSelecionadoRender", cliente.idCliente);
	}
	
	
	vm.getClientesMalaDireta = function(malaDireta){
		malaDigitalAPI.getClientesMalaDireta(malaDireta).then( function(response){
			vm.clientes = response.data;
		});
	};
	
	
	vm.renderFormCadastroCliente = function(){
		vm.isRenderFormCadCliente = true;
		return vm.isRenderFormCadCliente;
	};

	vm.excluirCliente = function(idCliente){
		if (confirm("Deseja realmente excluir esse registro ?")) {
			clienteAPI.excluir(idCliente).then(function(data){
				delete vm.cliente;
				
				$rootScope.$broadcast("atualizarListaClientes", null);
			});
		}
	};		
	
});