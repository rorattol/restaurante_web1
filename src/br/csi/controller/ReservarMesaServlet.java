package br.csi.controller;

import br.csi.dao.MesaDAO;
import br.csi.model.Mesa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reservaMesa")
public class ReservarMesaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("idMesa");
        String reserv = req.getParameter("reservado");
        String num = req.getParameter("numMesa");
        String lug = req.getParameter("lugares");

        int idMesa = Integer.parseInt(id);
        int numMesa = Integer.parseInt(num);
        int lugares = Integer.parseInt(lug);
        Boolean reservado = Boolean.parseBoolean(reserv);


        Mesa mesa = new Mesa();
        mesa.setId(idMesa);
        mesa.setNumMesa(numMesa);
        mesa.setLugares(lugares);
        mesa.setReservado(!reservado);

        boolean realizado = new MesaDAO().update(mesa);

        RequestDispatcher disp;

        //VERIFICAR SE É USUARIO OU FUNCIONARIO CADASTRADO

        if (realizado) {

            disp = req.getRequestDispatcher("index.jsp");
            disp.forward(req, resp);

        } else {

            req.setAttribute("mensagem", "não foi possivel atualizar");
            disp = req.getRequestDispatcher("reservarMesa.jsp");
            disp.forward(req, resp);

        }
    }


}
