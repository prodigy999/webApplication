/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.FilmDAO;
import streaming.entity.Film;

/**
 *
 * @author admin
 */
public class FilmService {

    public List<Film> listerTous() {

        FilmDAO dao = new FilmDAO();
        return dao.listerTous();
    }

    public Film rechercheParID(long id) {

        FilmDAO dao = new FilmDAO();
        return dao.rechercheParID(id);
    }

    public void ajouterFilm(Film f) {

        new FilmDAO().ajouterFilm(f);

    }

    public void supprimerFilm(long id) {

        new FilmDAO().supprimerFilm(id);
    }
    
    public void modifierFilm(Film f) {
        
        new FilmDAO().modifierFilm(f);
    }
}
