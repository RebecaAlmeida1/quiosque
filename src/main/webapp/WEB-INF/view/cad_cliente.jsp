<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Clientes</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
	<section class="container">
		<h1>Cadastro de Clientes</h1>
		<form action="salvar" method="post">
			<input type="hidden" name="id" value="">
			<div class="formulario">

				<input type="text" required placeholder="Nome" class="form"
					name="nome" value="${cliente.nome}"> <br> <input
					type="date" required name="dataNascimento"
					value="<fmt:formatDate pattern="yyyy-MM-dd" value="${cliente.dataNascimento.time}"/>" />
			</div>
			<br> <br>

			<fieldset>
				<legend>Gênero:</legend>
				<div style="font-size: 15px;">
					<input type="radio" class="radio"> Masculino <input
						type="radio" class="radio"> Feminino
				</div>

			</fieldset>

			<br> <br>
			<section>
				<input type="email" required placeholder="Email" class=""
					name="email" value="${cliente.email}">
			</section>
			<br> <br>
			<section>
				<input type="number" required placeholder="Telefone" class=""
					name="telefone" value="${cliente.telefone}">
			</section>
			<br> <br>
			<section>
				<input type="text" required
					placeholder="Endereço (Ex.: Rua abc, 123 - Curitiba-PR)" class=""
					name="endereco" value="${cliente.endereco}">
			</section>
			<br> <br>
			<section>
				<input type="text" placeholder="Produto" class="" id="inputState"
					class="form-select" required name="produto" value="${cliente.produto}">

			</section>

			<button type="submit">SALVAR</button>
		</form>
	</section>
</body>
</html>