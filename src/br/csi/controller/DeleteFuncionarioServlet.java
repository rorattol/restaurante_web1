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

@WebServlet(urlPatterns = "/deleteFunc")
public class DeleteFuncionarioServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idFunc = req.getParameter("id");
        int id = Integer.parseInt(idFunc);
        Funcionario func = new Funcionario();

        boolean retorno = new FuncionarioDAO().delete(id);

        PrintWriter resposta = resp.getWriter();
        if(retorno){

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
