package br.csi.controller;

import br.csi.dao.IngredienteDAO;
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

@WebServlet(urlPatterns = "/updateIngrediente")
public class UpdateIngredienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String ingrediente = req.getParameter("ingrediente");
        int idIng = Integer.parseInt(id);

        Ingrediente ing = new Ingrediente();
        ing.setId(idIng);
        ing.setIngrediente(ingrediente);


        boolean retorno = new IngredienteDAO().update(ing);

        PrintWriter resposta = resp.getWriter();
        RequestDispatcher disp;

        if (retorno) {
            disp = req.getRequestDispatcher("/WEB-INF/views/sucesso.jsp");
            disp.forward(req, resp);
        } else {
            resposta.println("<html><body>");
            resposta.println("<strong>ERRO</strong>");
            resposta.println("</body></html>");
        }
    }
}