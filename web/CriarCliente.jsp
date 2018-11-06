<%-- 
    Document   : loginFunc
    Created on : 12/10/2018, 21:29:59
    Author     : Lucas
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

    <body>
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
                        <li class="nav-item"> <a class="nav-link" href="loginCliente.jsp">Log in</a> </li>
                        <li class="nav-item"> <a class="nav-link text-primary" href="loginFunc.jsp">Area Restrita</a> </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="py-5 text-center" >
            <div class="container">
                <div class="row">
                    <div class="mx-auto col-lg-6 col-10">
                        <h1>Cadastre-se</h1>
                        <p class="mb-3">Junte-se a nós. Com seu cadastro, além da possibilidade de ver o menu do nosso restaurante, poderá ainda fazer reservas de mesa.</p>

                        <form class="text-left" action="cadastrarUsuario" method="post">
                            <div class="form-group">
                                <label for="form16">Seu nome</label>
                                <input type="text" class="form-control" id="form16" name="nome" placeholder="Nome Sobrenome">
                            </div>
                            <div class="form-group">
                                <label for="form18">Seu email</label>
                                <input type="email" class="form-control" name="email" id="form18" placeholder="exemplo@exemplo.com">
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="form19">Senha</label>
                                    <input type="password" class="form-control" id="form19" name="senha" placeholder="••••">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="form20">Telefone</label>
                                    <input type="text" class="form-control" id="form20" name="telefone" placeholder="(99)99999-9999">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Cadastrar<br></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>