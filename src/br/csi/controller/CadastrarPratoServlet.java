
package br.csi.controller;

import br.csi.dao.PratoDAO;
import br.csi.model.Ingrediente;
import br.csi.model.Mesa;
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

        Prato prato = new Prato();
        String nome = req.getParameter("nome");
        String categoria = req.getParameter("categoria");
        String descricao = req.getParameter("descricao");
//        String preco1 = req.getParameter("preco");
//        Float preco = Float.parseFloat(preco1);

        Ingrediente adobo = new Ingrediente();
        adobo.setId(1);

        Ingrediente cremeLeite = new Ingrediente();
        cremeLeite.setId(5);

        ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
        ingredientes.add(adobo);
        ingredientes.add(cremeLeite);

        Prato lasanha = new Prato();
        lasanha.setIngredientes(ingredientes);


        boolean retorno = new PratoDAO().create(lasanha);
        System.out.println(retorno);


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
