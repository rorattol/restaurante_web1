<%-- 
    Document   : sucesso
    Created on : 01/10/2018, 14:39:38
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>Formulario</div>
        <h2>${nome_usuario}</h2>

        <c:if>
            <c:import url="colocar html do form"></c:import>
        </c:if>




        
        <h2>OFERECER OPÇÃO DE RESERVAR MESA</h2>
    </body>
</html>
