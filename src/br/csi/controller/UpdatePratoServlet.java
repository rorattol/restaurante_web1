package br.csi.controller;

import br.csi.dao.IngredienteDAO;
import br.csi.dao.PratoDAO;
import br.csi.model.Ingrediente;
import br.csi.model.Prato;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/updatePrato")
public class UpdatePratoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Ingrediente> ingredientesDB = new ArrayList<Ingrediente>();
        ingredientesDB= new IngredienteDAO().getIngredientes();

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