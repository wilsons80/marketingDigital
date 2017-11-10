package br.mp.mpdft.mdigital.to;

public class ClienteTO {
	
	private Long  codigo;
	private String nome;
	private String telefone;
	private String email;
	private Double rendaBrutaMensal;

	public ClienteTO() {
	}
	
	public ClienteTO(Long codigo, String nome, String telefone, String email, Double rendaBrutaMensal) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.rendaBrutaMensal = rendaBrutaMensal;
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
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
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
		return "ClienteTO [codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", rendaBrutaMensal=" + rendaBrutaMensal + "]";
	}
	
	

}
