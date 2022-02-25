<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Lista de Clientes</title>
</head>
<style>
* {
    box-sizing: border-box;
    outline: 0;
    }
    body{
    background: rgb(17, 86, 102);
    font-family: 'Open sans', sans-serif;
    font-size: 1.3em;
    line-height: 1.5em;
        }
    .container{
      
        max-width: 1300px;
        max-height: 1600px;
        margin: 80px auto;
        background: #fff;
        padding: 30px;
        border-radius: 10px;
    }

h1{
    font-family: 'Open sans', sans-serif;
    font-size: 3em;
    line-height: 1.5em;
    text-align: center;
    color: rgb(17, 86, 102);


}
table{
    border: 1px solid  rgb(17, 86, 102);
    width: 50%;
    margin: auto;
}

td, th{
    border: 1px solid rgb(17, 86, 102);
   

}

</style>
<body>
	<div class="container">
		<h1>Lista de Clientes</h1>
		<table>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Nascimento</th>
				<th>Idade</th>
				<th>Genero</th>
				<th>Endereço</th>
				<th>Telefone</th>
				<th>Email</th>
				<th>Produto</th>
				<th>Ver+</th>
				<th>Excluir</th>
			</tr>
			<c:forEach items="${cliente}" var="c">
				<tr> <td>${c.id }</td>
					<td>${c.nome }</td>
					<td><fmt:formatDate value="${c.dataNascimento.time}"
							pattern="dd/MM/yyyy" /></td>
					<td>${c.idade }</td>
					<td>${c.genero}</td>
					<td>${c.endereco}</td>
					<td>${c.telefone}</td>
					<td>${c.email}</td>
					<td>${c.produto}</td>


					<td><a href="alterarCliente?idCliente=${c.id }">Ver+</a></td>
					<td><a href="excluirCliente?idCliente=${c.id }"
						onclick="return confirm('Confirmar exclus�o do cliente ${c.nome}?')">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
		</div>
</body>
</html>