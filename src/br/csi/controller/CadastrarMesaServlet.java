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
        Mesa mesa = new Mesa(numero, lugares);
        
        boolean retorno = new MesaDAO().create(mesa);

        RequestDispatcher disp;
        if (retorno) {
            req.setAttribute("sucesso", "Mesa cadastrada com sucesso");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        } else {
            req.setAttribute("erro", "Não foi possivel realizar cadastro");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        }
    }
    
    
}
