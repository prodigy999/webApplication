/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Saison;

/**
 *
 * @author admin
 */
public class SaisonDAO {
    
    public Saison recupDetail(long id) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Saison.class, id);
    }
    
}
