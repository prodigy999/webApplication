/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Serie;
import streaming.service.SerieService;

/**
 *
 * @author admin
 */
@WebServlet(name = "DetailSerieServlet", urlPatterns = {"/detail_serie"})
public class DetailSerieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long IDSerie = Long.parseLong(req.getParameter("idSerie"));
        Serie detailSerie = new SerieService().rechercheParID(IDSerie);
        req.setAttribute("serie", detailSerie);
        req.getRequestDispatcher("detail_serie.jsp").forward(req, resp);
    }

}
