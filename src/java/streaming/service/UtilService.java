/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.UtilDAO;
import streaming.entity.Utilisateur;

/**
 *
 * @author admin
 */
public class UtilService {
    
    public Utilisateur rechercherLoginMDPEtatValide(String log, String mdp) throws RuntimeException {
        
        return new UtilDAO().rechercherLoginMDPEtatValide(log, mdp);
    }
    
    public void ajouterUtil (Utilisateur u) throws RuntimeException {
        
        UtilDAO  dao = new UtilDAO();
        
        List<Utilisateur> listLogExist = dao.rechercherLogin(u.getLogin());
        
        if (listLogExist.size()>0){
            throw new RuntimeException ("Ce login existe déjà");
        }
        
        List<Utilisateur> listMailExist = dao.rechercherMail(u.getMail());
        if (listMailExist.size()>0) {
            throw new RuntimeException ("Cet Email existe déjà");
        }
        dao.ajouterUtil(u);
        
        new MailService().envoyerMail(u.getMail(), "Incription au site", "Incription reussie");
        
        
    }
    
    

    
}
