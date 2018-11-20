package br.csi.controller;

import br.csi.dao.FuncionarioDAO;
import br.csi.model.Funcionario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/updateFunc")
public class UpdateFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        Funcionario func = new Funcionario();

        func.setNome(nome);
        func.setSenha(senha);
        func.setEmail(email);

        boolean retorno = new FuncionarioDAO().update(func);

        PrintWriter resposta = resp.getWriter();
        RequestDispatcher disp;

        if (retorno) {

            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        } else {
            resposta.println("<html><body>");
            resposta.println("<strong>ERRO</strong>");
            resposta.println("</body></html>");
        }
    }
}