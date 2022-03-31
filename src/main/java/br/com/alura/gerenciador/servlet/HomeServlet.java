package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 7527900789762475931L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametroAcao = request.getParameter("acao");
//		Boolean acaoProtegida = !(parametroAcao.equals("Login") || parametroAcao.equals("LoginForm"));
//		
//		HttpSession sessao = request.getSession();
//		Boolean usuarioNaoLogado = (sessao.getAttribute("usuarioLogado") == null);
//		
//		if (usuarioNaoLogado && acaoProtegida) {
//			response.sendRedirect("redirec:home?acao=LoginForm");
//			return;
//		}
		
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + parametroAcao;
		String nome;
		
		try {
			Class classe = Class.forName(nomeDaClasse);//carrega a classe
			Acao acao = (Acao) classe.newInstance();
			nome = acao.acao(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEEndereco = nome.split(":");
		
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
	}
}
