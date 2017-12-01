package br.mp.mpdft.mdigital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MALA_DIRETA", schema="dbo")
public class MalaDireta {
	
	@Id
	@Column(name="idMalaDireta", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMalaDireta;

	@Column(name="nmNome", length=250, nullable=false)
	private String nome;
	
	@Column(name="vlFaixaRendaInicial", nullable=false, length=8, precision=2)
	private Double faixaRendaInicial;
	
	@Column(name="vlFaixaRendaFinal", nullable=false, length=8, precision=2)
	private Double faixaRendaFinal;
	
	public MalaDireta() {
	}
	
	public MalaDireta(Integer idMalaDireta, String nome, Double faixaRendaInicial, Double faixaRendaFinal) {
		this.idMalaDireta      = idMalaDireta;
		this.nome              = nome;
		this.faixaRendaInicial = faixaRendaInicial;
		this.faixaRendaFinal   = faixaRendaFinal;
	}
	
	
	public Integer getIdMalaDireta() {
		return idMalaDireta;
	}

	public void setIdMalaDireta(Integer idMalaDireta) {
		this.idMalaDireta = idMalaDireta;
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

	@Override
	public String toString() {
		return "MalaDireta [idMalaDireta=" + idMalaDireta + ", nome=" + nome + ", faixaRendaInicial="
				+ faixaRendaInicial + ", faixaRendaFinal=" + faixaRendaFinal + "]";
	}


	
}
