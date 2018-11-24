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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Prato prato = new Prato();
        String id1 = req.getParameter("id");
        String nome = req.getParameter("nome");
        String categoria = req.getParameter("categoria");
        String descricao = req.getParameter("descricao");
        String preco1 = req.getParameter("preco");

        int id = Integer.parseInt(id1);
        float preco = Float.parseFloat(preco1);

        prato.setId(id);
        prato.setNome(nome);
        prato.setCategoria(categoria);
        prato.setDescricao(descricao);
        prato.setPreco(preco);

        boolean retorno = new PratoDAO().update(prato);

        RequestDispatcher disp;
        if (retorno) {
            req.setAttribute("sucesso", "Prato atualizado com sucesso");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        } else {
            req.setAttribute("erro", "Não foi possivel atualizar");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        }
    }
}