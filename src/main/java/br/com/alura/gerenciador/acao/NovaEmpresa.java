package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa {
	
	public void acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		if (nomeEmpresa==null) {
			nomeEmpresa = "";
		}
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		request.setAttribute("nomeEmpresa", empresa.getNome());
		response.sendRedirect("home?acao=ListaEmpresas");
	}

}
