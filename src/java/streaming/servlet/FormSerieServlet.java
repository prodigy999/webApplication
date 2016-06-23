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
import streaming.entity.Genre;
import streaming.entity.Pays;
import streaming.entity.Serie;
import streaming.service.GenreService;
import streaming.service.PaysService;
import streaming.service.SerieService;

/**
 *
 * @author admin
 */
@WebServlet(name = "FormSerieServlet", urlPatterns = {"/ajout_serie"})
public class FormSerieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Serie newSerie = new Serie();
        newSerie.setTitre(req.getParameter("titre"));
        newSerie.setSynopsis(req.getParameter("synopsis"));

        long genreId = Long.parseLong(req.getParameter("genre_id"));
        Genre genre = new GenreService().rechercheParID(genreId);
        genre.getSeries().add(newSerie);
        newSerie.setGenre(genre);

        long paysId = Long.parseLong(req.getParameter("pays_id"));
        Pays pays = new PaysService().rechercheParID(paysId);
        newSerie.setPays((List<Pays>) pays);
        pays.getSeriesProduits().add(newSerie);

        new SerieService().ajouterSerie(newSerie);

        resp.sendRedirect("Lister_Series");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Genre> serieGenre = new GenreService().listerTous();
        req.setAttribute("genres", serieGenre);

        List<Pays> seriePays = new PaysService().lister();
        req.setAttribute("pays", seriePays);

        req.getRequestDispatcher("ajout_serie.jsp").forward(req, resp);
    }

}
