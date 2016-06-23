/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import streaming.entity.Film;

/**
 *
 * @author admin
 */
public class FilmDAO {

    public List<Film> listerTous() {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.createQuery("SELECT f FROM Film f").getResultList();
    }

    public Film rechercheParID(long id) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Film.class, id);
    }

    public void ajouterFilm(Film f) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();

        em.persist(f);

        em.getTransaction().commit();
    }

    public void supprimerFilm(long id) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();

        Query q = em.createQuery("DELETE FROM Film WHERE f.id=:idfilm");
        q.setParameter("idfilm", id);
        q.executeUpdate();

        em.getTransaction().commit();
    }

    public void modifierFilm(Film f) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();

        em.merge(f);

        em.getTransaction().commit();
    }

}
