/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

import br.csi.dao.MesaDAO;
import br.csi.model.Mesa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas
 */

@WebServlet(urlPatterns = "/cadastrarMesa")
public class CadastrarMesaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String qtdLugares = req.getParameter("lugares");
        String num_mesa = req.getParameter("numero");
        int lugares = Integer.parseInt(qtdLugares);
        int numero = Integer.parseInt(num_mesa);
        Mesa mesa = new Mesa();
        
        boolean retorno = new MesaDAO().create(numero, lugares);
        
        PrintWriter resposta = resp.getWriter();
        RequestDispatcher disp;

        if(retorno) {
            //DIRECIONAR PARA LISTAR MESAS
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        }
        else{
            resposta.println("<html><body>");
            resposta.println("<strong>ERRO</strong>");
            resposta.println("</body></html>");
        }
    }
    
    
}
