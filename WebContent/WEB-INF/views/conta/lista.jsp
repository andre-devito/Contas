<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>
	Lista de Contas
</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript">

	function respOk(dadosDaResposta) {
		// alert("Conta paga com sucesso!");
		$("#conta_" + id).html("Paga");
	}	

	function fazPagamento(id) {
		$.post("pagaConta?id=" + id, respOk);
	}

</script>
</head>

<body>

	<table>
		<tr>
			<th>Código</th>
			<th>Descrição</th>
			<th>Valor</th>
			<th>Tipo</th>
			<th>Paga?</th>
			<th>Data de Pagamento</th>
			<th>Ações</th>
		</tr>

		<c:forEach items="${listContas}" var="conta">
		<tr>
			<td>${conta.id}</td>
			<td>${conta.descricao}</td>
			<td>${conta.valor}</td>
			<td>${conta.tipo}</td>
			<td>
				<c:if test="${conta.paga eq false}">
					Não Paga
				</c:if>
				<c:if test="${conta.paga eq true}">
					Paga
				</c:if>
			</td>
			<td><fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy" /></td>
			<td>
				<a href="removeConta?id=${conta.id}">Deletar</a> 
				<a href="mostraConta?id=${conta.id}">Alterar</a>
				<c:if test="${conta.paga eq false}">
					<a href="#" onclick="fazPagamento(${conta.id});">Paga Conta</a>
				</c:if>
				
			</td>
		</tr>	
		</c:forEach>
	</table>

</body>
</html>