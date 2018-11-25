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
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
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
                        <li class="nav-item"><a class="nav-link" href="#"></a></li>
                        <li class="nav-item"><a class="nav-link" href="#"></a></li>
                        <li class="nav-item"><a class="nav-link" href="#"></a></li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item">${logado.nome}</li>
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


                            <c:if test="${not empty sucesso}">
                            <h3><strong style="color:green">${sucesso}</strong></h3>
                            </c:if>
                            <c:if test="${not empty erro}">
                                <h3><strong style="color:red">${erro}</strong></h3>
                            </c:if>
                            <h2>Pratos</h2>
                            <a href="redirect?add=prato" class="btn btn-primary" role="button">Add</a>
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
                                        <td>${prato.nome}</td>
                                        <td>${prato.categoria}</td>
                                        <td>${prato.descricao}</td>
                                        <td>${prato.preco}</td>
                                        <td>
                                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#pratoModal" data-whatever="${prato.id}" >Deletar</button>
                                            <a href="update?item=prato&&id=${prato.id}" class="btn btn-info" role="button">Edit</a>
                                        </td>
                                    </tr>
                                    <div class="modal fade" id="pratoModal" tabindex="-1" role="dialog" aria-labelledby="pratoModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h3 class="modal-title">Exclusão</h3>
                                                    <button type="button" class="close" data-dismiss="modal">
                                                        <span aria-hidden="true">x</span>
                                                    </button>
                                                </div>
                                                <form method="post" action="deletePrato">
                                                    <div class="modal-body">
                                                        <p>Tem certeza que deseja excluir prato?</p>
                                                        <input type="hidden" class="form-control"  name="id" id="prato">
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="submit" class="btn btn-primary">Excluir</button>
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </table>
                            <hr>

                            <h2>Mesa</h2>
                            <a href="redirect?add=mesa" class="btn btn-primary" role="button">Add</a>
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
                                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#mesaModal" data-whatever="${mesa.id}" >Deletar</button>
                                            <a href="update?item=mesa&&id=${mesa.id}" class="btn btn-info" role="button">Edit</a>
                                        </td>
                                    </tr>
                                    <div class="modal fade" id="mesaModal" tabindex="-1" role="dialog" aria-labelledby="mesaModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h3 class="modal-title">Exclusão</h3>
                                                    <button type="button" class="close" data-dismiss="modal">
                                                        <span aria-hidden="true">x</span>
                                                    </button>
                                                </div>
                                                <form method="post" action="deleteMesa">
                                                    <div class="modal-body">
                                                        <p>Tem certeza que deseja excluir essa mesa?</p>
                                                        <input type="hidden" class="form-control"  name="id" id="mesa">
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="submit" class="btn btn-primary">Excluir</button>
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </table>
                            <hr>

                            <h2>Ingrediente</h2>
                            <a href="redirect?add=ingrediente" class="btn btn-primary" role="button">Add</a>
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
                                        <td>${ing.nome}</td>
                                        <td>
                                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#ingModal" data-whatever="${ing.id}" >Deletar</button>
                                            <a href="update?item=ingrediente&&id=${ing.id}" class="btn btn-info" role="button">Edit</a>
                                        </td>
                                    </tr>
                                    <div class="modal fade" id="ingModal" tabindex="-1" role="dialog" aria-labelledby="ingModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h3 class="modal-title">Exclusão</h3>
                                                    <button type="button" class="close" data-dismiss="modal">
                                                        <span aria-hidden="true">x</span>
                                                    </button>
                                                </div>
                                                <form method="post" action="deleteIngrediente">
                                                    <div class="modal-body">
                                                        <p>Tem certeza que deseja excluir ingrediente?</p>
                                                        <input type="hidden" class="form-control"  name="id" id="ingrediente">
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="submit" class="btn btn-primary">Excluir</button>
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </table>
                            <hr>

                            <h2>Funcionario</h2>
                            <a href="redirect?add=funcionario" class="btn btn-primary" role="button">Add</a>
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
                                        <td>${func.nome}</td>
                                        <td>${func.email}</td>
                                        <td>
                                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#funcModal" data-whatever="${func.id}" >Deletar</button>
                                            <a href="update?item=funcionario&&id=${func.id}" class="btn btn-info" role="button">Edit</a>
                                        </td>
                                    </tr>
                                    <div class="modal fade" id="funcModal" tabindex="-1" role="dialog" aria-labelledby="funcModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h3 class="modal-title">Exclusão</h3>
                                                    <button type="button" class="close" data-dismiss="modal">
                                                        <span aria-hidden="true">x</span>
                                                    </button>
                                                </div>
                                                <form method="post" action="deleteFunc">
                                                    <div class="modal-body">
                                                        <p>Tem certeza que deseja excluir funcionario?</p>
                                                        <input type="hidden" class="form-control"  name="id" id="funcionario">
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="submit" class="btn btn-primary">Excluir</button>
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </table>
                            <hr>

                            <h2>Cliente</h2>
                            <a href="redirect?add=cliente" class="btn btn-primary" role="button">Add</a>
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
                                        <td>${usuario.nome}</td>
                                        <td>${usuario.email}</td>
                                        <td>${usuario.telefone}</td>
                                        <td>
                                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#clienteModal" data-whatever="${usuario.id}" >Deletar</button>
                                            <a href="update?item=cliente&&id=${usuario.id}" class="btn btn-info" role="button">Edit</a>
                                        </td>
                                    </tr>
                                    <div class="modal fade" id="clienteModal" tabindex="-1" role="dialog" aria-labelledby="clienteModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h3 class="modal-title">Exclusão</h3>
                                                    <button type="button" class="close" data-dismiss="modal">
                                                        <span aria-hidden="true">x</span>
                                                    </button>
                                                </div>
                                                <form method="post" action="deleteCliente">
                                                    <div class="modal-body">
                                                        <p>Tem certeza que deseja excluir cliente?</p>
                                                        <input type="hidden" class="form-control"  name="id" id="cliente">
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="submit" class="btn btn-primary">Excluir</button>
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </table>
                            <hr>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<script type="text/javascript">
    $('#pratoModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var recipient = button.data('whatever')
        var modal = $(this)
        modal.find('.modal-title').text(recipient)
        modal.find('.modal-body input').val(recipient)
    })
    $('#mesaModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var recipient = button.data('whatever')
        var modal = $(this)
        modal.find('.modal-title').text(recipient)
        modal.find('.modal-body input').val(recipient)
    })
    $('#ingModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var recipient = button.data('whatever')
        var modal = $(this)
        modal.find('.modal-title').text(recipient)
        modal.find('.modal-body input').val(recipient)
    })
    $('#clienteModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var recipient = button.data('whatever')
        var modal = $(this)
        modal.find('.modal-title').text(recipient)
        modal.find('.modal-body input').val(recipient)
    })
    $('#funcModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var recipient = button.data('whatever')
        var modal = $(this)
        modal.find('.modal-title').text(recipient)
        modal.find('.modal-body input').val(recipient)
    })
</script>
    </body>
</html>