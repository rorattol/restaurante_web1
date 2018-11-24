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

@WebServlet(urlPatterns = "/updateMesa")
public class UpdateMesaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
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
        mesa.setReservado(reservado);

        boolean realizado = new MesaDAO().update(mesa);

        RequestDispatcher disp;
        if (realizado) {
            req.setAttribute("sucesso", "Mesa atualizada com sucesso");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);

        } else {
            req.setAttribute("erro", "Nnão foi possivel atualizar mesa");
            disp = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            disp.forward(req, resp);
        }
    }


}
