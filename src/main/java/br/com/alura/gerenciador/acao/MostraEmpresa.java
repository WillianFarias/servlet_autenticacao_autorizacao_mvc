package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa {

	public void acao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Editar empresa");
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Banco banco = new Banco();
		Empresa empresa = banco.capturarEmpresa(id);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editarEmpresa.jsp");
		request.setAttribute("empresa", empresa);
		requestDispatcher.forward(request, response);
	}
}
