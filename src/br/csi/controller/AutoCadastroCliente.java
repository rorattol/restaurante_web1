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
import java.io.PrintWriter;

/**
 * @author Lucas
 */
@WebServlet(urlPatterns = "/cadastroUsuario")
public class AutoCadastroCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");
        String email = req.getParameter("email");
        String telefone = req.getParameter("telefone");

        boolean retorno = new ClienteDAO().create(nome, email, senha, telefone);

        RequestDispatcher disp;
        if (retorno) {
            req.setAttribute("mensagem", "Cadastro realizado com sucesso");
            disp = req.getRequestDispatcher("loginCliente.jsp");
            disp.forward(req, resp);

        } else {
            req.setAttribute("mensagem", "Não foi possivel realizar cadastro");
            disp = req.getRequestDispatcher("CriarCliente.jsp");
            disp.forward(req, resp);
        }
    }
}
