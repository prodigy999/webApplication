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
import streaming.entity.Genre;
import streaming.entity.Pays;
import streaming.service.FilmService;
import streaming.service.GenreService;
import streaming.service.PaysService;

/**
 *
 * @author admin
 */
@WebServlet(name = "FormServlet", urlPatterns = {"/ajout_film"})
public class FormFilmServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Film newFilm = new Film();
        newFilm.setTitre(req.getParameter("titre"));
        newFilm.setAnnee(Integer.parseInt(req.getParameter("anneeProd")));

        long genreId = Long.parseLong(req.getParameter("genre_id"));
        Genre genre = new GenreService().rechercheParID(genreId);
        genre.getFilms().add(newFilm);
        newFilm.setGenre(genre);

        long paysId = Long.parseLong(req.getParameter("pays_id"));
        Pays pays = new PaysService().rechercheParID(paysId);
        newFilm.setPays((List<Pays>) pays);
        pays.getFilmsProduits().add(newFilm);

        new FilmService().ajouterFilm(newFilm);

        resp.sendRedirect("Lister_Films");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Genre> filmGenre = new GenreService().listerTous();
        req.setAttribute("genres", filmGenre);

        List<Pays> filmPays = new PaysService().lister();
        req.setAttribute("pays", filmPays);

        req.getRequestDispatcher("ajout_film.jsp").forward(req, resp);
    }

}
