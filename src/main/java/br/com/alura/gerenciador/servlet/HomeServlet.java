package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlterarEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 7527900789762475931L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String parametroAcao = request.getParameter("acao");
//		String parametroAcao = request.getRequestURI();
		
		String nome = null;
		
		if (parametroAcao.equals("ListaEmpresas")) {
			
			ListaEmpresas acao = new ListaEmpresas();
//			acao.acao(request, response);
			nome = acao.acao(request, response);
			
		} else if (parametroAcao.equals("RemoveEmpresa")) {
			
			RemoveEmpresa acao = new RemoveEmpresa();
			nome = acao.acao(request, response);
			
		} else if (parametroAcao.equals("MostraEmpresa")) {
			
			MostraEmpresa acao = new MostraEmpresa();
			nome = acao.acao(request, response);
			
		} else if (parametroAcao.equals("AlteraEmpresa")) {
			
			AlterarEmpresa acao = new AlterarEmpresa();
			nome = acao.acao(request, response);
			
		} else if (parametroAcao.equals("NovaEmpresa")) {
			
			NovaEmpresa acao = new NovaEmpresa();
			nome = acao.acao(request, response);
			
		}
		
		String[] tipoEEndereco = nome.split(":");
		
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(tipoEEndereco[1]);
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
	}
}
