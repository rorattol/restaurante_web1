<%--
  Created by IntelliJ IDEA.
  User: Lucas
  Date: 14/10/2018
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                        <li class="nav-item"><a class="nav-link" href="#"></a></li>
                        <li class="nav-item"><a class="nav-link" href="#"></a></li>
                        <li class="nav-item"><a class="nav-link" href="#"></a></li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item">${logado.nome}</li>
                        <li class="nav-item"><a class="nav-link text-primary" href="logout">Sair</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="py-5" >
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <p class="lead">Reserve sua Mesa</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="py-5" style="">
            <div class="container">
                <jsp:useBean id="mesaDAO" class="br.csi.dao.MesaDAO"></jsp:useBean>
                <div class="row">
                    <div class="col-md-12">
                        <c:if test="${not empty sucesso}">
                            <h3><strong style="color:green">${sucesso}</strong></h3>
                        </c:if>
                        <c:if test="${not empty erro}">
                            <h3><strong style="color:red">${erro}</strong></h3>
                        </c:if>
                        <table class="table">
                            <thead>
                            <tr>
                                <th>Mesa</th>
                                <th>Quantidade Lugares</th>
                                <th>Reservar</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="mesa" items="${mesaDAO.mesas}">
                                <tr>
                                    <td>${mesa.numMesa}</td>
                                    <td>${mesa.lugares}</td>
                                    <c:if test = "${mesa.reservado == false}">
                                        <td><a class="btn btn-primary" href="reservaMesa?reservado=${mesa.reservado}&idMesa=${mesa.id}&lugares=${mesa.lugares}&numMesa=${mesa.numMesa}">Reservar</a></td>
                                    </c:if>
                                    <c:if test="${mesa.reservado == true}">
                                      <td><a class="btn btn-danger disabled" href="">Reservado</a></td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
