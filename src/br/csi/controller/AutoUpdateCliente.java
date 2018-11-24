/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

import br.csi.dao.ClienteDAO;
import br.csi.model.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Lucas
 */
@WebServlet(urlPatterns = "/cadastroUsuario")
public class AutoUpdateCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id1 = req.getParameter("id");
        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");
        String email = req.getParameter("email");
        String telefone = req.getParameter("telefone");
        int id = Integer.parseInt(id1);


        Cliente cli = new Cliente(id, nome, senha, email, telefone);

        boolean retorno = new ClienteDAO().update(cli);

        RequestDispatcher disp;
        if (retorno) {
            req.setAttribute("sucesso", "Cadastro tualizado com sucesso");
            disp = req.getRequestDispatcher("/WEB-INF/views/reservarMesa.jsp");
            disp.forward(req, resp);

        } else {
            req.setAttribute("erro", "Não foi possivel atualizar seus dados");
            disp = req.getRequestDispatcher("/WEB-INF/views/reservarMesa.jsp");
            disp.forward(req, resp);
        }
    }
}
