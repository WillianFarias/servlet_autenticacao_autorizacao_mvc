package br.com.alura.gerenciador.modelo;

public class Usuario {
	
	String login;
	String senha;
	
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
	
	public boolean ehIgual(String login, String senha) {
		Boolean retorno = Boolean.FALSE;
		
		if(this.login.equals(login) && this.senha.equals(senha)) {
			retorno = Boolean.TRUE;
		}
		
		return retorno;
	}
}
