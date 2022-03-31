package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/home")
public class AutorizacaoFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("AutorizacaoFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession sessao = request.getSession();
		
		Boolean usuarioNaoLogado = (sessao.getAttribute("usuarioLogado") == null);
		String parametroAcao = request.getParameter("acao");
		Boolean acaoProtegida = !(parametroAcao.equals("Login") || parametroAcao.equals("LoginForm"));
		
		if (usuarioNaoLogado && acaoProtegida) {
			response.sendRedirect("redirec:home?acao=LoginForm");
			return;
		}
		
		//executa acao
		chain.doFilter(request, response);
	}
}
