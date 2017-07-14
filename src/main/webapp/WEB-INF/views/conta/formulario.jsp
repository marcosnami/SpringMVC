<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marcos.nami
  Date: 13/07/2017
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adicionar Contas</title>
</head>
<body>
    <h3>Adicionar Contas</h3>
    <form action="adicionaConta" method="post">
        Descrição: <br/>
        <textarea name="descricao" rows="5" cols="100"></textarea>
        <form:errors path="conta.descricao" />
        <br/>
        Valor: <br/>
        <input type="text" name="valor" /><br/>
        Tipo: <br/>
        <select name="tipo">
            <option value="ENTRADA">Entrada</option>
            <option value="SAIDA">Saída</option>
        </select>
        <br/><br/>
        <input type="submit" value="Adicionar"/>
    </form>
</body>
</html>
