<%--
  Created by IntelliJ IDEA.
  User: Lucas
  Date: 01/11/2018
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="theme.css" type="text/css">
        <title>Title</title>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-md navbar-light">
                <button class="navbar-toggler navbar-toggler-right border-0" type="button" data-toggle="collapse"
                        data-target="#navbar6">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbar6">
                    <a class="navbar-brand text-primary d-none d-md-block" href="../../index.jsp">
                        <i class="fa d-inline fa-lg fa-circle"></i>
                        <b> Sistema de reserva de restaurante</b>
                    </a>
                    <ul class="navbar-nav mx-auto">
                        <li class="nav-item"><a class="nav-link" href="#">Features</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Pricing</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">About</a></li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item">${logado.nome}</li>
                        <li class="nav-item"><a class="nav-link text-primary" href="logout">Sair</a></li>
                    </ul>
                </div>
            </nav>
            <div class="row" >
                <div class="mx-auto col-lg-6 col-10">
                    <h1>Editar Funcionário</h1>
                    <p class="mb-3">
                        When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees.
                    </p>
                    <form class="text-left" method="post" action="updateFunc">
                        <div class="form-group">
                            <label for="form16">Nome do Funcionário</label>
                            <input type="text" class="form-control" id="form16" value="${funcionario.nome}">
                        </div>
                        <div class="form-group">
                            <label for="form17">Email do Funcionário</label>
                            <input type="text" class="form-control" id="form17" value="#{funcionario.email}">
                        </div>
                        <button type="submit" class="btn btn-primary">Editar</button>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
