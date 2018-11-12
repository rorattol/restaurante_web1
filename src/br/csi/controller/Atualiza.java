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

@WebServlet(urlPatterns = "/update")
public class Atualiza extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher;

        if( req.getParameter("item").equals("mesa")){

            String id = req.getParameter("id");

            Mesa mesa = new MesaDAO().read(Integer.parseInt(id));

            req.setAttribute("mesa", mesa);
            dispatcher = req.getRequestDispatcher("WEB-INF/views/forms/EditMesa.jsp");
            dispatcher.forward(req, resp);
        }

        if( req.getParameter("item").equals("prato")){

           String id = req.getParameter("id");

            Prato prato = new PratoDAO().read(Integer.parseInt(id));

            req.setAttribute("prato", prato);
            dispatcher = req.getRequestDispatcher("WEB-INF/views/forms/EditPrato.jsp");
            dispatcher.forward(req, resp);
        }

        if( req.getParameter("item").equals("ingrediente")){

            String id = req.getParameter("id");

            Ingrediente ing = new IngredienteDAO().read(Integer.parseInt(id));

            req.setAttribute("ingrediente", ing);
            dispatcher = req.getRequestDispatcher("WEB-INF/views/forms/EditIngrediente.jsp");
            dispatcher.forward(req, resp);
        }

        if( req.getParameter("item").equals("cliente")){

            String id = req.getParameter("id");

            Cliente cliente = new ClienteDAO().read(Integer.parseInt(id));

            req.setAttribute("cliente", cliente);
            dispatcher = req.getRequestDispatcher("WEB-INF/views/forms/editCliente.jsp");
            dispatcher.forward(req, resp);
        }

        if( req.getParameter("item").equals("funcionario")){

            String id = req.getParameter("id");

            Funcionario func = new FuncionarioDAO().read(Integer.parseInt(id));

            req.setAttribute("funcionario", func);
            dispatcher = req.getRequestDispatcher("WEB-INF/views/forms/EditFuncionario.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
