angular.module("mDigital").controller("listarClienteController", function($location, $rootScope, $routeParams, clienteAPI, malaDigitalAPI){
	var vm = this;
	
	vm.$onInit = function(){
		var unbuidCarregarListaClientes        = $rootScope.$on("atualizarListaClientes", vm.carregarListaClientes.bind(this));
		var unbuidFiltrarClientesPorMalaDireta = $rootScope.$on("filtrarClientesPorMalaDireta", vm.getClientesMalaDireta.bind(this));
		this.$onDestroy = function () {
			unbuidCarregarListaClientes();
			unbuidFiltrarClientesPorMalaDireta();
		};
		
		var faixaRendaInicial = $routeParams["faixaRendaInicial"];
		var faixaRendaFinal   = $routeParams["faixaRendaFinal"];
		if(faixaRendaInicial && faixaRendaFinal){
			vm.getClientesMalaDireta(event,faixaRendaInicial,faixaRendaFinal);
		}else{
			vm.carregarListaClientes(event);
		}
	}

	vm.carregarListaClientes = function(event){
		clienteAPI.getClientes().then(function(response){
			vm.clientes = response.data;
		});
	}
	
	vm.carregarDadosClente = function(cliente){
		$rootScope.$broadcast("clienteSelecionadoRender", cliente.idCliente);
	}
	
	vm.getClientesMalaDireta = function(event,faixaRendaInicial, faixaRendaFinal){
		malaDigitalAPI.getClientesMalaDireta(faixaRendaInicial,faixaRendaFinal).then( function(response){
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