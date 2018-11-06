<%-- 
    Document   : dashboard
    Created on : 08/10/2018, 15:50:31
    Author     : Lucas
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" href="theme.css" type="text/css">
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
                        <li class="nav-item">${logado.nomeFunc}</li>
                        <li class="nav-item"><a class="nav-link text-primary" href="logout">Sair</a></li>
                    </ul>
                </div>
            </nav>
            <div class="py-5" style="">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="">Bem-vindo</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <jsp:useBean id="pratoDAO" class="br.csi.dao.PratoDAO"></jsp:useBean>
                            <jsp:useBean id="mesaDAO" class="br.csi.dao.MesaDAO"></jsp:useBean>
                            <jsp:useBean id="ingredienteDAO" class="br.csi.dao.IngredienteDAO"></jsp:useBean>
                            <jsp:useBean id="funcionarioDAO" class="br.csi.dao.FuncionarioDAO"></jsp:useBean>
                            <jsp:useBean id="usuarioDAO" class="br.csi.dao.ClienteDAO"></jsp:useBean>
                            <h2>Pratos</h2>
                            <a href="#" class="btn btn-primary" role="button">Add</a>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Nome</th>
                                        <th>Categoria</th>
                                        <th>Descrição</th>
                                        <th>Preço</th>
                                        <th>Ações</th>
                                    </tr>
                                </thead>

                                <c:forEach var="prato" items="${pratoDAO.pratos}">
                                    <tr>
                                        <td>${prato.id}</td>
                                        <td>${prato.nomPrato}</td>
                                        <td>${prato.categoriaPrato}</td>
                                        <td>${prato.descricaoPrato}</td>
                                        <td>${prato.precoPrato}</td>
                                        <td>
                                            <a href="#" class="btn btn-danger" role="button">Delete</a>
                                            <a href="update/item=prato&&id=${prato.id}" class="btn btn-info" role="button">Edit</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <hr>

                            <h2>Mesa</h2>
                            <a href="#" class="btn btn-primary" role="button">Add</a>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Número mesa</th>
                                        <th>Número Lugares</th>
                                        <th>Reservado</th>
                                        <th>Ações</th>

                                    </tr>
                                </thead>

                                <c:forEach var="mesa" items="${mesaDAO.mesas}">
                                    <tr>
                                        <td>${mesa.id}</td>
                                        <td>${mesa.numMesa}</td>
                                        <td>${mesa.lugares}</td>
                                        <c:if test="${mesa.reservado == false}">
                                            <td><a class="btn btn-primary disabled">Disponivel</a>
                                            </td>
                                        </c:if>
                                        <c:if test="${mesa.reservado == true}">
                                            <td><a class="btn btn-danger disabled">Reservado</a>
                                            </td>
                                        </c:if>
                                        <td>
                                            <a href="#" class="btn btn-danger" role="button">Delete</a>
                                            <a href="update/item=mesa&&id=${mesa.id}" class="btn btn-info" role="button">Edit</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <hr>

                            <h2>Ingrediente</h2>
                            <a href="#" class="btn btn-primary" role="button">Add</a>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Nome Ingrediente</th>
                                        <th>Ações</th>
                                    </tr>
                                </thead>

                                <c:forEach var="ing" items="${ingredienteDAO.ingredientes}">
                                    <tr>
                                        <td>${ing.id}</td>
                                        <td>${ing.ingrediente}</td>
                                        <td>
                                            <a href="#" class="btn btn-danger" role="button">Delete</a>
                                            <a href="update/item=ingrediente&&id=${ing.id}" class="btn btn-info" role="button">Edit</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <hr>

                            <h2>Funcionario</h2>
                            <a href="#" class="btn btn-primary" role="button">Add</a>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Nome Funcionario</th>
                                        <th>Email</th>
                                        <th>Ações</th>
                                    </tr>
                                </thead>

                                <c:forEach var="func" items="${funcionarioDAO.funcionarios}">
                                    <tr>
                                        <td>${func.id}</td>
                                        <td>${func.nomeFunc}</td>
                                        <td>${func.emailFunc}</td>
                                        <td>
                                            <a href="#" class="btn btn-danger" role="button">Delete</a>
                                            <a href="update/item=funcionario&&id=${func.id}" class="btn btn-info" role="button">Edit</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <hr>

                            <h2>Cliente</h2>
                            <a href="#" class="btn btn-primary" role="button">Add</a>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Nome Cliente</th>
                                        <th>Email</th>
                                        <th>Telefone</th>
                                        <th>Ações</th>
                                    </tr>
                                </thead>

                                <c:forEach var="usuario" items="${usuarioDAO.clientes}">
                                    <tr>
                                        <td>${usuario.id}</td>
                                        <td>${usuario.nomeCliente}</td>
                                        <td>${usuario.emailCliente}</td>
                                        <td>${usuario.telefoneCliente}</td>
                                        <td>
                                            <a href="#" class="btn btn-danger" role="button">Delete</a>
                                            <a href="update/item=usuario&&id=${usuario.id}" class="btn btn-info" role="button">Edit</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <hr>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>