package br.mp.mpdft.mdigital.to;

public class UsuarioTO {
	
	private Integer codigo;
	private String username;
	private String senha;
	private Boolean ativo;
	private Integer tentativasLogin;

	
	
	public UsuarioTO(Integer codigo, String username, String senha, Boolean ativo, Integer tentativasLogin) {
		this.codigo = codigo;
		this.username = username;
		this.senha = senha;
		this.ativo = ativo;
		this.tentativasLogin = tentativasLogin;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		UsuarioTO other = (UsuarioTO) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
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
		return "UsuarioTO [codigo=" + codigo + ", username=" + username + ", senha=" + senha + ", ativo=" + ativo
				+ ", tentativasLogin=" + tentativasLogin + "]";
	}

	
	
	
	
}
