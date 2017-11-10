package br.mp.mpdft.mdigital.to;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MalaDiretaTO {
	
	private Long  codigo;
	private String nome;
	private Double faixaRendaInicial;
	private Double faixaRendaFinal;
	private List<ClienteTO> clientes;

	public MalaDiretaTO() {
	}

	public MalaDiretaTO(Long codigo, String nome, Double faixaRendaInicial, Double faixaRendaFinal,List<ClienteTO> clientes) {
		this.codigo = codigo;
		this.nome = nome;
		this.faixaRendaInicial = faixaRendaInicial;
		this.faixaRendaFinal = faixaRendaFinal;
		this.clientes = clientes;
	}

	public void addClientes(List<ClienteTO> clientes){
		if(Objects.isNull(this.clientes)){this.clientes = new ArrayList<ClienteTO>();}
		this.clientes.addAll(clientes);
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getFaixaRendaInicial() {
		return faixaRendaInicial;
	}

	public void setFaixaRendaInicial(Double faixaRendaInicial) {
		this.faixaRendaInicial = faixaRendaInicial;
	}

	public Double getFaixaRendaFinal() {
		return faixaRendaFinal;
	}

	public void setFaixaRendaFinal(Double faixaRendaFinal) {
		this.faixaRendaFinal = faixaRendaFinal;
	}

	public List<ClienteTO> getClientes() {
		return clientes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientes == null) ? 0 : clientes.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((faixaRendaFinal == null) ? 0 : faixaRendaFinal.hashCode());
		result = prime * result + ((faixaRendaInicial == null) ? 0 : faixaRendaInicial.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MalaDiretaTO other = (MalaDiretaTO) obj;
		if (clientes == null) {
			if (other.clientes != null)
				return false;
		} else if (!clientes.equals(other.clientes))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (faixaRendaFinal == null) {
			if (other.faixaRendaFinal != null)
				return false;
		} else if (!faixaRendaFinal.equals(other.faixaRendaFinal))
			return false;
		if (faixaRendaInicial == null) {
			if (other.faixaRendaInicial != null)
				return false;
		} else if (!faixaRendaInicial.equals(other.faixaRendaInicial))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MalaDireta [codigo=" + codigo + ", nome=" + nome + ", faixaRendaInicial=" + faixaRendaInicial
				+ ", faixaRendaFinal=" + faixaRendaFinal + "]";
	}

	
	
	
}
