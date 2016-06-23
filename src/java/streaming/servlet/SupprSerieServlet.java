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
import streaming.service.SerieService;

/**
 *
 * @author admin
 */
@WebServlet(name = "SupprSerieServlet", urlPatterns = {"/suppr_serie"})
public class SupprSerieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        long IDSerie = Long.parseLong(req.getParameter("idSerie"));
        new SerieService().supprimerSerie(IDSerie);
        
        resp.sendRedirect("Lister_Series");
    }

}
