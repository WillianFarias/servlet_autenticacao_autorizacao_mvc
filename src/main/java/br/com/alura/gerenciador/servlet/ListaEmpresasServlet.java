package br.com.alura.gerenciador.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		for (Empresa empresa : lista) {
			System.out.println(empresa.getNome());
		}
		
//		PrintWriter out = response.getWriter();
		
//		out.println("<html><body>");
//		out.println("<html><body>");
//		out.println("<ul>");
//		for (Empresa empresa : lista) {
//			out.println("<li>" + empresa.getNome() + "</li>");
//		}
//		out.println("</ul>");
//		out.println("</body></html>");
		
		//chamando JSP
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/empresasCadastradas.jsp");
		request.setAttribute("empresas", lista);
		requestDispatcher.forward(request, response);
	}
}
