angular.module("mDigital").controller("formClienteController", function($location, $routeParams, $rootScope, clienteAPI){
	
	var vm = this;
	vm.maxlength = 9;
	
	vm.isRenderFormCadCliente = true;
	vm.cliente = null;
	
	vm.$onInit = function(){
		novoCliente();
		
		var idCliente = $routeParams["id"];
        if (idCliente) {
        	clienteAPI.getCliente(idCliente).then(function(response){
        		vm.cliente = response.data;
        	});
        } else {
            $rootScope.$broadcast("clienteSelecionado", null);
        }	
	}
	
	novoCliente = function(){
		vm.cliente = null;
	}
	
	vm.salvarCliente = function(cliente){
		//O cliente já existe
		if(cliente.idCliente > 0 ){
			vm.alterarCliente(cliente);
		}else{
			vm.cadastrarCliente(cliente);
		}
	}	
	
	vm.cadastrarCliente = function(cliente){
		clienteAPI.cadastrar(cliente).then(
				function(data){
					delete vm.cliente;
					
					$rootScope.$broadcast("atualizarListaClientes", null);					
					
	                //Volta o estado do formulario para pristine (nunca utilizado)
					vm.formClientes.$setPristine();

					//Ao salvar o contato volto para a página principal
					$location.path("/cliente");	
				}
		);
	};
	
	
	vm.alterarCliente = function(cliente){
		clienteAPI.alterar(cliente).then( function(response){
			delete vm.cliente;
			
			$rootScope.$broadcast("atualizarListaClientes", null);					
			
            //Volta o estado do formulario para pristine (nunca utilizado)
			vm.formClientes.$setPristine();

			//Ao salvar o contato volto para a página principal
			$location.path("/cliente");	
		});
	}
		

})