<%--
  Created by IntelliJ IDEA.
  User: MarcosNami
  Date: 7/13/2017
  Time: 11:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Página de Login das Contas</h2>
<form action="efetuaLogin" method="post">
    Login: <input type="text" name="login" /> <br />
    Senha: <input type="password" name="senha" /> <br />
    <input type="submit" value="Entrar nas contas" />
</form>
</body>
</html>
