package br.mp.mpdft.mdigital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE", schema="dbo")
public class Cliente {
	
	@Id
	@Column(name="idCliente", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCliente;
	
	@Column(name="nmNome", length=250, nullable=false)
	private String nome;
	
	@Column(name="nrTelefone", length=9)
	private String telefone;
	
	@Column(name="dsEmail", length=250, nullable=false)
	private String email;
	
	@Column(name="vlRendaBrutaMensal", nullable=false, precision=2)
	private Double rendaBrutaMensal;

	
	public Cliente() {
	}
	
	public Cliente(Integer idCliente, String nome, String telefone, String email,Double rendaBrutaMensal) {
		this.idCliente = idCliente; 
		this.nome = nome;
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
		Cliente other = (Cliente) obj;
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
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", telefone="
				+ telefone + ", email=" + email + ", rendaBrutaMensal=" + rendaBrutaMensal + "]";
	}

	
	

}
