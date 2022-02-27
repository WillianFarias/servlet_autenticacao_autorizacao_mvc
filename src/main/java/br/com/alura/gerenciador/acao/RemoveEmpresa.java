package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.net.HttpRetryException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa {
	
	public void acao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String id = request.getParameter("id");
		Integer idInt = Integer.valueOf(id);
		
		Banco banco = new Banco();
		banco.removeEmpresa(idInt);
		
		response.sendRedirect("listaEmpresas");
	}

}
