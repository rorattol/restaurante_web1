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
                <li class="nav-item"> <a class="nav-link" href="#">Features</a> </li>
                <li class="nav-item"> <a class="nav-link" href="#">Pricing</a> </li>
                <li class="nav-item"> <a class="nav-link" href="#">About</a> </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link text-primary" href="loginFunc.jsp">Area Restrita</a>
                </li>
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
                <table class="table">
                    <thead>
                    <tr>
                        <th>Mesa</th>
                        <th>Quantidade Lugares</th>
                        <th>Reservar</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="mesa" items="${MesaDAO.mesas}">
                        <tr>
                            <td>${mesa.numMesa}</td>
                            <td>${mesa.lugares}</td>
                            <c:if test = "{$mesa.reservado = false}">
                                <td><a class="btn btn-primary" href="#">Reservar</a></td>
                            </c:if>
                            <c:if test="{$mesa.reservado = true}">
                              <td><a class="btn btn-danger disabled" href="#">Reservado</a></td>
                            </c:if>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
