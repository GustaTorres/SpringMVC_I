<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
<script src="resources/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de livros</title>
</head>
<body>
	<div>${message}</div>

	<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}">Casa do Código</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="${s:mvcUrl('PC#listProducts').build()}">Lista de Produtos</a></li>
				<li><a href="${s:mvcUrl('PC#form').build()}">Cadastro de Produtos</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container">
		<h1>Lista de produtos</h1>

		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Título
				</td>
				<th>Descrição
				</td>
				<th>Páginas
				</td>
				<th>Data de Lancamento
				</td>
			</tr>

			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td><a
						href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build()}">${produto.titulo}</a>
					</td>
					<td>${produto.descricao }</td>
					<td>${produto.paginas }</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${produto.dataLancamento.time}" /></td>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>