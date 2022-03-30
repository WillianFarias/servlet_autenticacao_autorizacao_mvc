<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
	
		<c:if test="${not empty nomeEmpresa}">
			Empresa ${ nomeEmpresa } cadastrada com sucesso! <%--expression language --%>
		</c:if>
		
		<c:if test="${empty nomeEmpresa }">
			N�o foi cadastrada uma nova empresa!		
		</c:if>
		
	</body>
</html>