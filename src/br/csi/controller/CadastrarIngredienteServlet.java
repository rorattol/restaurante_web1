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
        
        PrintWriter resposta = resp.getWriter();
        if(retorno){

            //DIRECIONAR PARA LISTAR MESAS
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
            
        }
        
        else{
            resposta.println("<html><body>");
            resposta.println("<strong>ERRO</strong>");
            resposta.println("</body></html>");
            
            
        }
    }
}
