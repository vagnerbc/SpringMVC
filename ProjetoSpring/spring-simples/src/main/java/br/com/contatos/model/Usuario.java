package br.com.contatos.model;

import javax.validation.constraints.NotNull;

public class Usuario {

	@NotNull
	private String usuario;

	@NotNull
	private String senha;

	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
