package br.com.prosopo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
@Entity
@Table (name="Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long idUsuario;
	@Column(name="Login", nullable=false, length = 30)
	private String login;
	@Column(name="Senha", nullable=false, length = 15)
	private String senha;
	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_PERMISSAO")
	@JoinColumn(name="PERMISSAO", nullable=true)
	private Permissoes permissoes;
	
	// getts and setts
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Permissoes getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Permissoes permissoes) {
		this.permissoes = permissoes;
	}
	

		// Construtores
		public Usuario() {

		}
	public Usuario(Long idUsuario, String login, String senha, Permissoes permissoes) {
			super();
			this.idUsuario = idUsuario;
			this.login = login;
			this.senha = senha;
			this.permissoes = permissoes;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((permissoes == null) ? 0 : permissoes.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (permissoes != other.permissoes)
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

}
