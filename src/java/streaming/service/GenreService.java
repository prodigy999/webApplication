/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.GenreDAO;
import streaming.entity.Genre;

/**
 *
 * @author admin
 */
public class GenreService {

    public List<Genre> listerTous() {

        GenreDAO dao = new GenreDAO();
        return dao.listerTous();
    }

    public Genre rechercheParID(long id) {

        GenreDAO dao = new GenreDAO();
        return dao.rechercheParID(id);
    }

    public void ajouterGenre(Genre g) {

        new GenreDAO().ajouterGenre(g);

    }

    public void supprimerGenre(long id) {

        new GenreDAO().supprimerGenre(id);
    }

    public void modifierGenre(Genre g) {

        new GenreDAO().modifierGenre(g);
    }

}
