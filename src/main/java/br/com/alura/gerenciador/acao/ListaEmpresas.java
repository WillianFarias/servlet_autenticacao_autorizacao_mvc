package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao {
	
	public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		HttpSession sessao = request.getSession();
//		if (sessao.getAttribute("usuarioLogado") == null) {
//			return "redirec:home?acao=LoginForm";
//		}
		
		System.out.println("Listando Empresas");
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		request.setAttribute("empresas", lista);
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/empresasCadastradas.jsp");
//		requestDispatcher.forward(request, response);
		return "forward:empresasCadastradas.jsp";
	}

}
