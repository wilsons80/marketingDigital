angular.module("mDigital").controller("listaMalaDiretaController",function($location, $rootScope, $routeParams, malaDigitalAPI){
	var vm = this;
	
	vm.$onInit = function(){
		var unbuidCarregarListaMalaDireta = $rootScope.$on("atualizarListaMalaDireta", vm.carregarListaMalaDireta.bind(this));
		this.$onDestroy = function () {
			unbuidCarregarListaMalaDireta();
		};
		vm.carregarListaMalaDireta();
	};
	
	vm.carregarListaMalaDireta = function(){
		malaDigitalAPI.getMalaDiretas().then(function(response){
			vm.malaDiretas = response.data;
		});
	};
	
	vm.excluirMalaDireta = function(idMalaDireta){
		if (confirm("Deseja realmente excluir esse registro ?")) {
			malaDigitalAPI.excluir(idMalaDireta).then(function(data){
				delete vm.malaDireta;
				$rootScope.$broadcast("atualizarListaMalaDireta", null);
			});
		}
	};
	
	vm.salvarMalaDireta = function(malaDireta){
		malaDigitalAPI.alterar(malaDireta).then(function(response){
			delete vm.malaDireta;
			$rootScope.$broadcast("atualizarListaMalaDireta", null);
		});
		
		_permiteAlterarMalaDireta = false;
		_idMalaDiretaEdicao = 0;
	};
	

	var _idMalaDiretaEdicao = 0;
	vm.habilitaAlteracaoMalaDireta = function(codigo){
		_permiteAlterarMalaDireta = !_permiteAlterarMalaDireta;
		_idMalaDiretaEdicao = codigo;
	}
	
	vm.renderFormCadastroMalaDireta = function(){
		vm.isRenderFormCadCliente = false;
		return !vm.isRenderFormCadCliente;
	};

	var _permiteAlterarMalaDireta = false;
	vm.isHabilitaAlteracaoMalaDireta = function(codigoEdicao){
		return _permiteAlterarMalaDireta && codigoEdicao === _idMalaDiretaEdicao;
	}
	
	vm.isNotHabilitaAlteracaoMalaDireta = function(codigoEdicao){
		return !vm.isHabilitaAlteracaoMalaDireta(codigoEdicao);
	}
	
})