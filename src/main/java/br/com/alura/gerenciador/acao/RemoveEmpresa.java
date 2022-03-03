package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa {
	
	public String acao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("Removendo empresa");
		
		String id = request.getParameter("id");
		Integer idInt = Integer.valueOf(id);
		
		Banco banco = new Banco();
		banco.removeEmpresa(idInt);
		
//		response.sendRedirect("home?acao=ListaEmpresas");
		return "redirect:home?acao=ListaEmpresas";
	}

}
