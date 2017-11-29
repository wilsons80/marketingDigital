'use strict';

angular.module("mDigital").controller("loginController", function($location, usuarioAPI, $rootScope, $routeParams){
	
	/* jshint validvm: true */
	var vm = this;

	vm.usuario = null;
	
    vm.$onInit = function () {
    };
    
    
	var isNaoLogado = function(){
		return vm.logado === undefined | vm.logado === false;
	}
	
	vm.logar = function(userName, senha){
		if(isNaoLogado()){
			if(userName === undefined){
				vm.showMessage = true;
				vm.messageError = "Usuário não informado!";
			}else if(senha === undefined){
				vm.showMessage = true;
				vm.messageError = "Senha não informada!";
			}else{
				usuarioAPI.getUsuario(userName).then(function(response){
					vm.usuario = response.data;
					
					if(response.status === 204){
						vm.showMessage = true;
						vm.messageError = "Usuário não encontrado na base de dados.";
					}else{
						
						if(senha !== vm.usuario.senha){
							vm.showMessage = true;
							vm.messageError = "Senha inválida!!!";
							vm.logado = false;
						}else{
							vm.showMessage = false;
							vm.logado      = true;
							
							$location.path("/formCliente");
						}
					}
					
				}).catch(function(response){
					vm.showMessage = true;
					vm.messageError = response;
				})	
			}
		}
	};
	
	

	
	vm.loggof = function(){
		vm.logado  = false;
		vm.usuario = null;
	};
	
	
});
