angular.module("mDigital").controller("appControler", function($scope , $location, usuarioAPI , clienteAPI, malaDigitalAPI){
	$scope.formClientes = {};
	$scope.formMalaDireta = {};
	
	$scope.isRenderFormCadCliente = true;
	
	$scope.home = function(){
		delete $scope.cliente;
		delete $scope.malaDireta;
		
		_permiteAlterarMalaDireta = false;
		_idMalaDiretaEdicao = 0;
		
		//Ao salvar o contato volto para a página principal
		$location.path("view/index.xhtml");
	
		//carregarMalaDiretas();
		//carregarClientes();	
	}
	
	var _idMalaDiretaEdicao = 0;
	$scope.habilitaAlteracaoMalaDireta = function(codigo){
		_permiteAlterarMalaDireta = !_permiteAlterarMalaDireta;
		_idMalaDiretaEdicao = codigo;
	}
	
	var _permiteAlterarMalaDireta = false;
	$scope.isHabilitaAlteracaoMalaDireta = function(codigoEdicao){
		return _permiteAlterarMalaDireta && codigoEdicao === _idMalaDiretaEdicao;
	}
	
	$scope.isNotHabilitaAlteracaoMalaDireta = function(codigoEdicao){
		return !$scope.isHabilitaAlteracaoMalaDireta(codigoEdicao);
	}
	
	
	$scope.cadastroCliente = function(){
		//Ao salvar o contato volto para a página principal
		$location.path("view/cadastroClientes.html");

	}
	

});