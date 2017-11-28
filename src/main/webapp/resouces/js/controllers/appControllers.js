angular.module("mDigital").controller("appControler", function(usuarioAPI){

	//Isola o scope
	var vm = this;
	
	vm.usuario = null;
	
    vm.$onInit = function () {
    	usuarioAPI.getUsuario("wilson.carvalho").then(function(response){
    		vm.usuario = response.data;
    	});
    };
	
    vm.home = function(){
		delete vm.cliente;
		delete vm.malaDireta;
	}
	
});