angular.module("mDigital").controller("formMalaDiretaController",function($location, $rootScope, malaDigitalAPI){
	var vm = this;
	vm.malaDireta = null;
	
	vm.$onInit = function(){
		vm.malaDireta = null;
	};
	
	vm.cadastrarMalaDireta = function(malaDireta){
		malaDigitalAPI.cadastrar(malaDireta).then(
			function(response){
				delete vm.malaDireta;
				
				$rootScope.$broadcast("atualizarListaMalaDireta", null);
				
                //Volta o estado do formulario para pristine (nunca utilizado)
				vm.formMalaDireta.$setPristine();
				
				//Ao salvar o contato volto para a página principal
				$location.path("/malaDireta");	
			}
		);
	};	

})