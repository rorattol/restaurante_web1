package br.csi.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/redirect")
public class Redirect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher;

        if( req.getParameter("add").equals("mesa")){
            dispatcher = req.getRequestDispatcher("WEB-INF/views/forms/addMesa.jsp");
            dispatcher.forward(req, resp);
        }

        if( req.getParameter("add").equals("prato")){
            dispatcher = req.getRequestDispatcher("WEB-INF/views/forms/addPrato.jsp");
            dispatcher.forward(req, resp);
        }

        if( req.getParameter("add").equals("ingrediente")){
            dispatcher = req.getRequestDispatcher("WEB-INF/views/forms/addIngrediente.jsp");
            dispatcher.forward(req, resp);
        }

        if( req.getParameter("add").equals("cliente")){
            dispatcher = req.getRequestDispatcher("WEB-INF/views/forms/addCliente.jsp");
            dispatcher.forward(req, resp);
        }

        if( req.getParameter("add").equals("funcionario")){
            dispatcher = req.getRequestDispatcher("WEB-INF/views/forms/addFuncionario.jsp");
            dispatcher.forward(req, resp);
        }
    }
}