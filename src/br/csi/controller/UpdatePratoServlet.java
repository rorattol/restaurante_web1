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
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/updatePrato")
public class UpdatePratoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Prato prato = new Prato();
        String nome = req.getParameter("nome");
        String categoria = req.getParameter("categoria");
        String descricao = req.getParameter("descricao");
        String preco1 = req.getParameter("preco");

        Float preco = Float.parseFloat(preco1);

        prato.setNomPrato(nome);
        prato.setCategoriaPrato(categoria);
        prato.setDescricaoPrato(descricao);
        prato.setPrecoPrato(preco);

        boolean retorno = new PratoDAO().update(prato);

        PrintWriter resposta = resp.getWriter();
        RequestDispatcher disp;

        if (retorno) {

            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        } else {
            resposta.println("<html><body>");
            resposta.println("<strong>ERRO</strong>");
            resposta.println("</body></html>");
        }
    }
}