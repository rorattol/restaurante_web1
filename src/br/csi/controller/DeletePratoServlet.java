package br.csi.controller;

import br.csi.dao.PratoDAO;
import br.csi.model.Ingrediente;
import br.csi.model.Prato;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DeletePratoServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String idPrato = req.getParameter("id");
        int id = Integer.parseInt(idPrato);


        boolean retorno = new PratoDAO().delete(id);


        PrintWriter resposta = resp.getWriter();
        if (retorno) {
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        } else {
            resposta.println("<html><body>");
            resposta.println("<strong>ERRO</strong>");
            resposta.println("</body></html>");
        }
    }
}
