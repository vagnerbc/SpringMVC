<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	    <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
		<title>Lista de contatos</title>
	</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	
	<a href="novoContato"><button>Adicionar</button></a>

	<table>
		<c:forEach var="contato" items="${contatos}"> 
			<tr>
				<td>${contato.nome}</td>
				<td>
					<c:choose>
					<c:when test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:when>
					<c:otherwise>
						E-mail não informado
					</c:otherwise>
					</c:choose>
				</td>
				<td>${contato.endereco}</td>
				<td>${contato.dataNascimento}</td>
				<td><a href="removeContato?id=${contato.id}">Remover</a></td>
				<td id="contato_${contato.id}">
					<c:if test="${true contato.ativo}">
						<a href="#" onclick="desativaContato(${contato.id})">Desativar</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp"></c:import>
	<script>
		function desativaContato(id){
			$.get("desativaContato?id=" + id, new function(){
				$("#contato_" + id).html("Desativado");
			});
		}
	</script>
</body>
</html>