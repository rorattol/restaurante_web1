
package br.csi.controller;

import br.csi.dao.IngredienteDAO;
import br.csi.dao.PratoDAO;
import br.csi.model.Ingrediente;
import br.csi.model.Prato;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lucas
 */
@WebServlet(urlPatterns = "/cadastrarPrato")
public class CadastrarPratoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String categoria = req.getParameter("categoria");
        String descricao = req.getParameter("descricao");
        String preco1 = req.getParameter("preco");
        String[] ingredientes = null;
        Float preco = Float.parseFloat(preco1);

        Prato prato = new Prato(nome, categoria, descricao, preco);

        ArrayList<Ingrediente> ingredientesPrato = new ArrayList<Ingrediente>();

        ingredientes = req.getParameterValues("ingredientes");
        for (String id_ingrediente: ingredientes) {
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setId(Integer.parseInt(id_ingrediente));
            ingredientesPrato.add(ingrediente);
        }

        prato.setIngredientes(ingredientesPrato);

        boolean retorno = new PratoDAO().create(prato);
        System.out.println(retorno);

        RequestDispatcher disp;
        if (retorno) {
            req.setAttribute("sucesso", "Prato cadastrado com sucesso");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        } else {
            req.setAttribute("erro", "Não foi possivel realizar cadastro");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        }
    }
}
