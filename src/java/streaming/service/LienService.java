/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.LienDAO;
import streaming.entity.Lien;

/**
 *
 * @author admin
 */
public class LienService {

    public List<Lien> listerTous() {

        LienDAO dao = new LienDAO();
        return dao.listerTous();
    }

    public Lien rechercheParID(long id) {

        LienDAO dao = new LienDAO();
        return dao.rechercheParID(id);
    }

    public void ajouterLien(Lien l) {

        new LienDAO().ajouterLien(l);

    }

    public void supprimerLien(long id) {

        new LienDAO().supprimerLien(id);
    }

    public void modifierLien(Lien l) {

        new LienDAO().modifierLien(l);
    }

}
