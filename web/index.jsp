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
            <div class="container"> <button class="navbar-toggler navbar-toggler-right border-0" type="button" data-toggle="collapse" data-target="#navbar6">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbar6"> <a class="navbar-brand text-primary d-none d-md-block" href="#">
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
        <div class="py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="">Cardápio</h1>
                    </div>
                </div>
            </div>
        </div>
        <div class="py-5" style="">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="nav nav-pills">
                            <li class="nav-item" >
                                <a class="nav-link" href="reservarMesa.jsp" data-toggle="pill" data-target="#tabtwo">Reservar mesa</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <jsp:useBean id="pratoDAO" class="br.csi.dao.PratoDAO"></jsp:useBean>
                <div class="row">
                    <div class="col-md-12">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Nome</th>
                                    <th>Categoria</th>
                                    <th>Descrição</th>
                                    <th>Preço</th>
                                </tr>
                            </thead>

                        <c:forEach var="prato" items="${pratoDAO.pratos}">
                                <tr>
                                    <td>${prato.nomPrato}</td>
                                    <td>${prato.categoriaPrato}</td>
                                    <td>${prato.descricaoPrato}</td>
                                    <td>${prato.precoPrato}</td>
                                </tr>	
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        
    </body>

</html>