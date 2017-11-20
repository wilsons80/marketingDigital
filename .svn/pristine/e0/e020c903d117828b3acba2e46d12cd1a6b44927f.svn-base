package br.mp.mpdft.mdigital.infra.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import br.mp.mpdft.mdigital.service.ClienteService;
import br.mp.mpdft.mdigital.service.UsuarioService;

public class MarketingDigitalApplication extends Application {
	
	//Armazena todos os WebServices da aplicação
	private Set<Object> services = new HashSet<>();
	
	
	public MarketingDigitalApplication() {
		services.add(new UsuarioService());
		services.add(new ClienteService());
	}


	@Override
	public Set<Object> getSingletons() {
		return services;
	}
	
}
