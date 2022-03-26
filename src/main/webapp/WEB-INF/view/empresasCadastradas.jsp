<%@ page import="java.util.List" %>
<%@ page import="br.com.alura.gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<body>
	
		Usuario Logado: ${usuarioLogado.login}
		<br>
		<br>
	
		<c:if test="${ not empty empresa }">
			Empresa ${ empresa } cadastrada com sucesso!
		</c:if>
		
		<h2>Empresas Cadastradas</h2>
	
			<c:if test="${not empty empresas }">
				<ul>
					<c:forEach items="${empresas}" var="empresa">
						<fmt:formatDate value="${empresa.dataAbertura}" var="dataAbertura" pattern="dd/MM/yyyy"/>
						<li> ${ empresa.nome } - ${ dataAbertura }
							<a href="/gerenciador/home?acao=MostraEmpresa&id=${ empresa.id }">Editar</a> 
							<a href="/gerenciador/home?acao=RemoveEmpresa&id=${ empresa.id }">Remover</a>
						</li>
					</c:forEach>
				</ul>
			</c:if>
			
			<c:if test="${ empty empresas }">
				Não Existem Empresas Cadastradas
			</c:if>
			
	<body>
<html>