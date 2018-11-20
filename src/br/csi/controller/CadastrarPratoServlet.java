
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

/**
 * ingredientesDB sao os ingredientes que vem do banco para fazer a comparaçao do que foi selecionado no jsp
 */
        ArrayList<Ingrediente> ingredientesDB = new ArrayList<Ingrediente>();
         ingredientesDB= new IngredienteDAO().getIngredientes();

        String nome = req.getParameter("nome");
        String categoria = req.getParameter("categoria");
        String descricao = req.getParameter("descricao");
        String preco1 = req.getParameter("preco");
        Float preco = Float.parseFloat(preco1);

        Prato prato = new Prato(nome, categoria, descricao, preco);

        /**
         * ids são dos ingredientes selecionados no jsp
         */
        Ingrediente ingrediente = new Ingrediente();
        ArrayList<Ingrediente> ingredientesPrato = new ArrayList<Ingrediente>();

        for (int i = 0; i < ingredientesDB.size(); i++) {
            int id_ingrediente = 0;
            if (req.getParameter(ingredientesDB.get(i).getNome())!= null){
                id_ingrediente = Integer.parseInt(req.getParameter(ingredientesDB.get(i).getNome()));
                ingrediente.setId(id_ingrediente);
                ingredientesPrato.add(ingrediente);
            }
        }

        prato.setIngredientes(ingredientesPrato);

        boolean retorno = new PratoDAO().create(prato);
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
