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

public class AlterarEmpresa implements Acao {

	public String acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Alterando Empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("dataAbertura");
		Integer idEmpresa = Integer.parseInt(request.getParameter("id"));
		Date dataAberturaDate = null;
		
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dataAberturaDate = simpleDateFormat.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException("Não Foi Possível Definir a Data de Abertura! " + e);
		}
		
		Banco banco = new Banco();
		Empresa empresa = banco.capturarEmpresa(idEmpresa);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAberturaDate);
		
//		response.sendRedirect("home?acao=ListaEmpresas");
		return "redirect:home?acao=ListaEmpresas";
	}
}
