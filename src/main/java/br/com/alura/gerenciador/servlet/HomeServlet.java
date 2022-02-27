package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlterarEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 7527900789762475931L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String parametroAcao = request.getParameter("acao");
		
		if (parametroAcao.equals("ListaEmpresas")) {
			
			ListaEmpresas acao = new ListaEmpresas();
			acao.acao(request, response);
			
		} else if (parametroAcao.equals("RemoveEmpresa")) {
			
			RemoveEmpresa acao = new RemoveEmpresa();
			acao.acao(request, response);
			
		} else if (parametroAcao.equals("MostraEmpresa")) {
			
			MostraEmpresa acao = new MostraEmpresa();
			acao.acao(request, response);
		} else if (parametroAcao.equals("AlteraEmpresa")) {
			
			AlterarEmpresa acao = new AlterarEmpresa();
			acao.acao(request, response);
		}
	}
}
