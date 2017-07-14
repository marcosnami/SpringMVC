<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: marcos.nami
  Date: 13/07/2017
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Lista de Contas</title>
    <script src="resources/js/jquery.js"></script>
</head>

<script>
    function pagaAgora(id) {
        $.post("pagaConta", {'id' : id}, function() {
            $("#conta_"+id).html("Paga");
        });
    }
</script>

<body>

<table style="height: 10px; width: 775px;" border="1">
    <tr>
        <th>Código</th>
        <th>Descrição</th>
        <th>Valor</th>
        <th>Tipo</th>
        <th>Paga?</th>
        <th>Data de pagamento</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${listaContas}" var="conta">
        <tr>
            <td>${conta.id}</td>
            <td>${conta.descricao}</td>
            <td>${conta.valor}</td>
            <td>${conta.tipo}</td>
            <td id="conta_${conta.id}">
                <c:if test="${conta.paga eq false}">
                    <a href="#" onClick="pagaAgora(${conta.id})">
                        Pagar agora!
                    </a>
                </c:if>
                <c:if test="${conta.paga eq true }">
                    Paga!
                </c:if>
            </td>
            <td><fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy"/></td>
            <td><a href="removeConta?id=${conta.id}">Remover</a> | <a href="mostraConta?id=${conta.id}">Alterar</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
