/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

/**
 *
 * @author admin
 */
public class MailService {
    
    public void envoyerMail (String mailDest, String titre, String message){
        
        System.out.println("un Mail de confirmation à été envoyé à : "+ mailDest);
        System.out.println("Titre : " + titre);
        System.out.println("Message : " + message);
    }
    
}
