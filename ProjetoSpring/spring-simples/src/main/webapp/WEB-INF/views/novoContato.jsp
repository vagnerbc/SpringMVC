<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
		<title>Adicionar contato</title>
	</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	
	<form action="adicionaContato" method="post">
		<label for="nome">Nome:</label>
		<input type="text" name="nome">
		<form:errors path="contato.nome" cssStyle="color:red"></form:errors>
		<br> 
		<label for="email">E-mail:</label>
		<input type="email" name="email">
		<form:errors path="contato.email" cssStyle="color:red"></form:errors>
		<br/>
		<label for="endereco">Endereço:</label>
		<input type="text" name="endereco">
		<br/>
		<label for="dataNascimento">Data nascimento:</label>
		<input type="date" id="dataNascimento"></input>
		<br/>
		<button type="submit">Gravar</button>
	</form>
	
	<c:import url="rodape.jsp"></c:import>
</body>
</html>