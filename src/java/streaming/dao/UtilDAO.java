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
import streaming.entity.Utilisateur;

/**
 *
 * @author admin
 */
public class UtilDAO {

    public Utilisateur rechercherLoginMDPEtatValide(String log, String mdp) throws RuntimeException {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login=:monlog AND u.motDePasse=:monmdp AND u.etat=:monetat");
        query.setParameter("monlog", log);
        query.setParameter("monmdp", mdp);
        query.setParameter("monetat", Utilisateur.Etat.VALIDE);
        
        return (Utilisateur) query.getSingleResult();
    }
    
    public List<Utilisateur> rechercherLogin(String log) throws RuntimeException {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login=:monlog ");
        query.setParameter("monlog", log);
        
        return query.getResultList();
    }
    
    public List<Utilisateur> rechercherMail(String mail) throws RuntimeException {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.mail=:monmail ");
        query.setParameter("monmail", mail);
        
        return query.getResultList();
    }
    
    public void ajouterUtil(Utilisateur u) throws RuntimeException {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        
        em.persist(u);

        em.getTransaction().commit();
    }
}
