<%-- 
    Document   : loginFunc
    Created on : 12/10/2018, 21:29:59
    Author     : Lucas Roratto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="theme.css" type="text/css">
    </head>
    <body >
        <nav class="navbar navbar-expand-md navbar-light">
            <div class="container"> 
                <button class="navbar-toggler navbar-toggler-right border-0" type="button" data-toggle="collapse" data-target="#navbar6">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbar6">
                    <a class="navbar-brand text-primary d-none d-md-block" href="index.jsp">
                        <i class="fa d-inline fa-lg fa-circle"></i>
                        <b> Sistema de reserva de restaurante</b>
                    </a>
                    <ul class="navbar-nav mx-auto">
                        <li class="nav-item"> <a class="nav-link" href="#">Features</a> </li>
                        <li class="nav-item"> <a class="nav-link" href="#">Pricing</a> </li>
                        <li class="nav-item"> <a class="nav-link" href="#">About</a> </li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item"> 
                            <a class="nav-link" href="loginCliente.jsp">Log in Clientes</a> 
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="py-5 text-center" style="background-image: url('https://static.pingendo.com/cover-bubble-dark.svg');background-size:cover;">
            <div class="container">
                <div class="row">
                    <div class="mx-auto col-md-6 col-10 bg-white p-5">
                        <h1 class="mb-4">Log in Area Funcionário</h1>
                        <form action="loginFunc" method="post">
                            <div class="form-group"> 
                                <input type="email" class="form-control" placeholder="Digite seu email" name="login" required>
                            </div>
                            <div class="form-group mb-3"> 
                                <input type="password" class="form-control" placeholder="Password" name="senha" required>
                                <small class="form-text text-muted text-right"></small> 
                            </div> 
                            <button type="submit" class="btn btn-primary">Submit</button>

                        </form>
                        <c:if test="${not empty mensagem}">
                            <h3><strong style="color:red">${mensagem}</strong></h3>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>