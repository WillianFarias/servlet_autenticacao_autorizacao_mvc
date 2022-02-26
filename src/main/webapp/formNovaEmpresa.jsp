<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

	
	<form action="${linkNovaEmpresa}" method="post">
	
		Nome: <input type="text" name="nome" />
		Data: <input type="text" name="dataAbertura" />
		
		<input type="submit">
	</form>
</body>
</html>