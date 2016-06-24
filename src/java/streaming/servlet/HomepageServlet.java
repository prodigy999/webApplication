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

/**
 *
 * @author admin
 */
@WebServlet(name = "HomepageServlet", urlPatterns = {"/home"})
public class HomepageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Cookie c;
        
        //c= new Cookie("login", " ");
        //c.setMaxAge(0);
        //resp.addCookie(c);
        
        //c= new Cookie("utilType", " ");
        //c.setMaxAge(0);
        //resp.addCookie(c);
        
        //c= new Cookie("motdepasse", " ");
        //c.setMaxAge(0);
        //resp.addCookie(c);
        
        c = new Cookie("style_cookie", " ");
        c.setMaxAge(0);
        resp.addCookie(c);
        
        req.getSession().removeAttribute("UtilConnecte");
        
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

     
    

    

}
