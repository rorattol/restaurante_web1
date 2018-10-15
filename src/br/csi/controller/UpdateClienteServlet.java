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

@WebServlet(urlPatterns = "/updateCliente")
public class UpdateClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");
        String email = req.getParameter("email");
        String telefone = req.getParameter("telefone");

        Cliente cli = new Cliente();

        cli.setNomeCliente(nome);
        cli.setSenhaCliente(senha);
        cli.setEmailCliente(email);
        cli.setTelefoneCliente(telefone);

        boolean retorno = new ClienteDAO().update(cli);

        PrintWriter resposta = resp.getWriter();
        RequestDispatcher disp;

        if (retorno) {

            disp = req.getRequestDispatcher("/WEB-INF/views/sucesso.jsp");
            disp.forward(req, resp);
        } else {
            resposta.println("<html><body>");
            resposta.println("<strong>ERRO</strong>");
            resposta.println("</body></html>");
        }
    }
}