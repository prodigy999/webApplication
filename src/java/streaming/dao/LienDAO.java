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
import streaming.entity.Lien;

/**
 *
 * @author admin
 */
public class LienDAO {

    public List<Lien> listerTous() {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.createQuery("SELECT l FROM Lien l").getResultList();
    }

    public Lien rechercheParID(long id) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Lien.class, id);
    }

    public void ajouterLien(Lien l) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();

        em.persist(l);

        em.getTransaction().commit();
    }

    public void supprimerLien(long id) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();

        Query q = em.createQuery("DELETE FROM Lien WHERE l.id=:idlien");
        q.setParameter("idlien", id);
        q.executeUpdate();

        em.getTransaction().commit();
    }

    public void modifierLien(Lien l) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();

        em.merge(l);

        em.getTransaction().commit();
    }
}
