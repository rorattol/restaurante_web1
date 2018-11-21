package br.csi.controller;

import br.csi.dao.IngredienteDAO;
import br.csi.model.Ingrediente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/updateIngrediente")
public class UpdateIngredienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String ingrediente = req.getParameter("nome");
        int idIng = Integer.parseInt(id);

        Ingrediente ing = new Ingrediente();
        ing.setId(idIng);
        ing.setNome(ingrediente);

        boolean retorno = new IngredienteDAO().update(ing);

        RequestDispatcher disp;
        if (retorno) {
            req.setAttribute("sucesso", "Ingrediente atualizado com sucesso");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        } else {
            req.setAttribute("erro", "Não foi possivel atualizar Ingrediente");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        }
    }
}