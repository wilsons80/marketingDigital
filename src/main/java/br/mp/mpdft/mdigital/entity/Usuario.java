package br.mp.mpdft.mdigital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import br.mp.mpdft.mdigital.infra.hibernate.HibernateTypes;

@Entity
@Table(name="USUARIO", schema="dbo")
public class Usuario {
	
	@Id
	@Column(name="idUsuario", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(name="nmUsername", length=250, nullable=false)
	private String username;
	
	@Column(name="txSenha", length=250, nullable=false)
	private String senha;
	
	@Type(type=HibernateTypes.SimNaoType)
	@Column(name="stAtivo", length=1)
	private Boolean ativo;
	
	@Column(name="qtTentativasLogin", length=1)
	private Integer tentativasLogin;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getTentativasLogin() {
		return tentativasLogin;
	}

	public void setTentativasLogin(Integer tentativasLogin) {
		this.tentativasLogin = tentativasLogin;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", username=" + username + ", senha=" + senha + ", ativo=" + ativo
				+ ", tentativasLogin=" + tentativasLogin + "]";
	}


	
}
