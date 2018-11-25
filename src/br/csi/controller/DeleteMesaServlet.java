package br.csi.controller;

import br.csi.dao.MesaDAO;
import br.csi.model.Mesa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/deleteMesa")
public class DeleteMesaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idMesa = req.getParameter("id");
        int id = Integer.parseInt(idMesa);

        boolean retorno = new MesaDAO().delete(id);

        RequestDispatcher disp;
        if (retorno) {
            req.setAttribute("sucesso", "Mesa excluida com sucesso");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        } else {
            req.setAttribute("erro", "Não foi possivel deletar");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        }
    }
}
