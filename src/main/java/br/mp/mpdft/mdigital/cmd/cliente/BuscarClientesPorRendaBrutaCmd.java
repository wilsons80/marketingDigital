package br.mp.mpdft.mdigital.cmd.cliente;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.dao.ClienteDAO;
import br.mp.mpdft.mdigital.excpetion.FaixaRendaNaoInformadaException;
import br.mp.mpdft.mdigital.to.ClienteTO;

@Component
public class BuscarClientesPorRendaBrutaCmd {

	@Autowired
	private ClienteDAO clienteDAO;

	
	public List<ClienteTO> getClientesPorMalaDireta(Double faixaRendaInicial, Double faixaRendaFinal ){
		if(Objects.isNull(faixaRendaInicial) && Objects.isNull(faixaRendaFinal)){
			throw new FaixaRendaNaoInformadaException("A faixa de renda não foi informada.");
		}
		return clienteDAO.getClientesPorMalaDireta(faixaRendaInicial, faixaRendaFinal);
	}

}
