/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.controller;

import br.csi.dao.LoginDAO;
import br.csi.dao.FuncionarioDAO;
import br.csi.model.Funcionario;

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


@WebServlet(urlPatterns = "/loginFunc")
public class LoginServletFuncionario extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String login = req.getParameter("login"); //nome do name='login' 
        String senha = req.getParameter("senha");
        
        System.out.println(login + " - "+ senha);
        
        Funcionario autenticado = new LoginDAO().autenticarFuncionario(login, senha);

        RequestDispatcher disp;
        
        if(autenticado.getId() != 0){
            
            HttpSession sessao = req.getSession();
            sessao.setAttribute("logado", autenticado);
            
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        }
        else{
            req.setAttribute("mensagem", "usuario ou senha incorretos");
            disp = req.getRequestDispatcher("loginFunc.jsp");
            disp.forward(req, resp);
            
        }
    }
}
