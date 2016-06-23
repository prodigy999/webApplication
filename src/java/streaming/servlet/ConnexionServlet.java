/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Utilisateur;
import streaming.service.UtilService;

/**
 *
 * @author admin
 */
@WebServlet(name = "ConnexionServlet", urlPatterns = {"/login"})
public class ConnexionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String log = req.getParameter("login");
            String mdp = req.getParameter("motDePasse");
            Utilisateur u = new UtilService().rechercherLoginMDPEtatValide(log, mdp);
               
            resp.addCookie(new Cookie("utilType", u.getTypeUtil().toString()));
            resp.addCookie(new Cookie("login", log));
            resp.addCookie(new Cookie("motdepasse", mdp));
            
            
            resp.sendRedirect("Lister_Films");
        } 
        
        catch (RuntimeException e) {
            
            resp.sendRedirect("connexion");
        }
        
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("connexion.jsp").forward(req, resp);
    }
}
