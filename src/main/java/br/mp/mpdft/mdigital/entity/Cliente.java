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
	
	@Column(name="vlRendaBrutaMensal", nullable=false, length=8, precision=2)
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
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", telefone="
				+ telefone + ", email=" + email + ", rendaBrutaMensal=" + rendaBrutaMensal + "]";
	}

}
