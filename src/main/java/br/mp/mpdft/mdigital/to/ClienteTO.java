package br.mp.mpdft.mdigital.to;

public class ClienteTO {
	
	private Integer idCliente;
	private String nome;
	private String numeroDDD;
	private String telefone;
	private String email;
	private Double rendaBrutaMensal;

	public ClienteTO() {
	}

	public ClienteTO(Integer idCliente, String nome, String numeroDDD, String telefone, String email, Double rendaBrutaMensal) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.numeroDDD = numeroDDD;
		this.telefone = telefone;
		this.email = email;
		this.rendaBrutaMensal = rendaBrutaMensal;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroDDD() {
		return numeroDDD;
	}

	public void setNumeroDDD(String numeroDDD) {
		this.numeroDDD = numeroDDD;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getRendaBrutaMensal() {
		return rendaBrutaMensal;
	}

	public void setRendaBrutaMensal(Double rendaBrutaMensal) {
		this.rendaBrutaMensal = rendaBrutaMensal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroDDD == null) ? 0 : numeroDDD.hashCode());
		result = prime * result + ((rendaBrutaMensal == null) ? 0 : rendaBrutaMensal.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		ClienteTO other = (ClienteTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroDDD == null) {
			if (other.numeroDDD != null)
				return false;
		} else if (!numeroDDD.equals(other.numeroDDD))
			return false;
		if (rendaBrutaMensal == null) {
			if (other.rendaBrutaMensal != null)
				return false;
		} else if (!rendaBrutaMensal.equals(other.rendaBrutaMensal))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClienteTO [idCliente=" + idCliente + ", nome=" + nome + ", numeroDDD=" + numeroDDD + ", telefone="
				+ telefone + ", email=" + email + ", rendaBrutaMensal=" + rendaBrutaMensal + "]";
	}
	
	
	
	
}
