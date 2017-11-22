angular.module("mDigital").controller("appControler", function($location, usuarioAPI , clienteAPI, malaDigitalAPI){

	//Isola o scope
	var vm = this;
	
	vm.formClientes = {};
	vm.formMalaDireta = {};
	
	vm.isRenderFormCadCliente = true;
	
	vm.home = function(){
		delete vm.cliente;
		delete vm.malaDireta;
		
		_permiteAlterarMalaDireta = false;
		_idMalaDiretaEdicao = 0;
		
		//Ao salvar o contato volto para a página principal
		$location.path("view/index.xhtml");
	}
	
	var _idMalaDiretaEdicao = 0;
	vm.habilitaAlteracaoMalaDireta = function(codigo){
		_permiteAlterarMalaDireta = !_permiteAlterarMalaDireta;
		_idMalaDiretaEdicao = codigo;
	}
	
	
	
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
	var _permiteAlterarMalaDireta = false;
	vm.isHabilitaAlteracaoMalaDireta = function(codigoEdicao){
		return _permiteAlterarMalaDireta && codigoEdicao === _idMalaDiretaEdicao;
	}
	
	vm.isNotHabilitaAlteracaoMalaDireta = function(codigoEdicao){
		return !vm.isHabilitaAlteracaoMalaDireta(codigoEdicao);
	}
	/*////////////////////////////////*/

});