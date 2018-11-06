package br.csi.controller;

import br.csi.dao.PratoDAO;
import br.csi.model.Prato;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher;

        if( req.getParameter("item").equals("prato")){

           String id = req.getParameter("id");

            Prato prato = new PratoDAO().read(Integer.parseInt(id));

            req.setAttribute("prato", prato);
            dispatcher = req.getRequestDispatcher("forms/editPrato.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
