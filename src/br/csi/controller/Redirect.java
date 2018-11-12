package br.csi.controller;

import br.csi.dao.*;
import br.csi.model.*;

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

            dispatcher = req.getRequestDispatcher("forms/addMesa.jsp");
            dispatcher.forward(req, resp);

        }

//        if( req.getParameter("add").equals("prato")){
//
//            Prato prato = new Prato();
//
//            req.setAttribute("prato", prato);
//            dispatcher = req.getRequestDispatcher("forms/addPrato.jsp");
//            dispatcher.forward(req, resp);
//        }
//
//        if( req.getParameter("add").equals("ingrediente")){
//
//            Ingrediente ing = new Ingrediente();
//
//            req.setAttribute("ingrediente", ing);
//            dispatcher = req.getRequestDispatcher("forms/addIngrediente.jsp");
//            dispatcher.forward(req, resp);
//        }
//
//        if( req.getParameter("add").equals("cliente")){
//
//
//
//            Cliente cliente = new Cliente();
//
//            req.setAttribute("cliente", cliente);
//            dispatcher = req.getRequestDispatcher("forms/addCliente.jsp");
//            dispatcher.forward(req, resp);
//        }
//
//        if( req.getParameter("add").equals("funcionario")){
//
//            Funcionario func = new Funcionario();
//
//            req.setAttribute("funcionario", func);
//            dispatcher = req.getRequestDispatcher("forms/addFuncionario.jsp");
//            dispatcher.forward(req, resp);
//        }
    }
}