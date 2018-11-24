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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id1 = req.getParameter("id");
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        int id = Integer.parseInt(id1);

        Funcionario func = new Funcionario();
        func.setId(id);
        func.setNome(nome);
        func.setSenha(senha);
        func.setEmail(email);

        boolean retorno = new FuncionarioDAO().update(func);

        RequestDispatcher disp;
        if (retorno) {
            req.setAttribute("sucesso", "Funcionario atualizado com sucesso");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        } else {
            req.setAttribute("erro", "Não foi possivel atualizar Funcionario");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        }
    }
}