package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alterarEmpresa")
public class AlterarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Alterando Empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("dataAbertura");
		Integer idEmpresa = Integer.parseInt(request.getParameter("id"));
		Date dataAberturaDate = null;
//		Integer idEmpresa = Integer.valueOf(request.getParameter("id"));
		
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
		
		response.sendRedirect("listaEmpresas");
		
	}

}
