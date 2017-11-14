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
	
	@Column(name="vlFaixaRendaInicial", nullable=false)
	private Double faixaRendaInicial;
	
	@Column(name="vlFaixaRendaFinal", nullable=false)
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faixaRendaFinal == null) ? 0 : faixaRendaFinal.hashCode());
		result = prime * result + ((faixaRendaInicial == null) ? 0 : faixaRendaInicial.hashCode());
		result = prime * result + ((idMalaDireta == null) ? 0 : idMalaDireta.hashCode());
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
		MalaDireta other = (MalaDireta) obj;
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
		if (idMalaDireta == null) {
			if (other.idMalaDireta != null)
				return false;
		} else if (!idMalaDireta.equals(other.idMalaDireta))
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
		return "MalaDireta [idMalaDireta=" + idMalaDireta + ", nome=" + nome + ", faixaRendaInicial="
				+ faixaRendaInicial + ", faixaRendaFinal=" + faixaRendaFinal + "]";
	}


	
}
