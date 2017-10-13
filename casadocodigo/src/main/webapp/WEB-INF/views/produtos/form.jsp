<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

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
	<form:form action="${s:mvcUrl('PC#gravar').build()}" method="post"
		commandName="produto" enctype="multipart/form-data">

		<div class="form-group">
			<label>Título</label>
			<form:input path="titulo" cssClass="form-control"/>
			<form:errors path="titulo" />
		</div>

		<div class="form-group">
			<label>Descrição</label>
			<form:textarea path="descricao" cssClass="form-control" />
			<form:errors path="descricao" />
		</div>

		<div class="form-group">
			<label>Páginas</label>
			<form:input path="paginas" cssClass="form-control"/>
			<form:errors path="paginas" />
		</div>

		<div class="form-group">
			<label>Data de Lançamento</label>
			<form:input path="dataLancamento" cssClass="form-control" />
			<form:errors path="dataLancamento" />
		</div>


		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">

			<div class="form-group">
				<label>${tipoPreco}</label>
				<form:input path="precos[${status.index}].valor" cssClass="form-control"/>
				<form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}" />
			</div>

		</c:forEach>
		
		<div class="form-group">
			<label>Sumario</label>
			<input name ="sumario" type="file"/>
		</div>

		<button type="submit" class="btn btn-primary">Cadastrar</button>
	</form:form>
	</div>

</body>
</html>