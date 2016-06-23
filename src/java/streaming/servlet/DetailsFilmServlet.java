/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Film;
import streaming.service.FilmService;

/**
 *
 * @author admin
 */
@WebServlet(name = "DetailsFilm", urlPatterns = {"/detail_film"})
public class DetailsFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
       long IDFilm = Long.parseLong(req.getParameter("idFilm"));
       Film detailFilm = new FilmService().rechercheParID(IDFilm);
       req.setAttribute("film", detailFilm);
       req.getRequestDispatcher("detail_film.jsp").forward(req, resp);
    }
}