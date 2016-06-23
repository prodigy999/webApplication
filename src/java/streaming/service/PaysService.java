/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.GenreDAO;
import streaming.dao.PaysDAO;
import streaming.entity.Pays;

/**
 *
 * @author admin
 */
public class PaysService {
    
    public List<Pays> lister() {
       
        return new PaysDAO().lister();
    }

    public Pays rechercheParID(long id) {
        
        return new PaysDAO().rechercheParID(id);
    }

    
    
}
