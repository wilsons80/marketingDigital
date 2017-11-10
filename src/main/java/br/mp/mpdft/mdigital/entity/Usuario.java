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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((tentativasLogin == null) ? 0 : tentativasLogin.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Usuario other = (Usuario) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (tentativasLogin == null) {
			if (other.tentativasLogin != null)
				return false;
		} else if (!tentativasLogin.equals(other.tentativasLogin))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", username=" + username + ", senha=" + senha + ", ativo=" + ativo
				+ ", tentativasLogin=" + tentativasLogin + "]";
	}


	
}
