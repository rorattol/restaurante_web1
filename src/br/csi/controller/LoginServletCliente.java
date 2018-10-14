/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

import br.csi.dao.LoginDAO;
import br.csi.dao.ClienteDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lucas
 */
//login true = rorattol@gmail.com senha: 123455


@WebServlet(urlPatterns = "/loginCliente")
public class LoginServletCliente extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String login = req.getParameter("login"); //nome do name='login' 
        String senha = req.getParameter("senha");
        
        System.out.println(login + " - "+ senha);

        boolean autenticado = new LoginDAO().autenticarCliente(login, senha);

        RequestDispatcher disp;
        
        if(autenticado){
            
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuarioLogado", new ClienteDAO().read(login, senha));
            
            disp = req.getRequestDispatcher("/WEB-INF/views/sucesso.jsp");
            disp.forward(req, resp);
        }
        else{
            req.setAttribute("mensagem", "usuario ou senha incorretos");
            disp = req.getRequestDispatcher("loginCliente.jsp");
            disp.forward(req, resp);
            
        }
    }
    
    
    
    
}
