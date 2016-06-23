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
import streaming.entity.Saison;
import streaming.service.SaisonService;

/**
 *
 * @author admin
 */
@WebServlet(name = "DetailSaisonServlet", urlPatterns = {"/detail_saison"})
public class DetailSaisonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long IDSaison = Long.parseLong(req.getParameter("idSaison"));
        Saison detailSaison = new SaisonService().detailSaison(IDSaison);
        req.setAttribute("saison", detailSaison);
        req.getRequestDispatcher("detail_serie.jsp").forward(req, resp);
    }

}
