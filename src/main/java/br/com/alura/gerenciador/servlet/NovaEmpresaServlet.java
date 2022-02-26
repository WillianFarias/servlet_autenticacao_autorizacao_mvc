package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
//import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 7644940709210710629L;

	protected void /*service ou doGet*/doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Cadastrando nova Empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("dataAbertura");
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dataAberturaDate = simpleDateFormat.parse(dataAbertura);
			empresa.setDataAbertura(dataAberturaDate);
		} catch (ParseException e) {
			throw new ServletException("Não Foi Possível Definir a Data de Abertura! " + e);
		}
		
//		PrintWriter out = response.getWriter();
		
		if (nomeEmpresa==null) {
			nomeEmpresa = "";
		}
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		//chamando JSP
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/empresaCadastrada.jsp");
		
		request.setAttribute("nomeEmpresa", empresa.getNome());
		response.sendRedirect("listaEmpresas");
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("nomeEmpresa", empresa.getNome());
//		requestDispatcher.forward(request, response);
		
//		out.println("<html><body>Empresa "+ nomeEmpresa +" cadastrada com sucesso!</body></html>");
	}
}
