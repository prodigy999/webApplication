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
import streaming.entity.Genre;

/**
 *
 * @author admin
 */
public class GenreDAO {

    public List<Genre> listerTous() {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.createQuery("SELECT g FROM Genre g").getResultList();
    }

    public Genre rechercheParID(long id) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Genre.class, id);
    }

    public void ajouterGenre(Genre g) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();

        em.persist(g);

        em.getTransaction().commit();
    }

    public void supprimerGenre(long id) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();

        Query q = em.createQuery("DELETE FROM Genre WHERE g.id=:idgenre");
        q.setParameter("idgenre", id);
        q.executeUpdate();

        em.getTransaction().commit();
    }

    public void modifierGenre(Genre g) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();

        em.merge(g);

        em.getTransaction().commit();
    }
}
