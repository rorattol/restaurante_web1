package br.csi.controller;

import br.csi.dao.ClienteDAO;
import br.csi.model.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/deleteCliente")
public class DeleteClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idCliente = req.getParameter("id");
        int id = Integer.parseInt(idCliente);

        boolean retorno = new ClienteDAO().delete(id);

        RequestDispatcher disp;
        if (retorno) {
            req.setAttribute("sucesso", "Cliente excluido com sucesso");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        } else {
            req.setAttribute("erro", "Não foi possivel deletar");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        }
    }

}
