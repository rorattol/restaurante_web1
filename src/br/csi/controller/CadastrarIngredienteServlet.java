/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Lucas
 */

@WebServlet(urlPatterns = "/cadastrarIngrediente")
public class CadastrarIngredienteServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String ingrediente = req.getParameter("ingrediente");
        Ingrediente ing = new Ingrediente();
        
        boolean retorno = new IngredienteDAO().create(ingrediente);

        RequestDispatcher disp;
        if (retorno) {
            req.setAttribute("mensagem", "Ingrediente cadastrado com sucesso");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);

        } else {
            req.setAttribute("mensagem", "Não foi possivel realizar cadastro");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        }
    }
}
